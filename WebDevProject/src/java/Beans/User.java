
package Beans;

import DataBase.PrivilegeDB;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Justin
 */
public class User implements Serializable {
    
    private int user_ID;
    private boolean student;
    private boolean faculty;
    private String user_first_name;
    private String user_last_name;
    private String user_address;
    private String user_city;
    private String user_state;
    private int user_zip;
    private String user_country;
    private String user_password;
    private Date user_creation_date;
    private String username;
    private String user_email;
    private long user_dob;

    /**
     * @return the user_ID
     */
    public int getUser_ID() {
        return user_ID;
    }

    /**
     * @return the user_first_name
     */
    public String getUser_first_name() {
        return user_first_name;
    }

    /**
     * @return the user_last_name
     */
    public String getUser_last_name() {
        return user_last_name;
    }

    /**
     * @return the user_address
     */
    public String getUser_address() {
        return user_address;
    }

    /**
     * @return the user_city
     */
    public String getUser_city() {
        return user_city;
    }

    /**
     * @return the user_state
     */
    public String getUser_state() {
        return user_state;
    }

    /**
     * @return the user_zip
     */
    public int getUser_zip() {
        return user_zip;
    }

    /**
     * @return the user_country
     */
    public String getUser_country() {
        return user_country;
    }

    /**
     * @return the user_password
     */
    public String getUser_password() {
        return user_password;
    }

    /**
     * @return the user_creation_date
     */
    public Date getUser_creation_date() {
        return user_creation_date;
    }

    /**
     * @param user_ID the user_ID to set
     */
    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    /**
     * @param user_first_name the user_first_name to set
     */
    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    /**
     * @param user_last_name the user_last_name to set
     */
    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    /**
     * @param user_address the user_address to set
     */
    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    /**
     * @param user_city the user_city to set
     */
    public void setUser_city(String user_city) {
        this.user_city = user_city;
    }

    /**
     * @param user_state the user_state to set
     */
    public void setUser_state(String user_state) {
        this.user_state = user_state;
    }

    /**
     * @param user_zip the user_zip to set
     */
    public void setUser_zip(int user_zip) {
        this.user_zip = user_zip;
    }

    /**
     * @param user_country the user_country to set
     */
    public void setUser_country(String user_country) {
        this.user_country = user_country;
    }

    /**
     * @param user_password the user_password to set
     */
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    /**
     * @param user_creation_date the user_creation_date to set
     */
    public void setUser_creation_date(Date user_creation_date) {
        this.user_creation_date = user_creation_date;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the user_email
     */
    public String getUser_email() {
        return user_email;
    }

    /**
     * @param user_email the user_email to set
     */
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }    

    /**
     * @return the user_dob
     */
    public long getUser_dob() {
        return user_dob;
    }
    
    public String getUser_dob_date() {
        Date date = new Date(user_dob);
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        
        return df.format(date);
    }

    /**
     * @param user_dob the user_dob to set
     */
    public void setUser_dob(long user_dob) {
        this.user_dob = user_dob;
    }

    /**
     * @return the isStudent
     */
    public boolean isIsStudent() {
        return student;
    }

    /**
     * @param isStudent the isStudent to set
     */
    public void setIsStudent(boolean isStudent) {
        this.student = isStudent;
    }

    /**
     * @return the isFaculty
     */
    public boolean isIsFaculty() {
        return faculty;
    }

    /**
     * @param isFaculty the isFaculty to set
     */
    public void setIsFaculty(boolean isFaculty) {
        this.faculty = isFaculty;
    }
    
    public User() {
        faculty = PrivilegeDB.isFacultyByUser(this);
        student = PrivilegeDB.isStudentByUser(this);
    }
    
}
