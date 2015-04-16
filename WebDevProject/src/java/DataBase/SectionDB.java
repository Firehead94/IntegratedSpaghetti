/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Beans.Financial;
import Beans.Section;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Justin
 */
public class SectionDB {
    
    public static Section getSectionBySectionNum (int section_num) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM SECTION " +
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
        return getFromDB(ps);
    }
    
    public static ArrayList<Section> getSectionsByCourseID(int course_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM SECTION " +
                "WHERE COURSE_ID = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, Integer.toString(course_ID));
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getListFromDB(ps);
    }
    
    public static ArrayList<Section> getSectionsByDay(int dayCode) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM SECTION " +
                "WHERE SECTION_DAY = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, Integer.toString(dayCode));
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getListFromDB(ps);       
    }
    
    public static ArrayList<Section> getSectionsByTime(Time min, Time max) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM SECTION " +
                "WHERE SECTION_TIME BETWEEN ? AND ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, Long.toString(min.getTime()));
        ps.setString(1, Long.toString(max.getTime()));
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getListFromDB(ps);         
    }
    
    public static ArrayList<Section> getSectionByFacultyID(int faculty_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM SECTION " +
                "WHERE FACULTY_ID = ?";
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
    
    public static ArrayList<Section> getSectionsByLocation(String location) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM SECTION " +
                "WHERE SECTION_LOCATION = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, location);
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getListFromDB(ps);          
    }
    
    private static Section getFromDB(PreparedStatement ps) {
        
        ResultSet rs = null;
        Section section = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {                
                section = new Section();
                
                section.setCourse_ID(rs.getInt("COURSE_ID"));
                section.setFaculty_ID(rs.getInt("FACULTY_ID"));
                section.setSection_day(rs.getInt("SECTION_DAY"));
                section.setSection_location(rs.getString("SECTION_LOCATION"));
                section.setSection_time(rs.getTime("SECTION_TIME"));
                section.setSection_num(rs.getInt("SECTION_NUM"));

            }
        } catch (SQLException e) {
            Logger.getLogger(CourseDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closeResultSet(rs);
        }
        return section;
    }
    
    private static ArrayList<Section> getListFromDB(PreparedStatement ps) {
        
        ResultSet rs = null;
        ArrayList<Section> sections = null;
        try {
            rs = ps.executeQuery();
            sections = new ArrayList<Section>();
            while (rs.next()) {                
                Section section = new Section();
                
                section.setCourse_ID(rs.getInt("COURSE_ID"));
                section.setFaculty_ID(rs.getInt("FACULTY_ID"));
                section.setSection_day(rs.getInt("SECTION_DAY"));
                section.setSection_location(rs.getString("SECTION_LOCATION"));
                section.setSection_time(rs.getTime("SECTION_TIME"));
                section.setSection_num(rs.getInt("SECTION_NUM"));
                
                sections.add(section);

            }
        } catch (SQLException e) {
            Logger.getLogger(CourseDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closeResultSet(rs);
        }
        return sections;
    }
    
}
