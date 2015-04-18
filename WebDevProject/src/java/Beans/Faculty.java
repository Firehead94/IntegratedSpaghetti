
package Beans;

import java.io.Serializable;

/**
 *
 * @author Justin
 */
public class Faculty implements Serializable {
    
    private int faculty_ID;
    private int dept_ID;

    /**
     * @return the faculty_ID
     */
    public int getFaculty_ID() {
        return faculty_ID;
    }

    /**
     * @return the dept_ID
     */
    public int getDept_ID() {
        return dept_ID;
    }

    /**
     * @param faculty_ID the faculty_ID to set
     */
    public void setFaculty_ID(int faculty_ID) {
        this.faculty_ID = faculty_ID;
    }

    /**
     * @param dept_ID the dept_ID to set
     */
    public void setDept_ID(int dept_ID) {
        this.dept_ID = dept_ID;
    }
}
