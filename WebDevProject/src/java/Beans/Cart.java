/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * Needs to be redone once we settle on reg_code shit.
 * @author Justin
 */
public class Cart implements Serializable {
    
    private TreeSet<Section> cart;
    
    public Cart() {
        cart = new TreeSet<>();
    }
    
    public void addToCart(Section section) {
        cart.add(section);
    }
    
    public void removeFromCart(Section section) {
        cart.remove(section);
    }
    
    public int size() {
        return cart.size();
    }
    
    
    
}
