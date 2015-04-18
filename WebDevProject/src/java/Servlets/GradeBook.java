
package Servlets;

import Beans.Registration;
import Beans.User;
import DataBase.RegistrationDB;
import DataBase.UserDB;
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

public class GradeBook extends HttpServlet {

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
        String url = "/gradeBook.jsp";
        
        User user = /*GET USER FROM SESSION*/;
        Map<Registration, User> grades = null;
        
        if (user.getFaculty_ID() != 0) { //Is Teacher
            grades = new HashMap<Registration, User>();
            for (Registration tmp : RegistrationDB.getRegistrationByFacultyint(user.getFaculty_ID())) {
                grades.put(tmp, UserDB.getUserByStudentID(tmp.getStu_ID()));
            }
            
        }else { //Is Student
            
        }
        
        
        getServletContext()
            .getRequestDispatcher(url) //.getRequestRedirect for php
            .forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
