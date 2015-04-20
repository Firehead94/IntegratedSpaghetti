
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
    
    public static boolean userExists(String email) {
         
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM USERS " +
                       "WHERE USER_EMAIL = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
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
    
    public static int insertUser(User user, String hash) {
         
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        int retVal;
        
        String query = "INSERT INTO USERS (USER_FIRST_NAME, USER_LAST_NAME, USER_ADDRESS, USER_CITY, USER_STATE, USER_ZIP, USER_COUNTRY, USER_PASSWORD, USERNAME, USER_EMAIL, USER_DOB) " +
                       "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUser_first_name());
            ps.setString(2, user.getUser_last_name());
            ps.setString(3, user.getUser_address());
            ps.setString(4, user.getUser_city());
            ps.setString(5, user.getUser_state());
            ps.setInt(6, user.getUser_zip());
            ps.setString(7, user.getUser_country());
            ps.setString(8, hash);
            ps.setString(9, user.getUsername());
            ps.setString(10, user.getUser_email());
            ps.setDate(11, new java.sql.Date(user.getUser_dob().getTime()));
            retVal = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return retVal;
        
    }   
    
    public static User getUserByEmail(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        User user = null;
        
        String query = "SELECT * FROM USERS " +
                "WHERE USER_EMAIL = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            user = getFromDB(ps);
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return user;
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
        User user = null;
        
        String query = "SELECT * FROM USERS " +
                "WHERE USERNAME = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            user = getFromDB(ps);
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }        
        return user;
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
        ArrayList<User> users = null;
        
        String query = "SELECT * FROM USERS u, REGISTRATION r, STUDENT s " +
                "WHERE r.SECTION_NUM = ? AND (r.STU_ID = s.STU_ID AND s.STU_ID = u.STU_ID)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, section_num);
            users = getListFromDB(ps);
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }        
        return users;
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
        ArrayList<User> users = null;
        
        String query = "SELECT * FROM USERS u, STUDENT s, REGISTRATION r, SECTION s " +
                "WHERE (u.STU_ID = s.STU_ID AND s.STU_ID = r.STU_ID) AND (r.SECTION_NUM = s.SECTION_NUM) AND s.COURSE_ID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, Integer.toString(course_ID));
            users = getListFromDB(ps);
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }        
        return users;
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
        ArrayList<User> users = null;
        
        String query = "SELECT * FROM USERS " +
                "WHERE USER_FIRST_NAME = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            users = getListFromDB(ps);
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }        
        return users;
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
        ArrayList<User> users = null;
        
        String query = "SELECT * FROM USERS " +
                "WHERE USER_LAST_NAME = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            users = getListFromDB(ps);
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }        
        return users;
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
                user.setUser_address(rs.getString("USER_ADDRESS"));
                user.setUser_city(rs.getString("USER_CITY"));
                user.setUser_state(rs.getString("USER_STATE"));
                user.setUser_zip(rs.getInt("USER_ZIP"));
                user.setUser_country(rs.getString("USER_COUNTRY"));
                user.setUser_first_name(rs.getString("USER_FIRST_NAME"));
                user.setUser_last_name(rs.getString("USER_LAST_NAME"));
                user.setUser_dob(rs.getDate("USER_DOB"));
                
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
