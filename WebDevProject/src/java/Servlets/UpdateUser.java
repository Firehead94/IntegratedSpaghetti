/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.User;
import DataBase.UserDB;
import Hash.MD5;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Justin
 */
public class UpdateUser extends HttpServlet {

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
        String url = "/profile";
        String error_msg = null;
        
        Map<String, String[]> map = request.getParameterMap();
        SimpleDateFormat sf = new SimpleDateFormat("MM-dd-yyyy");
        if (map.containsKey("save")) {
            if (map.get("Password")[0].equals(map.get("PasswordConfirm")[0])) {
                User user = (User)request.getSession().getAttribute("user");
                user.setUser_address(map.get("Address")[0]);
                user.setUser_city(map.get("City")[0]);
                user.setUser_state(map.get("State")[0]);
                user.setUser_zip(Integer.parseInt(map.get("Zip")[0]));
                user.setUser_first_name(map.get("FirstName")[0]);
                user.setUser_last_name(map.get("LastName")[0]);
                try {
                    user.setUser_dob(sf.parse(map.get("DOB")[0]).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(UpdateUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                UserDB.updateUser(user);
                
            }else {
                error_msg = "Passwords did not match";
            }                    
        }
        
        
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }
}
