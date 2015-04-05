/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;

/**
 * This is what we would place in the Cart when user selects it. Will definitely be editted down the line.
 * 
 * @author Justin
 */
public class Section implements Serializable {
    
    private int stu_ID;
    private int section_day_code;
    private String section_times;
    private int course_ID;
    private String dept_abr;
    private int course_credits;
    private int course_cost;
    private String reg_code;

    /**
     * @return the stu_ID
     */
    public int getStu_ID() {
        return stu_ID;
    }

    /**
     * @return the section_day_code
     */
    public int getSection_day_code() {
        return section_day_code;
    }

    /**
     * @return the section_times
     */
    public String getSection_times() {
        return section_times;
    }

    /**
     * @return the course_ID
     */
    public int getCourse_ID() {
        return course_ID;
    }

    /**
     * @return the dept_abr
     */
    public String getDept_abr() {
        return dept_abr;
    }

    /**
     * @return the course_credits
     */
    public int getCourse_credits() {
        return course_credits;
    }

    /**
     * @return the course_cost
     */
    public int getCourse_cost() {
        return course_cost;
    }

    /**
     * @return the reg_code
     */
    public String getReg_code() {
        return reg_code;
    }

    /**
     * @param stu_ID the stu_ID to set
     */
    public void setStu_ID(int stu_ID) {
        this.stu_ID = stu_ID;
    }

    /**
     * @param section_day_code the section_day_code to set
     */
    public void setSection_day_code(int section_day_code) {
        this.section_day_code = section_day_code;
    }

    /**
     * @param section_times the section_times to set
     */
    public void setSection_times(String section_times) {
        this.section_times = section_times;
    }

    /**
     * @param course_ID the course_ID to set
     */
    public void setCourse_ID(int course_ID) {
        this.course_ID = course_ID;
    }

    /**
     * @param dept_abr the dept_abr to set
     */
    public void setDept_abr(String dept_abr) {
        this.dept_abr = dept_abr;
    }

    /**
     * @param course_credits the course_credits to set
     */
    public void setCourse_credits(int course_credits) {
        this.course_credits = course_credits;
    }

    /**
     * @param course_cost the course_cost to set
     */
    public void setCourse_cost(int course_cost) {
        this.course_cost = course_cost;
    }

    /**
     * @param reg_code the reg_code to set
     */
    public void setReg_code(String reg_code) {
        this.reg_code = reg_code;
    }
    
    
}
