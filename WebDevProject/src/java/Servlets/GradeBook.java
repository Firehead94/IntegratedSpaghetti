
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
        String url = "/error_404.jsp";
        
        User user = UserDB.getUserByUsername(((User)request.getSession().getAttribute("user")).getUsername()).get(0);
//        Map<Registration, HashMap<Course, User>> grades = null;
//        grades = new HashMap<Registration, HashMap<Course, User>>();
        if (user.isFaculty()) { //Is Teacher   ]
            url = "/gradeBook.jsp";
            if(request.getParameterMap().containsKey("selectedSection")){
                ArrayList<Registration> regList = RegistrationDB.getRegistrationBySection(Integer.parseInt(request.getParameter("selectedSection")));
                Map<Integer, String> students = new HashMap<>();
                for(Registration registrar : regList) {
                    students.put(registrar.getStu_ID(), UserDB.getNameByStudentID(registrar.getStu_ID()));
                }
                request.setAttribute("students",RegistrationDB.getRegistrationBySection(Integer.parseInt(request.getParameter("selectedSection"))));
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
            
        }else if(user.isStudent()) { //Is Student
            for (Registration tmp : RegistrationDB.getRegistrationByStudent(PrivilegeDB.getStudentIDByUserID(user.getUser_ID()))) {
                HashMap<Course, User> map = new HashMap<Course, User>();
                map.put(CourseDB.getCourseByCourseIDAndDeptID((SectionDB.getSectionBySectionNum(tmp.getSection_num())).getCourse_ID(), (SectionDB.getSectionBySectionNum(tmp.getSection_num())).getDept_ID()), user);
                //grades.put(tmp, map);
                url = "/grades.jsp";
            }
        }
        
      //  request.setAttribute("grades", grades);
        getServletContext()
            .getRequestDispatcher(url) //.getRequestRedirect for php
            .forward(request, response);
    }

}
