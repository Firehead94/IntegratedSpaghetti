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
public class Course implements Serializable {
    
    private int course_ID;
    private String course_title;
    private int course_credits;
    private int course_cost;
    private int dept_ID;

    /**
     * @return the course_ID
     */
    public int getCourse_ID() {
        return course_ID;
    }

    /**
     * @return the course_title
     */
    public String getCourse_title() {
        return course_title;
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
     * @return the dept_ID
     */
    public int getDept_ID() {
        return dept_ID;
    }

    /**
     * @param course_ID the course_ID to set
     */
    public void setCourse_ID(int course_ID) {
        this.course_ID = course_ID;
    }

    /**
     * @param course_title the course_title to set
     */
    public void setCourse_title(String course_title) {
        this.course_title = course_title;
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
     * @param dept_ID the dept_ID to set
     */
    public void setDept_ID(int dept_ID) {
        this.dept_ID = dept_ID;
    }
    
}
