
package Servlets;

import Beans.Course;
import Beans.Registration;
import Beans.Section;
import Beans.User;
import DataBase.CourseDB;
import DataBase.PrivilegeDB;
import DataBase.RegistrationDB;
import DataBase.SectionDB;
import DataBase.UserDB;
import Utils.GpaCalculator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

public class FinalizeGrades extends HttpServlet {

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

        String url = "/home";
        
        Map<String,String[]> map = request.getParameterMap();
        
        int counter = 0;
        boolean success = true;
        while(map.containsKey(String.valueOf(counter))) {
            Integer stu_ID = Integer.parseInt(map.get(String.valueOf(counter))[0]);
            String grade = map.get(String.valueOf(stu_ID))[0];
            System.err.println(request.getParameter("selectedSection"));
//            Integer section = Integer.parseInt(request.getParameter("selectedSection"));
//            if(GpaCalculator.validGrade(grade)) {
//                double gpa = GpaCalculator.calcGpa(grade);
//                RegistrationDB.updateRegistrationByStudentIDAndSectionNum(stu_ID, section, gpa, grade);
//                if(success)
//                    success = true;
//                else
//                    success = false;
//            }
            counter++;
        }
        
        request.setAttribute("success",success);
        
        getServletContext()
            .getRequestDispatcher(url) //.getRequestRedirect for php
            .forward(request, response);
    }

}
