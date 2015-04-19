
package Beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Justin
 */
public class Invoice implements Serializable {
    
    private int invoice_ID;
    private int stu_ID;
    private int invoice_payment;
    private Date invoice_date;
    private long creditCard_num;

    /**
     * @return the invoice_ID
     */
    public int getInvoice_ID() {
        return invoice_ID;
    }

    /**
     * @return the stu_ID
     */
    public int getStu_ID() {
        return stu_ID;
    }

    /**
     * @return the invoice_payment
     */
    public int getInvoice_payment() {
        return invoice_payment;
    }

    /**
     * @return the invoice_date
     */
    public Date getInvoice_date() {
        return invoice_date;
    }

    /**
     * @param invoice_ID the invoice_ID to set
     */
    public void setInvoice_ID(int invoice_ID) {
        this.invoice_ID = invoice_ID;
    }

    /**
     * @param stu_ID the stu_ID to set
     */
    public void setStu_ID(int stu_ID) {
        this.stu_ID = stu_ID;
    }

    /**
     * @param invoice_payment the invoice_payment to set
     */
    public void setInvoice_payment(int invoice_payment) {
        this.invoice_payment = invoice_payment;
    }

    /**
     * @param invoice_date the invoice_date to set
     */
    public void setInvoice_date(Date invoice_date) {
        this.invoice_date = invoice_date;
    }

    /**
     * @return the creditCard_num
     */
    public long getCreditCard_num() {
        return creditCard_num;
    }

    /**
     * @param creditCard_num the creditCard_num to set
     */
    public void setCreditCard_num(long creditCard_num) {
        this.creditCard_num = creditCard_num;
    }
    
}
