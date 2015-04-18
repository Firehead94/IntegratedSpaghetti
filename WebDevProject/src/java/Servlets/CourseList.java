package Servlets;

import Beans.Course;
import Beans.Section;
import DataBase.CourseDB;
import DataBase.DepartmentDB;
import DataBase.SectionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Justin
 */
public class CourseList extends HttpServlet {

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
        String url = "/courseList.jsp";
        
        Map<Section, Course> sectionList = null;
        String error_msg = null;
        
        //Must fill dept_abr AND course_ID or section_num
        String dept_abr = null;
        int course_id = 0;
        int section_num = 0;
        
//GET INFO FROM JSP HERE
//      {
        
//      }

        if (dept_abr != null && course_id == 0) {
            sectionList = new HashMap<Section, Course>(SectionDB.getSectionsByDeptAbr(dept_abr));
        }else if (course_id != 0 && dept_abr != null) {
            sectionList = new HashMap<Section, Course>(SectionDB.getSectionsByCourseIDAndDeptID(course_id, DepartmentDB.getDeptIDFromAbr(dept_abr)));
        }else if (section_num != 0) {
            sectionList = new HashMap<Section, Course>();
            Section section = SectionDB.getSectionBySectionNum(section_num);
            sectionList.put(section, CourseDB.getCourseByCourseIDAndDeptID(section.getCourse_ID(), section.getDept_ID()));
        }
        if (sectionList == null){
            error_msg = "No Section Avaialable.";            
        }
        
        
        request.setAttribute("errormsg", error_msg);
        request.setAttribute("sectionlist", sectionList);
        
        getServletContext()
            .getRequestDispatcher(url) 
            .forward(request, response);
    }

}
