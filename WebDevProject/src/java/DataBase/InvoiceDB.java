/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Beans.Invoice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Justin
 */
public class InvoiceDB {
        
    public static Invoice getInvoiceByInvoiceID(int invoice_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM INVOICE " +
                "WHERE INVOICE_ID = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, Integer.toString(invoice_ID));
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getFromDB(ps);
    }
    
    public static ArrayList<Invoice> getInvoiceByStudentID(int student_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM INVOICE " +
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
    
    public static ArrayList<Invoice> getInvoiceByDate(Date dateMin, Date dateMax) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM INVOICE " +
                "WHERE INVOICE_DATE BETWEEN ? AND ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, dateMin.toString());
        ps.setString(2, dateMax.toString());
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getListFromDB(ps);
    }
    
    public static ArrayList<Invoice> getInvoiceByCCN(int creditcard_num) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM INVOICE " +
                "WHERE CREDITCARD_NUM = ?";
        try {
        ps = connection.prepareStatement(query);
        ps.setString(1, Integer.toString(creditcard_num));
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return getListFromDB(ps);        
    }
    
    private static Invoice getFromDB(PreparedStatement ps) {
        
        ResultSet rs = null;
        Invoice invoice = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {                
                invoice = new Invoice();
                
                invoice.setInvoice_ID(rs.getInt("INVOICE_ID"));
                invoice.setInvoice_date(rs.getDate("INVOICE_DATE"));
                invoice.setInvoice_payment(rs.getInt("INVOICE_PAYMENT"));
                invoice.setCreditCard_num(rs.getInt("CREDITCARD_NUM"));
                invoice.setStu_ID(rs.getInt("STU_ID"));
            }
        } catch (SQLException e) {
            Logger.getLogger(CourseDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closeResultSet(rs);
        }
        return invoice;
    }
    
    private static ArrayList<Invoice> getListFromDB(PreparedStatement ps) {
        
        ResultSet rs = null;
        ArrayList<Invoice> invoices = null;
        try {
            rs = ps.executeQuery();
            invoices = new ArrayList<Invoice>();
            while (rs.next()) {                
                Invoice invoice = new Invoice();
                
                invoice.setInvoice_ID(rs.getInt("INVOICE_ID"));
                invoice.setInvoice_date(rs.getDate("INVOICE_DATE"));
                invoice.setInvoice_payment(rs.getInt("INVOICE_PAYMENT"));
                invoice.setCreditCard_num(rs.getInt("CREDITCARD_NUM"));
                invoice.setStu_ID(rs.getInt("STU_ID"));
                invoices.add(invoice);
            }
        } catch (SQLException e) {
            Logger.getLogger(CourseDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closeResultSet(rs);
        }
        return invoices;
    }
}
