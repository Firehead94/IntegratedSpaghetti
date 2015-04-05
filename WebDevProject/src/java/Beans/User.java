/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Justin
 */
public class User implements Serializable {
    
    private int user_ID;
    private int stu_ID;
    private int faculty_ID;
    private String user_first_name;
    private String user_last_name;
    private String user_address;
    private String user_city;
    private String user_state;
    private int user_zip;
    private String user_country;
    private String user_password;
    private Date user_creation_date;

    /**
     * @return the user_ID
     */
    public int getUser_ID() {
        return user_ID;
    }

    /**
     * @return the stu_ID
     */
    public int getStu_ID() {
        return stu_ID;
    }

    /**
     * @return the faculty_ID
     */
    public int getFaculty_ID() {
        return faculty_ID;
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
     * @param stu_ID the stu_ID to set
     */
    public void setStu_ID(int stu_ID) {
        this.stu_ID = stu_ID;
    }

    /**
     * @param faculty_ID the faculty_ID to set
     */
    public void setFaculty_ID(int faculty_ID) {
        this.faculty_ID = faculty_ID;
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
    
    
    
}
