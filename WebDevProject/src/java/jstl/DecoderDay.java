/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstl;

import Utils.DayDecoder;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Justin
 */
public class DecoderDay extends SimpleTagSupport {
    
    private int code;
    
    public DecoderDay() {
        code = 0;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
        
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print(DayDecoder.DayDecoder(code));
    }
    
}
