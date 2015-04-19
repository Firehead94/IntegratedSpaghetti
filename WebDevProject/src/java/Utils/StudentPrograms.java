/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

import java.util.Date;

/**
 *
 * @author tom
 */
public class StudentPrograms {
    
    public static void main(String[] args) {
       
        for(int i=9; i<39; i++) {
           int program = (int)(Math.random() * 11) +1;
           System.out.print("("+i+","+program+")");
           if(i==38)
               System.out.println(";");
           else
               System.out.println(",");
        }
        
    }
}
