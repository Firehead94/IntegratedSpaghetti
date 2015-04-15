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
    
    private int section_num;
    private int stu_ID;
    private int gpa;
    private String grade;

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

    /**
     * @return the stu_ID
     */
    public int getStu_ID() {
        return stu_ID;
    }

    /**
     * @param stu_ID the stu_ID to set
     */
    public void setStu_ID(int stu_ID) {
        this.stu_ID = stu_ID;
    }

    /**
     * @return the gpa
     */
    public int getGpa() {
        return gpa;
    }

    /**
     * @param gpa the gpa to set
     */
    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

}
