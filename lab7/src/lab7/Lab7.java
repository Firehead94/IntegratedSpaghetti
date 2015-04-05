/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Justin
 */
public class Lab7 {
    
    public static void main(String [] args) {
        
        int[] a = new int[1000];
        
        for (int i = 0; i<1000; i++) {
            a[i] = (int)(Math.random() * 100);
        }
        
        for (int l : a)
            System.out.print(l + ", ");
        
        radixSort(a);
        
        System.out.println("sorted");
        for (int l : a)
            System.out.print(l + ", ");
        
    }

}
