/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstl;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Justin
 */
public class DecoderTime extends SimpleTagSupport {
    
    String time;
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm +a");
    
    public DecoderTime() {
        time = null;
    }
    
    public void setTime(Time time) {
        this.time = sdf.format(time);
    }
        
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print(time.replace("+", ""));
    }
    
}
