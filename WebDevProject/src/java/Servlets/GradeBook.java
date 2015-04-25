
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
        User user = null;
        if(request.getSession().getAttribute("user")!=null) {
            user = UserDB.getUserByUsername(((User)request.getSession().getAttribute("user")).getUsername()).get(0);
            if (user!= null && user.isFaculty()) { //Is Teacher   ]
                if(request.getParameterMap().containsKey("selectedSection")){
                    String selectedSection = request.getParameter("selectedSection");
                    int sectionInt = Integer.parseInt(request.getParameter("selectedSection"));
                    ArrayList<Registration> regList = RegistrationDB.getRegistrationBySection(sectionInt);
                    request.setAttribute("students",regList);
                    request.setAttribute("selectedSection",selectedSection);
                }
                else {
    //            for (Registration tmp : RegistrationDB.getRegistrationByFacultyint(PrivilegeDB.getFacultyByUserID(user.getUser_ID()))) {
    //                HashMap<Course, User> map = new HashMap<Course, User>();
    //                map.put(CourseDB.getCourseByCourseIDAndDeptID((SectionDB.getSectionBySectionNum(tmp.getSection_num())).getCourse_ID(), (SectionDB.getSectionBySectionNum(tmp.getSection_num())).getDept_ID()), user);
    //                grades.put(tmp, map);
                    Map<Section,Course> sectionMap = SectionDB.getSectionByFacultyID(PrivilegeDB.getFacultyByUserID(user.getUser_ID()));
                    request.setAttribute("sections",sectionMap);
                }   
    //            }

            }else if(user!= null && user.isStudent()) { //Is Student
                HashMap<Course, User> map = new HashMap<Course, User>();
                for (Registration tmp : RegistrationDB.getRegistrationByStudent(PrivilegeDB.getStudentIDByUserID(user.getUser_ID()))) {
                    map.put(CourseDB.getCourseByCourseIDAndDeptID((SectionDB.getSectionBySectionNum(tmp.getSection_num())).getCourse_ID(), (SectionDB.getSectionBySectionNum(tmp.getSection_num())).getDept_ID()), user);
                    request.setAttribute("grades",map);
                    url = "/grades.jsp";
                }
            }
        } else {
            request.setAttribute("errormsg","User is not logged in");
        }
        
      //  request.setAttribute("grades", grades);
        getServletContext()
            .getRequestDispatcher(url) //.getRequestRedirect for php
            .forward(request, response);
    }

}
