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
public class Program implements Serializable {
    
    private int program_ID;
    private String program_title;
    private int dept_ID;

    /**
     * @return the program_ID
     */
    public int getProgram_ID() {
        return program_ID;
    }

    /**
     * @return the program_title
     */
    public String getProgram_title() {
        return program_title;
    }

    /**
     * @return the dept_ID
     */
    public int getDept_ID() {
        return dept_ID;
    }

    /**
     * @param program_ID the program_ID to set
     */
    public void setProgram_ID(int program_ID) {
        this.program_ID = program_ID;
    }

    /**
     * @param program_title the program_title to set
     */
    public void setProgram_title(String program_title) {
        this.program_title = program_title;
    }

    /**
     * @param dept_ID the dept_ID to set
     */
    public void setDept_ID(int dept_ID) {
        this.dept_ID = dept_ID;
    }
    
}
