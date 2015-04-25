/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tom
 */
public class GpaCalculator {
    
    private static Map<String, Double> gpas= new HashMap<>();
    
    static {
        gpas.put("A",4.0);
        gpas.put("A-",3.7);
        gpas.put("B+",3.3);
        gpas.put("B",3.0);
        gpas.put("B-",2.7);
        gpas.put("C+",2.3);
        gpas.put("C",2.0);
        gpas.put("C-",1.7);
        gpas.put("D",1.0);
        gpas.put("F",0.0);
        gpas.put("I",null);
        gpas.put("W",null);
        
    }
    
    public static boolean validGrade(String grade) {
        return gpas.containsKey(grade);
    }
    
    public static Double calcGpa(String grade) {
            return gpas.get(grade);
    }
}
