
package Servlets;

import Beans.Cart;
import Beans.Course;
import Beans.Section;
import DataBase.CourseDB;
import DataBase.SectionDB;
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

public class SelectionList extends HttpServlet {

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
        Map<Section, Course> selectedList = null;
        Cart cart = new Cart();
        String error_msg = null;
        Section section = null;
        
        if (request.getSession().getAttribute("selectedlist") != null) {
            selectedList = (Map<Section, Course>)request.getSession().getAttribute("selectedlist");
        }else {
            selectedList = new HashMap<Section, Course>();
        }
        
        if (map.get("selectedCourses") != null) {
            
            for (String tmp : map.get("selectedCourses")) {
                section = SectionDB.getSectionBySectionNum(Integer.parseInt(tmp));
                selectedList.put(section, CourseDB.getCourseBySectionID(Integer.parseInt(tmp)));
            }
        }else {
            error_msg = "No courses were selected.";
        }
            
        request.setAttribute("errormsg", error_msg);
        request.getSession().setAttribute("selectedlist", selectedList);
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }

}
