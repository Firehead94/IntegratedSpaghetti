
package Beans;

import java.io.Serializable;

/**
 *
 * @author Justin
 */
public class Student implements Serializable {
    
    private int stu_ID;
    private int program_ID;

    /**
     * @return the stu_ID
     */
    public int getStu_ID() {
        return stu_ID;
    }

    /**
     * @return the program_ID
     */
    public int getProgram_ID() {
        return program_ID;
    }

    /**
     * @param stu_ID the stu_ID to set
     */
    public void setStu_ID(int stu_ID) {
        this.stu_ID = stu_ID;
    }

    /**
     * @param program_ID the program_ID to set
     */
    public void setProgram_ID(int program_ID) {
        this.program_ID = program_ID;
    }
    
}
