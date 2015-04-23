
package DataBase;

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
public class DepartmentDB {
    
    public static int getDeptIDFromAbr(String dept_abr) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM DEPARTMENT " +
                "WHERE DEPT_ABR = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, dept_abr);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("DEPT_ID");
            }
        } catch (SQLException e) {
            Logger.getLogger(DepartmentDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return -1;        
    }
    
    public static String getDeptAbrFromID(int dept_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM DEPARTMENT " +
                "WHERE DEPT_ID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, dept_ID);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getString("DEPT_ABR");
            }
        } catch (SQLException e) {
            Logger.getLogger(DepartmentDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return null;  
    }
    
    public static String getDeptTitleFromID(int dept_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM DEPARTMENT " +
                "WHERE DEPT_ID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, dept_ID);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getString("DEPT_TITLE");
            }
        } catch (SQLException e) {
            Logger.getLogger(DepartmentDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return null;  
    }
    
    public static String[] getDeptAbr() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> dept_abrs;
        String[] depts;
        
        String query = "SELECT * FROM DEPARTMENT";
        
        try {
            dept_abrs = new ArrayList<String>();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();            
            while (rs.next()) {
                dept_abrs.add(rs.getString("DEPT_ABR"));
            }
            depts = new String[dept_abrs.size()];
            return dept_abrs.toArray(depts);
        } catch (SQLException e) {
            Logger.getLogger(DepartmentDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return null;  
    }
    
}
