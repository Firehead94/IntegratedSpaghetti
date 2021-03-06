
package Servlets;

import DataBase.UserDB;
import Hash.MD5;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
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
public class Login extends HttpServlet {

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
        String url = "";
        
        //String action = request.getParameterValues("action")[0];
        Map<String,String[]> map = request.getParameterMap();
        HttpSession session = request.getSession();
        
        if (map.containsKey("loginInfo")) {
            
            String hash = null;

            String username = map.get("loginInfo")[0];
            String password = map.get("loginInfo")[1];
            
            hash = new MD5(password).getHash();            
            
            if(hash != null && UserDB.validateUser(username, hash)) {               
                url = "/index.jsp";
                session.setAttribute("user",UserDB.getUserByUsername(username).get(0));                
            }
            if (request.getSession().getAttribute("selectedlist") != null) {
                request.getSession().removeAttribute("selectedlist"); 
            }

            
        }
        
        
        
        
                // forward request and response objects to specified URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }


}
