/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Beans.Financial;
import Beans.Invoice;
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
    
    public static Financial getFinancialByStudentID(int student_ID) {
        throw new UnsupportedOperationException("Unimplemented yet");
    }
    
    public static ArrayList<Financial> getFinancialByBalanceRange(double min, double max) {
        throw new UnsupportedOperationException("Unimplemented yet");
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
