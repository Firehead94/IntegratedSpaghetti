/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Beans.Registration;
import Beans.Section;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Justin
 */
public class RegistrationDB {
    
    public static Registration getRegistrationByStudentAndSection(int student_ID, int section_num) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM REGISTRATION " +
                "WHERE STU_ID = ? AND SECTION_NUM = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, Integer.toString(section_num));
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getFromDB(ps);        
    }
    
    public static ArrayList<Registration> getRegistrationByStudent(int student_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM REGISTRATION " +
                "WHERE STU_ID = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, Integer.toString(student_ID));
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getListFromDB(ps);           
    }
    
    public static ArrayList<Registration> getRegistrationBySection(int section_num) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM REGISTRATION " +
                "WHERE SECTION_NUM = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, Integer.toString(section_num));
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getListFromDB(ps);         
    }
    
    public static ArrayList<Registration> getRegistrationByFacultyint(int faculty_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM REGISTRATION r, SECTION s " +
                "WHERE r.SECTION_NUM = s.SECTION_NUM AND s.FACULTY_ID = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, Integer.toString(faculty_ID));
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getListFromDB(ps);         
    }
    
    private static Registration getFromDB (PreparedStatement ps) {
        
        ResultSet rs = null;
        Registration registration = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {                
                registration = new Registration();
                
                registration.setGpa(rs.getInt("GPA"));
                registration.setGrade(rs.getString("GRADE"));
                registration.setSection_num(rs.getInt("SECTION_NUM"));
                registration.setStu_ID(rs.getInt("STU_ID"));

            }
        } catch (SQLException e) {
            Logger.getLogger(CourseDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closeResultSet(rs);
        }
        return registration;        
    }
    
    private static ArrayList<Registration> getListFromDB (PreparedStatement ps) {
        
        ResultSet rs = null;
        ArrayList<Registration> registrations = null;
        try {
            rs = ps.executeQuery();
            registrations = new ArrayList<Registration>();
            if (rs.next()) {                
                Registration registration = new Registration();
                
                registration.setGpa(rs.getInt("GPA"));
                registration.setGrade(rs.getString("GRADE"));
                registration.setSection_num(rs.getInt("SECTION_NUM"));
                registration.setStu_ID(rs.getInt("STU_ID"));
                
                registrations.add(registration);

            }
        } catch (SQLException e) {
            Logger.getLogger(CourseDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closeResultSet(rs);
        }
        return registrations;          
    }
    
}
