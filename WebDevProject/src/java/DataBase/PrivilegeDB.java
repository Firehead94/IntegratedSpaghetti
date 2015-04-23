/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Beans.Section;
import Beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Justin
 */
public class PrivilegeDB {
    
    public static void newStudent(int id, int program) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "INSERT INTO STUDENT (USER_ID, PROGRAM_ID) " +
                "VALUES (?,?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, program);
            ps.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(PrivilegeDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
            DBUtil.closeResultSet(rs);
        }
    }
    
    public static boolean isFacultyByUser(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT COUNT(*) FROM FACULTY " +
                "WHERE USER_ID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, user.getUser_ID());
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            Logger.getLogger(PrivilegeDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
            DBUtil.closeResultSet(rs);
        }
        return false;        
    }
    
    public static boolean isStudentByUser(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT COUNT(*) FROM STUDENT " +
                "WHERE USER_ID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, user.getUser_ID());
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            Logger.getLogger(PrivilegeDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
            DBUtil.closeResultSet(rs);
        }
        return false;        
    }    
    
    public static int getStudentIDByUserID(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM STUDENT " +
                "WHERE USER_ID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("STUDENT_ID");
            }
            return 0;
        } catch (SQLException e) {
            Logger.getLogger(PrivilegeDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
            DBUtil.closeResultSet(rs);
        }
        return 0;        
    }   
    
    public static int getFacultyByUserID(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM FACULTY " +
                "WHERE USER_ID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("FACULTY_ID");
            }
            return 0;
        } catch (SQLException e) {
            Logger.getLogger(PrivilegeDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
            DBUtil.closeResultSet(rs);
        }
        return 0;        
    }   
}
