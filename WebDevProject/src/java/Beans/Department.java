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
public class Department implements Serializable {
    
    private int dept_ID;
    private String dept_title;
    private String dept_abr;

    /**
     * @return the dept_ID
     */
    public int getDept_ID() {
        return dept_ID;
    }

    /**
     * @return the dept_title
     */
    public String getDept_title() {
        return dept_title;
    }

    /**
     * @return the dept_abr
     */
    public String getDept_abr() {
        return dept_abr;
    }

    /**
     * @param dept_ID the dept_ID to set
     */
    public void setDept_ID(int dept_ID) {
        this.dept_ID = dept_ID;
    }

    /**
     * @param dept_title the dept_title to set
     */
    public void setDept_title(String dept_title) {
        this.dept_title = dept_title;
    }

    /**
     * @param dept_abr the dept_abr to set
     */
    public void setDept_abr(String dept_abr) {
        this.dept_abr = dept_abr;
    }
    
}
