/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;

/**
 *
 * @author Justin
 */
public class Registration implements Serializable {
    
    private String reg_code;
    private int course_ID;
    private int stu_ID;

    /**
     * @return the reg_code
     */
    public String getReg_code() {
        return reg_code;
    }

    /**
     * @return the course_ID
     */
    public int getCourse_ID() {
        return course_ID;
    }

    /**
     * @return the stu_ID
     */
    public int getStu_ID() {
        return stu_ID;
    }

    /**
     * @param reg_code the reg_code to set
     */
    public void setReg_code(String reg_code) {
        this.reg_code = reg_code;
    }

    /**
     * @param course_ID the course_ID to set
     */
    public void setCourse_ID(int course_ID) {
        this.course_ID = course_ID;
    }

    /**
     * @param stu_ID the stu_ID to set
     */
    public void setStu_ID(int stu_ID) {
        this.stu_ID = stu_ID;
    }
    
}
