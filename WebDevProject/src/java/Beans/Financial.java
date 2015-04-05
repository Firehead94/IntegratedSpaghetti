/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Justin
 */
public class Financial implements Serializable {
    
    private int stu_ID;
    private long creditCard_num;
    private Date exp_date;
    private String billing_address;
    private String billing_city;
    private String billing_state;
    private int billing_zip;
    private String billing_name;
    private int balance;

    /**
     * @return the stu_ID
     */
    public int getStu_ID() {
        return stu_ID;
    }

    /**
     * @return the creditCard_num
     */
    public long getCreditCard_num() {
        return creditCard_num;
    }

    /**
     * @return the exp_date
     */
    public Date getExp_date() {
        return exp_date;
    }

    /**
     * @return the billing_address
     */
    public String getBilling_address() {
        return billing_address;
    }

    /**
     * @return the billing_city
     */
    public String getBilling_city() {
        return billing_city;
    }

    /**
     * @return the billing_state
     */
    public String getBilling_state() {
        return billing_state;
    }

    /**
     * @return the billing_zip
     */
    public int getBilling_zip() {
        return billing_zip;
    }

    /**
     * @return the billing_name
     */
    public String getBilling_name() {
        return billing_name;
    }

    /**
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * @param stu_ID the stu_ID to set
     */
    public void setStu_ID(int stu_ID) {
        this.stu_ID = stu_ID;
    }

    /**
     * @param creditCard_num the creditCard_num to set
     */
    public void setCreditCard_num(long creditCard_num) {
        this.creditCard_num = creditCard_num;
    }

    /**
     * @param exp_date the exp_date to set
     */
    public void setExp_date(Date exp_date) {
        this.exp_date = exp_date;
    }

    /**
     * @param billing_address the billing_address to set
     */
    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }

    /**
     * @param billing_city the billing_city to set
     */
    public void setBilling_city(String billing_city) {
        this.billing_city = billing_city;
    }

    /**
     * @param billing_state the billing_state to set
     */
    public void setBilling_state(String billing_state) {
        this.billing_state = billing_state;
    }

    /**
     * @param billing_zip the billing_zip to set
     */
    public void setBilling_zip(int billing_zip) {
        this.billing_zip = billing_zip;
    }

    /**
     * @param billing_name the billing_name to set
     */
    public void setBilling_name(String billing_name) {
        this.billing_name = billing_name;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    
}
