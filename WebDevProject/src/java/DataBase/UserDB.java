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
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Justin
 */
public class UserDB {
    
    public static User getUser(String username, String hash) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM USERS " +
                       "WHERE USERNAME = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next() && rs.getString(hash).equals(hash)) {
                user = new User();                
                String date = rs.getString("USER_CREATION_DATE");
                DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
                user.setUser_creation_date(format.parse(date));

                user.setUsername(rs.getString("USERNAME"));
                user.setUser_ID(Integer.parseInt(rs.getString("USER_ID")));
                user.setStu_ID(Integer.parseInt(rs.getString("STU_ID")));
                user.setFaculty_ID(Integer.parseInt(rs.getString("FACULTY_ID")));
                user.setUser_address(rs.getString("USER_ADDRESS"));
                user.setUser_city(rs.getString("USER_CITY"));
                user.setUser_state(rs.getString("USER_STATE"));
                user.setUser_zip(Integer.parseInt(rs.getString("USER_ZIP")));
                user.setUser_country(rs.getString("USER_COUNTRY"));
                user.setUser_first_name(rs.getString("USER_FIRST_NAME"));
                user.setUser_last_name(rs.getString("USER_LAST_NAME"));
            }
            return user;
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } catch (ParseException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
    }
    
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
    
}
