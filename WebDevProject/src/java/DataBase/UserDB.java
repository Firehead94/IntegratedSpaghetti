/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Justin
 */
public class UserDB {
    
    /**
     * Validates a users login information. Will return true if the user has 
     * entered the correct credentials.
     * 
     * @param username Username entered in by user
     * @param hash UD5 hash generated from password
     * @return 
     */
    public static boolean validateUser(String username, String hash) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT COUNT(*) FROM USERS " +
                       "WHERE USERNAME = ? AND PASSWORD = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, hash);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
    }
    
    /**
     * Gets a user by their student id.
     * 
     * @param student_ID
     * @return 
     */
    public static User getUserByStudentID(int student_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM USERS " +
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
        return getFromDB(ps);
    }
    
    /**
     * Gets a user by their faculty id.
     * 
     * @param faculty_ID
     * @return 
     */
    public static User getUserByFacultyID(int faculty_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM USERS " +
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
        return getFromDB(ps);
    }
    
    /**
     * Gets a user by their username.
     * 
     * @param username
     * @return 
     */
    public static User getUserByUsername(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM USERS " +
                "WHERE USERNAME = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, username);
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }        
        return getFromDB(ps);
    }
    
    /**
     * Gets a list of users enrolled in a certain section of a class. A section 
     * is specific to date, time, location, room number and course id.
     * 
     * @param reg_code
     * @return 
     */
    public static ArrayList<User> getUsersBySectionNum(String section_num) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM USERS u, REGISTRATION r, STUDENT s " +
                "WHERE r.SECTION_NUM = ? AND (r.STU_ID = s.STU_ID AND s.STU_ID = u.STU_ID)";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, section_num);
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }        
        return getListFromDB(ps);
    }
    
    /**
     * Gets a list of users in a specific course (ex. all users in a CIS 2353
     * class). Might not work? Please TEST
     * 
     * @param course_ID
     * @return 
     */
    public static ArrayList<User> getUsersByCourseID(int course_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM USERS u, STUDENT s, REGISTRATION r, SECTION s " +
                "WHERE (u.STU_ID = s.STU_ID AND s.STU_ID = r.STU_ID) AND (r.SECTION_NUM = s.SECTION_NUM) AND s.COURSE_ID = ?";
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
    
    /**
     * Gets a list of users with like first names.
     * 
     * @param name
     * @return 
     */
    public static ArrayList<User> getUserByFirstName(String name) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM USERS " +
                "WHERE USER_FIRST_NAME = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, name);
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }        
        return getListFromDB(ps);
    }
    
    /**
     * Gets a list of users with like last names.
     * 
     * @param name
     * @return 
     */
    public static ArrayList<User> getUserByLastName(String name) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM USERS " +
                "WHERE USER_LAST_NAME = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, name);
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }        
        return getListFromDB(ps);
    }
     
    /**
     * Gets a single user bean from the a DB based on a prepared statement
     * @param ps
     * @return 
     */
    private static User getFromDB(PreparedStatement ps) {

        ResultSet rs = null;
        User user = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {                
                user = new User();
                
                user.setUser_creation_date(rs.getDate("USER_CREATION_DATE"));
                user.setUsername(rs.getString("USERNAME"));
                user.setUser_ID(rs.getInt("USER_ID"));
                user.setStu_ID(rs.getInt("STU_ID"));
                user.setFaculty_ID(rs.getInt("FACULTY_ID"));
                user.setUser_address(rs.getString("USER_ADDRESS"));
                user.setUser_city(rs.getString("USER_CITY"));
                user.setUser_state(rs.getString("USER_STATE"));
                user.setUser_zip(rs.getInt("USER_ZIP"));
                user.setUser_country(rs.getString("USER_COUNTRY"));
                user.setUser_first_name(rs.getString("USER_FIRST_NAME"));
                user.setUser_last_name(rs.getString("USER_LAST_NAME"));

            }
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closeResultSet(rs);
        }
        return user;
    }
    
    /**
     * Gets a list of user beans from a DB based on a prepared
     * statement.
     * 
     * @param ps
     * @return 
     */
    private static ArrayList<User> getListFromDB(PreparedStatement ps) {
        ResultSet rs = null;
        ArrayList<User> users = null;
        try {
            rs = ps.executeQuery();
            users = new ArrayList<User>();
            while (rs.next()) {                                
                User user = new User();
                
                user.setUser_creation_date(rs.getDate("USER_CREATION_DATE"));
                user.setUsername(rs.getString("USERNAME"));
                user.setUser_ID(rs.getInt("USER_ID"));
                user.setStu_ID(rs.getInt("STU_ID"));
                user.setFaculty_ID(rs.getInt("FACULTY_ID"));
                user.setUser_address(rs.getString("USER_ADDRESS"));
                user.setUser_city(rs.getString("USER_CITY"));
                user.setUser_state(rs.getString("USER_STATE"));
                user.setUser_zip(rs.getInt("USER_ZIP"));
                user.setUser_country(rs.getString("USER_COUNTRY"));
                user.setUser_first_name(rs.getString("USER_FIRST_NAME"));
                user.setUser_last_name(rs.getString("USER_LAST_NAME"));
                
                users.add(user);
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closeResultSet(rs);
        }
        return users;
    }
    
}
