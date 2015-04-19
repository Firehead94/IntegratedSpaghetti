/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author tom
 */
public class FinanceGenerator {
    public static void main(String[] args) {
        String[] arr = {"('Jesse Booth', '947 Bartlett Ave', 'Southfield', 'MI', 48075,",
            "('Patricia Avila', '1049 D St', 'Roseville', 'MI', 48066,",
            "('Joseph Sanner','348 Nash St','Detroit','MI',48227,",
            "('Julia Timmons','1945 Eagle Dr','Southfield','MI',48235,",
            "('Ralph Kestner','4185 Robinson Ct','Saginaw','MI',48607,",
            "('Joan Fredericks','1476 Wetzel Ln','Grand Rapids','MI',49503,",
            "('Sheila Tyson','3327 Cherry Ridge Dr','Bloomfield Township','MI',48302,",
            "('Albert Bramblett','1758 Goff Ave','Three Rivers','MI',49093,",
            "('Elizabeth Gill','2621 Haven Ln','Grand Rapids','MI',49508,",
            "('Jose Thomas','4638 Prudence St','Southfield','MI',48075,",
            "('Justin Jones','3734 Hart Ridge Rd','Saginaw','MI',48607,",
            "('Frances Swanson','324 Wetzel Ln','Grand Rapids','MI',49503,",
            "('Barbara Flower','4643 Bobcat Dr','Bloomfield Township','MI',48302,",
            "('Robert Richardson','1778 Veltri Dr','Marquette','MI',49855,",
            "('Joseph Watts','2854 Prudence St','Farmington Hills','MI',48335,",
            "('Kathryn Aguilar','4658 Ben St','East Lansing','MI',48823,",
            "('Michelle Tate','209 D Street','Southfield','MI',48075,",
            "('Janice Watson','3650 Eagle Dr','Monroe','MI',48162,",
            "('Edward Long','2689 Lakeland Terrace','Detroit','MI',48226,",
            "('Vernon Stocks','598 Mount St','Alma','MI',48801,",
            "('Raymonds Cordova','182 Echo Ln','Grands Rapids','MI',49508,",
            "('Russell Robertson','2573 Ripple St','Kingston','MI',48741,",
            "('Brandon Moreno','2855 John Ave','Lansing','MI',48912,",
            "('Michele Slaughter','2697 Ritter Ave','Southfield','MI',48034,",
            "('Kathleen Gill','1338 Tully St','Detroit','MI',48219,",
            "('Jessica Mercuri','209 Hayhurst Ln','Detroit','MI',48219,",
            "('Walter Raphael','1909 Front St','Southfield','MI',48075,",
            "('Iva Stecker','1619 Pinewood Ave','Crystal Falls','MI',49920,",
            "('Elizabeth Mallory','4464 State St','Detroit','MI',48219,",
            "('Leslie Case','1674 Summit Park Ave','Plymouth','MI',48170,"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        
        for(String start : list) {
            String cardNum = "";
            for(int i=0; i<16;i++) {
                cardNum+=String.valueOf((int)(Math.random() * 10));
            }
            String month = String.valueOf((int)(Math.random() *12 ) + 1);
            String year = String.valueOf((int)(Math.random() * 6) + 15);
            
            
        }
        
        
    }
}
