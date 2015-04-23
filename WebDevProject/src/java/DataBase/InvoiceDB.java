
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
        Invoice invoice = null;
        
        String query = "SELECT * FROM INVOICE " +
                "WHERE INVOICE_ID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, invoice_ID);
            invoice = getFromDB(ps);
        } catch (SQLException e) {
            Logger.getLogger(InvoiceDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return invoice;
    }
    
    public static ArrayList<Invoice> getInvoiceByStudentID(int student_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ArrayList<Invoice> invoices = null;
        
        String query = "SELECT * FROM INVOICE " +
                "WHERE STU_ID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, student_ID);
            invoices = getListFromDB(ps);
        } catch (SQLException e) {
            Logger.getLogger(InvoiceDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return invoices;
    }
    
    public static ArrayList<Invoice> getInvoiceByDate(Date dateMin, Date dateMax) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ArrayList<Invoice> invoices = null;
        
        String query = "SELECT * FROM INVOICE " +
                "WHERE INVOICE_DATE BETWEEN ? AND ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setDate(1, new java.sql.Date(dateMin.getTime()));
            ps.setDate(2, new java.sql.Date(dateMax.getTime()));
            invoices = getListFromDB(ps);
        } catch (SQLException e) {
            Logger.getLogger(InvoiceDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return invoices;
    }
    
    public static ArrayList<Invoice> getInvoiceByCCN(long creditcard_num) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ArrayList<Invoice> invoices = null;
        
        String query = "SELECT * FROM INVOICE " +
                "WHERE CREDITCARD_NUM = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setLong(1, creditcard_num);
            invoices = getListFromDB(ps);
        } catch (SQLException e) {
            Logger.getLogger(InvoiceDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return invoices;       
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
                invoice.setCreditCard_num(rs.getLong("CREDITCARD_NUM"));
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
