/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstl;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Justin
 */
public class DecoderSemester extends SimpleTagSupport {
    
    int semester;
    Map<Integer, String> map = new HashMap<Integer, String>();
   
    public DecoderSemester() {
        semester = 0;
        map.put(0, "None");
        map.put(1, "Winter");
        map.put(2, "Summer");
        map.put(3, "Fall");
    }
    
    public void setSemester(int semester) {
        this.semester = semester;
    }
        
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print(map.get(semester));
    }
    
}
