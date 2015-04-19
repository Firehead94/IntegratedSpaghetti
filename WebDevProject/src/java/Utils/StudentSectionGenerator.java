/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tom
 */
public class StudentSectionGenerator {
    public static void main(String[] args) {

        Map<Integer, String> grades = new HashMap<>();
            grades.put(0,"F");
            grades.put(1,"D");
            grades.put(2,"C-");
            grades.put(3,"C");
            grades.put(4,"C+");
            grades.put(5,"B-");
            grades.put(6,"B");
            grades.put(7,"B+");
            grades.put(8,"A-");
            grades.put(9,"A");
            
            Map<String, String> gpas = new HashMap<>();
            gpas.put("F","0.0");
            gpas.put("D","1.0");
            gpas.put("C-","1.7");
            gpas.put("C","2.0");
            gpas.put("C+","2.3");
            gpas.put("B-","2.7");
            gpas.put("B","3.0");
            gpas.put("B+","3.3");
            gpas.put("A-","3.7");
            gpas.put("A","4.0");
        
        for(int i=9; i<39;i++) {
            
            String student = String.valueOf(i);
            int numClasses = (int)(Math.random()*3) + 3;
            ArrayList<Integer> sections = new ArrayList<>(numClasses+1);
            
            for(int s=0;s<numClasses;s++) {
                int gradeInt = (int)(Math.random()*13);
                int section = (int)(Math.random()*20);
                while(sections.contains(section)){
                    section = (int)(Math.random()*20);
                }
                sections.add(section);
                
                System.out.print("("+student+","+section);
                if(grades.containsKey(gradeInt)) {
                    String grade = grades.get(gradeInt);
                    String gpa = gpas.get(grade);
                    System.out.print(",\'"+grade+"\',"+gpa);
                }
                System.out.println("),");
            
            }             
            
            
        }
    }
}
