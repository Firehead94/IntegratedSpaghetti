/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

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
public class StudentDB {
    
    
    public static void updateBalance(int user_id, int balance) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "UPDATE STUDENT SET BALANCE = ? WHERE STU_ID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, balance);
            ps.setInt(2, PrivilegeDB.getStudentIDByUserID(user_id));
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(PrivilegeDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
        
    }
    
    public static int getBalance(int user_id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT BALANCE FROM STUDENT WHERE STU_ID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, PrivilegeDB.getStudentIDByUserID(user_id));
            rs = ps.executeQuery();
            if (rs.next())
                return rs.getInt("BALANCE");
        } catch (SQLException e) {
            Logger.getLogger(PrivilegeDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
            DBUtil.closeResultSet(rs);
        }    
        return 0;
    }
    
    public static int getCourseCreditsAndCost(int user_id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cost = 0;
        String query =  "SELECT c.COURSE_COST, c.COURSE_CREDITS FROM COURSE c " +
                        "INNER JOIN SECTION s ON (c.COURSE_ID = s.COURSE_ID " +
                        "AND c.DEPT_ID = s.DEPT_ID) INNER JOIN REGISTRATION r " +
                        "ON r.SECTION_NUM = s.SECTION_NUM WHERE r.STU_ID = ?";
        try {
            ps = connection.prepareStatement(query);
            int stu_id = PrivilegeDB.getStudentIDByUserID(user_id);
            ps.setInt(1, stu_id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                cost += rs.getInt("COURSE_COST");
                cost = cost + (rs.getInt("COURSE_CREDITS") * 87);                
            }
        } catch (SQLException e) {
            Logger.getLogger(PrivilegeDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
            DBUtil.closeResultSet(rs);
        }    
        return cost; 
        
    }
}
