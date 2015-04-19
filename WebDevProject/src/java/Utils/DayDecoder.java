/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Justin
 */
public class DayDecoder {
    
    public static final Map<String, Integer> dayMap = new HashMap<String, Integer>();
    static {
        dayMap.put("sunday", 1);
        dayMap.put("monday", 2);
        dayMap.put("tuesday", 4);
        dayMap.put("wednesday", 8);
        dayMap.put("thursday", 16);
        dayMap.put("friday", 32);
        dayMap.put("saturday", 64);       
    }
    
    
    public static String DayDecoder(int code) {

        if(isValid(code)) {
            return getString(code);
        }
        return "No Days";
    }
    
    private static boolean isValid(int code) {
        return code > 0 && code < 128;
    }
    
    private static String getString(int code) {
        Stack<String> days = new Stack<String>() {};
        String str = null;
        
        
        if (code > dayMap.get("saturday")) {
            code -= dayMap.get("saturday");
            days.push("Saturday");
        }
        if (code > dayMap.get("friday")) {
            code -= dayMap.get("friday");
            days.push("Friday");
        }
        if (code > dayMap.get("thursday")) {
            code -= dayMap.get("thursday");
            days.push("Thursday");
        }
        if (code > dayMap.get("wednesday")) {
            code -= dayMap.get("wednesday");
            days.push("Wednesday");
        }
        if (code > dayMap.get("tuesday")) {
            code -= dayMap.get("tuesday");
            days.push("Tuesday");
        }
        if (code > dayMap.get("monday")) {
            code -= dayMap.get("monday");
            days.push("Monday");
        }
        if (code > dayMap.get("sunday")) {
            code -= dayMap.get("sunday");
            days.push("Sunday");
        }
        for (String tmp : days)
            str = str.concat(tmp + ", ");
        
        return str.substring(str.lastIndexOf(","));
        
    }
    
}
