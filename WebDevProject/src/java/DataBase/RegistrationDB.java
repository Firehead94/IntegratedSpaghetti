
package DataBase;

import Beans.Registration;
import Beans.Section;
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
public class RegistrationDB {
    
    
    public static void register(int stu_id, int section_num) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "INSERT INTO REGISTRATION (STU_ID, SECTION_NUM) VALUES (?,?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, stu_id);
            ps.setInt(2, section_num);
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(RegistrationDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    
    public static int updateRegistrationByStudentIDAndSectionNum(int student_ID, int section_num, double gpa, String grade) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        int retVal = -1;
        
        String query = "UPDATE REGISTRATION SET GPA = ?, GRADE = ? " +
                "WHERE STU_ID = ? AND SECTION_NUM = ?;";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setDouble(1, gpa);
            ps.setString(2, grade);
            ps.setInt(3, student_ID);
            ps.setInt(4, section_num);
            retVal = ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(RegistrationDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return retVal;
    }
    
    
    public static Registration getRegistrationByStudentAndSection(int student_ID, int section_num) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        Registration registration = null;
        
        String query = "SELECT * FROM REGISTRATION " +
                "WHERE STU_ID = ? AND SECTION_NUM = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, student_ID);
            ps.setInt(2, section_num);
            registration = getFromDB(ps);
        } catch (SQLException e) {
            Logger.getLogger(RegistrationDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return registration;        
    }
    
    public static ArrayList<Registration> getRegistrationByStudent(int student_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ArrayList<Registration> registrations = null;
        
        String query = "SELECT * FROM REGISTRATION " +
                "WHERE STU_ID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, student_ID);
            registrations = getListFromDB(ps);
        } catch (SQLException e) {
            Logger.getLogger(RegistrationDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return registrations;           
    }
    
    public static ArrayList<Registration> getRegistrationBySection(int section_num) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ArrayList<Registration> registrations = null;
        
        String query = "SELECT * FROM REGISTRATION " +
                "WHERE SECTION_NUM = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, section_num);
            registrations = getListFromDB(ps);
        } catch (SQLException e) {
            Logger.getLogger(RegistrationDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return registrations;         
    }
    
    public static ArrayList<Registration> getRegistrationByFacultyID(int faculty_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ArrayList<Registration> registrations = null;
        
        String query = "SELECT * FROM REGISTRATION r, SECTION s " +
                "WHERE r.SECTION_NUM = s.SECTION_NUM AND s.FACULTY_ID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, faculty_ID);
            registrations = getListFromDB(ps);
        } catch (SQLException e) {
            Logger.getLogger(RegistrationDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return registrations;         
    }
    
    private static Registration getFromDB (PreparedStatement ps) {
        
        ResultSet rs = null;
        Registration registration = null;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {                
                registration = new Registration();
                
                registration.setGpa(rs.getInt("GPA"));
                registration.setGrade(rs.getString("GRADE"));
                registration.setSection_num(rs.getInt("SECTION_NUM"));
                registration.setStu_ID(rs.getInt("STU_ID"));

            }
        } catch (SQLException e) {
            Logger.getLogger(CourseDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closeResultSet(rs);
        }
        return registration;        
    }
    
    private static ArrayList<Registration> getListFromDB (PreparedStatement ps) {
        
        ResultSet rs = null;
        ArrayList<Registration> registrations = null;
        try {
            rs = ps.executeQuery();
            registrations = new ArrayList<Registration>();
            while (rs.next()) {                
                Registration registration = new Registration();
                
                registration.setGpa(rs.getInt("GPA"));
                registration.setGrade(rs.getString("GRADE"));
                registration.setSection_num(rs.getInt("SECTION_NUM"));
                registration.setStu_ID(rs.getInt("STU_ID"));
                
                registrations.add(registration);

            }
        } catch (SQLException e) {
            Logger.getLogger(CourseDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBUtil.closeResultSet(rs);
        }
        return registrations;          
    }
    
}
