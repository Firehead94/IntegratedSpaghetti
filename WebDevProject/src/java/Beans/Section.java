
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
    private Time section_time_start;
    private Time section_time_end;
    private String section_location;
    private int section_semester;
    private int section_year;
    private int course_ID;
    private int dept_ID;
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
    

    /**
     * @return the dept_ID
     */
    public int getDept_ID() {
        return dept_ID;
    }

    /**
     * @param dept_ID the dept_ID to set
     */
    public void setDept_ID(int dept_ID) {
        this.dept_ID = dept_ID;
    }

    /**
     * @return the section_time_start
     */
    public Time getSection_time_start() {
        return section_time_start;
    }

    /**
     * @param section_time_start the section_time_start to set
     */
    public void setSection_time_start(Time section_time_start) {
        this.section_time_start = section_time_start;
    }

    /**
     * @return the section_time_end
     */
    public Time getSection_time_end() {
        return section_time_end;
    }

    /**
     * @param section_time_end the section_time_end to set
     */
    public void setSection_time_end(Time section_time_end) {
        this.section_time_end = section_time_end;
    }

    /**
     * @return the section_semester
     */
    public int getSection_semester() {
        return section_semester;
    }

    /**
     * @param section_semester the section_semester to set
     */
    public void setSection_semester(int section_semester) {
        this.section_semester = section_semester;
    }

    /**
     * @return the section_year
     */
    public int getSection_year() {
        return section_year;
    }

    /**
     * @param section_year the section_year to set
     */
    public void setSection_year(int section_year) {
        this.section_year = section_year;
    }

}
