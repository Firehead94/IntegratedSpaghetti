/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Course;
import Beans.Section;
import Beans.User;
import DataBase.PrivilegeDB;
import DataBase.RegistrationDB;
import DataBase.SectionDB;
import DataBase.StudentDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Justin
 */
public class UpdateSelection extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/viewSelection.jsp";
        Map<String, String[]> map = request.getParameterMap();
        User user = (User)request.getSession().getAttribute("user");
        
        if (request.getSession().getAttribute("selectedlist") != null && map.get("selected") != null) {
            Map<Section, Course> secMap = (Map<Section, Course>)request.getSession().getAttribute("selectedlist");
            if (map.containsKey("Remove")) {
                for (String str : map.get("selected")) {
                    secMap.remove(SectionDB.getSectionBySectionNum(Integer.parseInt(str)));              
                }
            }else if (map.containsKey("Register")) {
                if (!PrivilegeDB.isStudentByUser(user)) {
                    PrivilegeDB.newStudent(user.getUser_ID(), 12);
                }
                for (Map.Entry<Section, Course> tmp : secMap.entrySet()) {
                    if(SectionDB.isAlreadyRegistered(user.getUser_ID(), tmp.getKey().getSection_num()));
                        RegistrationDB.register(PrivilegeDB.getStudentIDByUserID(user.getUser_ID()), tmp.getKey().getSection_num());
                }

                StudentDB.updateBalance(user.getUser_ID(), StudentDB.getCourseCreditsAndCost(user.getUser_ID()));
                request.getSession().removeAttribute("selectedlist");                
                              
            }           
        }

        getServletContext()
            .getRequestDispatcher(url) 
            .forward(request, response);
    }


}
