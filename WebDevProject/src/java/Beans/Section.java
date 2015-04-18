/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.sql.Time;

/**
 * This is what we would place in the Cart when user selects it. Will definitely be editted down the line.
 * 
 * @author Justin
 */
public class Section implements Serializable {
    
    private int faculty_ID;
    private int section_day;
    private Time section_time;
    private String section_location;
    private int course_ID;
    private int section_num;

    /**
     * @return the faculty_ID
     */
    public int getFaculty_ID() {
        return faculty_ID;
    }

    /**
     * @param faculty_ID the faculty_ID to set
     */
    public void setFaculty_ID(int faculty_ID) {
        this.faculty_ID = faculty_ID;
    }

    /**
     * @return the section_day
     */
    public int getSection_day() {
        return section_day;
    }

    /**
     * @param section_day the section_day to set
     */
    public void setSection_day(int section_day) {
        this.section_day = section_day;
    }

    /**
     * @return the section_time
     */
    public Time getSection_time() {
        return section_time;
    }

    /**
     * @param section_time the section_time to set
     */
    public void setSection_time(Time section_time) {
        this.section_time = section_time;
    }

    /**
     * @return the section_location
     */
    public String getSection_location() {
        return section_location;
    }

    /**
     * @param section_location the section_location to set
     */
    public void setSection_location(String section_location) {
        this.section_location = section_location;
    }

    /**
     * @return the course_ID
     */
    public int getCourse_ID() {
        return course_ID;
    }

    /**
     * @param course_ID the course_ID to set
     */
    public void setCourse_ID(int course_ID) {
        this.course_ID = course_ID;
    }

    /**
     * @return the section_num
     */
    public int getSection_num() {
        return section_num;
    }

    /**
     * @param section_num the section_num to set
     */
    public void setSection_num(int section_num) {
        this.section_num = section_num;
    }
    
    public boolean equals(Object other) {
        if (((Section)other).section_num == section_num) {
            return true;
        }
        return false;
    }
    
    public int hashCode() {
        return section_num;
    }
   
}
