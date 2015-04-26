
package Servlets;

import DataBase.RegistrationDB;
import Utils.GpaCalculator;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
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
        
        boolean success = true;
        for(String studentId : map.get("listCounter")) {
            Integer stu_ID = Integer.parseInt(studentId);
            String grade = map.get(String.valueOf(stu_ID))[0];
            System.err.println(request.getParameter("selectedSection"));
            Integer section = Integer.parseInt(request.getParameter("selectedSection"));
            if(GpaCalculator.validGrade(grade)) {
                double gpa = GpaCalculator.calcGpa(grade);
                RegistrationDB.updateRegistrationByStudentIDAndSectionNum(stu_ID, section, gpa, grade);
            }
            else
                    success = false;
        }
        if(!success) {
            request.setAttribute("errormsg","Failed to set values. Incorrect Grade input.");
            url = "/grades";
        }
        
        getServletContext()
            .getRequestDispatcher(url) //.getRequestRedirect for php
            .forward(request, response);
    }

}
