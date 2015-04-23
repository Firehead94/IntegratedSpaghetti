/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstl;

import DataBase.UserDB;
import Utils.DayDecoder;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Justin
 */
public class DecoderFaculty extends SimpleTagSupport {
    
    int id;
    
    public DecoderFaculty() {
        id = 0;
    }
    
    public void setId(int id) {
        this.id = id;
    }
        
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print(UserDB.getNameByFacultyID(id));
    }
    
} 