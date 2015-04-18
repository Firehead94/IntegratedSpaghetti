/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Beans.Course;
import Beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Justin
 */
public class CourseDB {
        
    /**
     * Gets a course based on the courses ID.
     * 
     * @param course_ID
     * @return 
     */
    public static Course getCourseByCourseIDAndDeptID (int course_ID, int dept_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM COURSE " +
                "WHERE COURSE_ID = ? AND DEPT_ID = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, Integer.toString(course_ID));
        ps.setString(2, Integer.toString(dept_ID));
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getFromDB(ps);
    }
    
    /**
     * Gets a list of courses in a certain department.
     * 
     * @param dept_ID
     * @return 
     */
    public static ArrayList<Course> getCoursesByDepartment (int dept_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM COURSE " +
                "WHERE DEPT_ID = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, Integer.toString(dept_ID));
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getListFromDB(ps);
    }
    
    /**
     * Gets a list of courses in a certain department.
     * 
     * @param dept_ID
     * @return 
     */
    public static ArrayList<Course> getCoursesByDepartment (String dept_abr) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM COURSE c, DEPARTMENT d " +
                "WHERE c.DEPT_ID = d.DEPT_ID AND d.DEPT_ABR = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, dept_abr);
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getListFromDB(ps);
    }
    
    /**
     * Gets a course list for a certain user.
     * 
     * @param user
     * @return 
     */
    public static ArrayList<Course> getCoursesByUser (User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM COURSE c, REGISTRATION r " +
                "WHERE c.COURSE_ID = r.COURSE_ID && r.STU_ID = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, Integer.toString(user.getStu_ID()));
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getListFromDB(ps);
    }

    /**
     * Gets a course from a DB based on a prepared statement.
     * @param ps
     * @return 
     */
    private static Course getFromDB(PreparedStatement ps) {
        
        ResultSet rs = null;
        Course course = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {                
                course = new Course();
                
                course.setCourse_ID(rs.getInt("COURSE_ID"));
                course.setCourse_cost(rs.getInt("COURSE_COST"));
                course.setCourse_credits(rs.getInt("COURSE_CREDITS"));
                course.setCourse_title(rs.getString("COURSE_TITLE"));
                course.setDept_ID(rs.getInt("DEPT_ID"));
            }
        } catch (SQLException e) {
            Logger.getLogger(CourseDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closeResultSet(rs);
        }
        return course;
    }   
    
    /**
     * Gets a list of courses from a DB based on a prepared statement.
     * @param ps
     * @return 
     */    
    private static ArrayList<Course> getListFromDB(PreparedStatement ps) {
        ResultSet rs = null;
        ArrayList<Course> courses = null;
        try {
            rs = ps.executeQuery();
            courses = new ArrayList<Course>();
            while (rs.next()) {                                
                Course course = new Course();
                
                course.setCourse_ID(rs.getInt("COURSE_ID"));
                course.setCourse_cost(rs.getInt("COURSE_COST"));
                course.setCourse_credits(rs.getInt("COURSE_CREDITS"));
                course.setCourse_title(rs.getString("COURSE_TITLE"));
                course.setDept_ID(rs.getInt("DEPT_ID"));
                
                courses.add(course);
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closeResultSet(rs);
        }
        return courses;
    }
    
    
}
