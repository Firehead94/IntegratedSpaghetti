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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Justin
 */
public class CreateAccount extends HttpServlet {

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
        
        Map<String, String[]> map = request.getParameterMap();
        boolean exists = false;
        System.out.print("creating sumthing maybe");
        System.out.println(map.keySet());

        System.out.print("creating");
        User user = new User(); 
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");

        user.setUser_first_name(map.get("FirstName")[0]);
        user.setUser_last_name(map.get("LastName")[0]);
        user.setUser_address(map.get("Address")[0]);
        user.setUser_city(map.get("City")[0]);
        user.setUser_state(map.get("State")[0]);
        user.setUser_zip(Integer.parseInt(map.get("Zip")[0]));
        user.setUser_country(map.get("Country")[0]);
        try {
            user.setUser_dob(sf.parse(map.get("DOB")[0]));
        } catch (ParseException ex) {
            Logger.getLogger(CreateAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

        user.setUsername(user.getUser_last_name() + "." + user.getUser_first_name());
        user.setUser_email(user.getUsername() + "@fsu.edu");

        if (!UserDB.userExists(user.getUser_email())) {
            System.out.println(map.get("Password")[0]);
            MD5 hash = new MD5(map.get("Password")[0]);
            UserDB.insertUser(user, hash.getHash());
        } else {
            exists = true;
        }
        System.out.println("Created!!!");
        request.getSession().setAttribute("user", UserDB.getUserByEmail(user.getUser_email()));
        
        
        request.setAttribute("exists", exists);
        
        getServletContext()
            .getRequestDispatcher("/index.jsp")
            .forward(request, response);
    }


}
