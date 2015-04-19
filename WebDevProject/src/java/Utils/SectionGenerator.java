/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author tom
 */
public class SectionGenerator {
    public static void main(String[] args) {
        for(int i=0; i<20;i++) {
            int number = (int)(Math.random() * 2)+1;
            String info = "NA";
            String prof = "NA";
            switch(i){
                case(0):
                    info = "1, 1500";
                    prof = "1";
                    break;
                case(1):
                    info = "1, 1800";
                    prof = "1";
                    break;
                case(2):
                    info = "2, 1500";
                    prof = "2";
                    break;
                case(3):
                    info = "2, 1510";
                    prof = "2";
                    break;
                case(4):
                    info = "2, 2540";
                    prof = "2";
                    break;
                case(5):
                    info = "3, 1050";
                    prof = "3";
                    break;
                case(6):
                    info = "3, 1200";
                    prof = "3";
                    break;
                case(7):
                    info = "3, 1400";
                    prof = "3";
                    break;
                case(8):
                    info = "3, 1500";
                    prof = "3";
                    break;
                case(9):
                    info = "4, 1510";
                    prof = "4";
                    break;
                case(10):
                    info = "4, 1520";
                    prof = "4";
                    break;
                case(11):
                    info = "4, 2300";
                    prof = "4";
                    break;
                case(12):
                    info = "5, 1520";
                    prof = "5";
                    break;
                case(13):
                    info = "6, 1530";
                    prof = "6";
                    break;
                case(14):
                    info = "6, 1590";
                    prof = "6";
                    break;
                case(15):
                    info = "7, 1100";
                    prof = "7";
                    break;
                case(16):
                    info = "7, 1560";
                    prof = "7";
                    break;
                case(17):
                    info = "7, 1740";
                    prof = "7";
                    break;
                case(18):
                    info = "8, 1610";
                    prof = "8";                    
                    break;
                case(19):
                    info = "8, 2400";
                    prof = "8";
                    break;
            }
            
            for(int k=0; k<number; k++) {
                String days = "42";
                int rand = (int)(Math.random() * 9);
                switch(rand){
                    case(0):
                        days = "42";
                        break;
                    case(1):
                        days = "20";
                        break;
                    case(2):
                        days = "10";
                        break;
                    case(3):
                        days = "40";
                        break;
                    case(4):
                        days = "2";
                        break;
                    case(5):
                        days = "4";
                        break;
                    case(6):
                        days = "8";
                        break;
                    case(7):
                        days = "16";
                        break;
                    case(8):
                        days = "32";
                        break;
                }
                
                int tRand = (int)(Math.random()*12)+8;
                String startTime = String.valueOf(tRand);
                String endTime = String.valueOf(tRand+2);
                if(endTime.length()<2) {
                    endTime = "0".concat(endTime);
                }
                startTime = startTime.concat(":00:00");
                endTime = endTime.concat(":00:00");
                
                String room = "";
                
                  int bld = (int)(Math.random() * 7);
                    switch(bld){
                        case(0):
                            room += "A";
                            break;
                        case(1):
                            room += "B";
                            break;
                        case(2):
                            room += "C";
                            break;
                        case(3):
                            room += "D";
                            break;
                        case(4):
                            room += "E";
                            break;
                        case(5):
                            room += "F";
                            break;
                        case(6):
                            room += "G";
                            break;
                }
                
                int flr = (int)(Math.random() * 3) +1;
                room += String.valueOf(flr);
                
                int rm = (int)(Math.random() * 25) +1;
                if(rm<10)
                    room += String.valueOf(0);
                room+= String.valueOf(rm);
                
                
                
                System.out.print("("+info +", "+days+",\'"+startTime+"\',\'"+endTime +"\',\'"+room+"\'d,"+prof + ")");
                if(i==19)
                    System.out.println(";");
                else
                    System.out.println(",");
            }
        }
    }
}
