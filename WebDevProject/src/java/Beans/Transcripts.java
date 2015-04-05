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
public class Transcripts implements Serializable {
    
    private int stu_ID;
    private String reg_code;
    private int transcript_gpa;

    /**
     * @return the stu_ID
     */
    public int getStu_ID() {
        return stu_ID;
    }

    /**
     * @return the reg_code
     */
    public String getReg_code() {
        return reg_code;
    }

    /**
     * @return the transcript_gpa
     */
    public int getTranscript_gpa() {
        return transcript_gpa;
    }

    /**
     * @param stu_ID the stu_ID to set
     */
    public void setStu_ID(int stu_ID) {
        this.stu_ID = stu_ID;
    }

    /**
     * @param reg_code the reg_code to set
     */
    public void setReg_code(String reg_code) {
        this.reg_code = reg_code;
    }

    /**
     * @param transcript_gpa the transcript_gpa to set
     */
    public void setTranscript_gpa(int transcript_gpa) {
        this.transcript_gpa = transcript_gpa;
    }
    
}
