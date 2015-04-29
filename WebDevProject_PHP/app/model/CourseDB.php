<?php

class CourseDB 
{

    public function getCourseCosts($user_id) {
        
        include '/database.php';
        require_once 'StudentDB.php';
        $student = new StudentDB();
        
        $query = 'SELECT c.COURSE_CREDITS, c.COURSE_COST
                    FROM COURSE c 
                    JOIN SECTION s 
                    ON c.COURSE_ID = s.COURSE_ID 
                    JOIN REGISTRATION r 
                    ON s.SECTION_NUM = r.SECTION_NUM 
                    JOIN STUDENT t 
                    ON r.STU_ID = t.STU_ID
                    WHERE t.STU_ID = :stu_id;';
        
        try {
            $statement = $db->prepare($query);
            $statement->bindValue(':stu_id', $student->getStudentID($user_id));
            $statement->execute();
            $result = $statement->fetchAll();
            $statement->closeCursor();
            return $result;
        } catch (Exception $e) {
            $error_message = $e->getMessage();
            echo $error_message;
        }
        
     
    }
  
}
