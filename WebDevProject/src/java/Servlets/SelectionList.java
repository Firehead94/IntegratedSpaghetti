
package Servlets;

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
@WebServlet(name = "SelectionList", urlPatterns = {"/SelectionList"})
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
        String url = "/selectionList.jsp";
        
        Map<Section, Course> selectedList = null;
        String error_msg = null;
        
//GET A LIST OF CHECKBOXED VALUES FROM JSP
//      {
        if (/*list of vals*/ != null) {
            selectedList = new HashMap<Section, Course>();
            for (int tmp : /*list of vals*/) {
                Section section = SectionDB.getSectionBySectionNum(tmp);
                selectedList.put(section, CourseDB.getCourseByCourseIDAndDeptID(section.getCourse_ID(), section.getDept_ID()));
            }
        }else {
            error_msg = "No courses were selected.";
        }
//      }       
            
        request.setAttribute("errormsg", error_msg);
        request.getSession().setAttribute("selectedlist", selectedList);
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }

}
