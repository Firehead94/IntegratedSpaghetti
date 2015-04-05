/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.TreeSet;

/**
 *
 * @author Justin
 */
public class Cart_old implements Serializable {
    
    private TreeSet<Course_old> cart;
    
    public Cart_old() {
        cart = new TreeSet<>();
    }
    
    public void addToCart(Course_old course) {
        cart.add(course);
    }
    
    public void removeFromCart(Course_old course) {
        cart.remove(course);
    }
    
    public int size() {
        return cart.size();
    }
    
    
    
}
