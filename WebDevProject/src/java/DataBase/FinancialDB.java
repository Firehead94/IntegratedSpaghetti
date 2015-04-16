/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Beans.Financial;
import Beans.Invoice;
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
public class FinancialDB {
    
    public static Financial getFinancialByIDAndCCNum (int student_ID, int ccn) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM FINANCIAL " +
                "WHERE STU_ID = ? && CREDITCARD_NUM = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, Integer.toString(student_ID));
        ps.setString(2, Integer.toString(ccn));
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getFromDB(ps);
    }
    
    public static ArrayList<Financial> getFinancialByStudentID(int student_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM FINANCIAL " +
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
    
    public static ArrayList<Financial> getFinancialByBalanceRange(double min, double max) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM FINANCIAL " +
                "WHERE BALANCE BETWEEN ? AND ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, Double.toString(min));
        ps.setString(1, Double.toString(max));
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getListFromDB(ps);
    }
    
    private static Financial getFromDB(PreparedStatement ps) {
        
        ResultSet rs = null;
        Financial financial = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {                
                financial = new Financial();
                
                financial.setBalance(rs.getInt("BALANCE"));
                financial.setStu_ID(rs.getInt("STU_ID"));
                financial.setCreditCard_num(rs.getInt("CREDITCARD_NUM"));
                financial.setExp_date(rs.getDate("EXP_DATE"));
                financial.setBilling_address(rs.getString("BILLING_ADDRESS"));
                financial.setBilling_city(rs.getString("BILLING_CITY"));
                financial.setBilling_state(rs.getString("BILLING_STATE"));
                financial.setBilling_zip(rs.getInt("BILLING_ZIP"));
                financial.setBilling_name(rs.getString("BILLING_NAME"));

            }
        } catch (SQLException e) {
            Logger.getLogger(CourseDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closeResultSet(rs);
        }
        return financial;
    }
    
    private static ArrayList<Financial> getListFromDB(PreparedStatement ps) {
        
        ResultSet rs = null;
        ArrayList<Financial> financials = null;
        try {
            rs = ps.executeQuery();
            financials = new ArrayList<Financial>();
            if (rs.next()) {                
                Financial financial = new Financial();
                
                financial.setBalance(rs.getInt("BALANCE"));
                financial.setStu_ID(rs.getInt("STU_ID"));
                financial.setCreditCard_num(rs.getInt("CREDITCARD_NUM"));
                financial.setExp_date(rs.getDate("EXP_DATE"));
                financial.setBilling_address(rs.getString("BILLING_ADDRESS"));
                financial.setBilling_city(rs.getString("BILLING_CITY"));
                financial.setBilling_state(rs.getString("BILLING_STATE"));
                financial.setBilling_zip(rs.getInt("BILLING_ZIP"));
                financial.setBilling_name(rs.getString("BILLING_NAME"));
                
                financials.add(financial);

            }
        } catch (SQLException e) {
            Logger.getLogger(CourseDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closeResultSet(rs);
        }
        return financials; 
    }
    
}
