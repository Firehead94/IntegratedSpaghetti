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

    /**
     *  Sorts a specified int array into ascending order.
     *  The worstTime(n) is O(n log N), where n is the length of the array, and N is the largest
     *  number (in absolute value) of the numbers in the array.
     *
     *  @param a  the array to be sorted.
     *
     *  @throws NullPointerException - if a is null.
     *
     */
    public static void radixSort (int [ ] a) 
    {
            final int RADIX = 10;

            int biggest = a [0],
                    i;


            for (i = 1; i < a.length; i++)
                    if (a [i] > biggest)
                             biggest = a [i];

            int maxDigits = (int)Math.floor (Math.log (biggest) / Math.log (10)) + 1;

            long quotient = 1;            // the type is long because the largest 
                                                                      // number may have
                                                                      // 10 digits; the successive 
                                                                      // quotients are 1, 10, 100, 1000,
             // and so on.  10 to the 10th is too 
      // large for an int value.

            ArrayList<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>> (RADIX);

            for (int m = 0; m < RADIX; m++)
                    lists.add(new LinkedList<Integer>());

            // Loop once for each digit in the largest number:
            for (int k = 0; k < maxDigits; k++) 
       {
                    // Store each int in a as an Integer in lists at the index of 
                    // a [i]'s kth-smallest digit:
                    for (i = 0; i < a.length; i++)
                             ((LinkedList<Integer>)lists.get((int)(a [i] / quotient) % RADIX)).add (a [i]);
                    i = 0;

                    // Store each Integer in list [0], list [1],... , as an int in a:
                    for (int j = 0; j < RADIX; j++) 
                    {
                             for (Integer anInt : (LinkedList<Integer>)lists.get(j))
                                            a [i++] = anInt.intValue();  
                             lists.get(j).clear();
                    } // for j
                    quotient *= RADIX;
            } // for k
    } // method radixSort
}
