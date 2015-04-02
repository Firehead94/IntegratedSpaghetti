/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Justin
 */
public class Course implements Serializable, Comparable<Course> {
    
    private String title;
    private int regCode;
    private String instructor;
    private String courseNum;
    private double credits;
    private String day;
    private String time;
    private String term;
    private char campusCode;
    
    public char getCampusCode() {
        return campusCode;
    }
    
    public String getTime() {
        return time;
    }
    
    public String getTerm() {
        return term;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getRegCode() {
        return regCode;
    }
    
    public String getInstructor() {
        return instructor;
    }
    
    public String getCourseNum() {
        return courseNum;
    }
    
    public double getCredits() {
        return credits;
    }
    
    public String getDay() {
        return day;
    }
    
    public void setCampusCode(char campusCode) {
        this.campusCode = campusCode;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setRegCode(String regCode) {
        String newRegCode;
        if (regCode.charAt(0) <= '/' ||  regCode.charAt(0) >= ':') {
            setCampusCode(regCode.charAt(0));
            newRegCode = regCode.substring(1);
        }else {
            newRegCode = regCode;
        }
        try {
            this.regCode = Integer.parseInt(newRegCode);
        } catch (NumberFormatException e) {
            System.out.println(regCode + " is Not a valid registration code");
        }
    }
    
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    
    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }
    
    public void setCredits(double credits) {
        this.credits = credits;
    }
    
    public void setDay(String day) {
        this.day = day;
    }
    
    public void setTerm(String term) {
        this.term = term;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int compareTo(Course other) {
        return this.regCode != other.regCode ? this.regCode > other.regCode ? 1 : -1 : 0;
    }
    
    @Override
    public int hashCode() {
         return Arrays.hashCode(new Object[]{new String(title), new String(time), new String(day),
             new String(instructor), new String(courseNum), new String(term), new Integer(regCode),
             new Double(credits), new Character(campusCode)});
    }
    
    @Override 
    public boolean equals(Object other) {
         if (!(other instanceof Course)){
             return false;
         }
         Course otherCourse = (Course) other;
         return this.regCode == otherCourse.regCode;
    }
}
