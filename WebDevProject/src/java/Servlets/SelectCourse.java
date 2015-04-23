
package Servlets;

import Beans.Course;
import Beans.Section;
import DataBase.CourseDB;
import DataBase.DepartmentDB;
import DataBase.SectionDB;
import java.io.IOException;
import java.io.PrintWriter;
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
public class SelectCourse extends HttpServlet {

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
        String url = "/index.jsp";
        
        Map<String, String[]> map = request.getParameterMap();
        
        Map<Section, Course> sectionList = null;
        
        String sectionNum = map.get("SectionNum")[0];
        String courseNum = map.get("CourseNum")[0];
        String dept = map.get("deptlist")[0];
        String semester = map.get("semesterlist")[0];
        
        if (!sectionNum.equals("")) {
            sectionList.put(SectionDB.getSectionBySectionNum(Integer.parseInt(sectionNum)),CourseDB.getCourseBySectionID(Integer.parseInt(sectionNum)));
        } else if (!semester.equals("")){
            sectionList = SectionDB.getSectionsByCourseIDAndDeptIDAndSemester(Integer.parseInt(courseNum), DepartmentDB.getDeptIDFromAbr(dept), Integer.parseInt(semester));
        } else {
            sectionList = SectionDB.getSectionsByCourseIDAndDeptID(Integer.parseInt(courseNum), DepartmentDB.getDeptIDFromAbr(dept));
        }
                
        request.getSession().setAttribute("sectionlist", sectionList);
        
        getServletContext()
            .getRequestDispatcher(url) 
            .forward(request, response);
    }

}
