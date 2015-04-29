<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of StudentDB
 *
 * @author Justin
 */
class StudentDB {
    
    public function __construct() {
        
    }
    
    public function getStudentID($user_id) {
        include('/database.php');
        $query = 'SELECT * FROM STUDENT WHERE USER_ID = :user_id';
        try {
            $statement = $db->prepare($query);
            $statement->bindValue(':user_id', $user_id);
            $statement->execute();
            $result = $statement->fetchAll();
            $statement->closeCursor();
            return $result[0]['STU_ID'];
        } catch (Exception $e) {
            $error_message = $e->getMessage();
            echo $error_message;
        }
    }
    
    public function isStudent($user_id) {
        include('/database.php');
        $query = 'SELECT COUNT(*) FROM STUDENT WHERE USER_ID = :user_id';
        try {
            $statement = $db->prepare($query);
            $statement->bindValue(':user_id', $user_id);
            $statement->execute();
            $result = $statement->fetchAll();
            $statement->closeCursor();
            return ($result[0]["COUNT(*)"] != '0');
        } catch (Exception $e) {
            $error_message = $e->getMessage();
            echo $error_message;
        }
        return false;
    }
    
    public function getBalanceID($user_id) {
        include('/database.php');
        $query = 'SELECT BALANCE FROM STUDENT WHERE USER_ID = :user_id';
        try {
            $statement = $db->prepare($query);
            $statement->bindValue(':user_id', $user_id);
            $statement->execute();
            $result = $statement->fetchAll();
            $statement->closeCursor();
            return $result[0]['BALANCE'];
        } catch (Exception $e) {
            $error_message = $e->getMessage();
            echo $error_message;
        }
    }
    
    public function setBalanceID($user_id, $balance) {
        include('/database.php');
        $query = 'UPDATE STUDENT SET BALANCE = :balance WHERE STU_ID = :stu_id';
        try {
            $statement = $db->prepare($query);
            $statement->bindValue(':balance', $balance);
            $statement->bindValue(':stu_id', $this->getStudentID($user_id));
            $statement->execute();
            $statement->closeCursor();
            return $this->getBalanceID($user_id);
        } catch (Exception $e) {
            $error_message = $e->getMessage();
            echo $error_message;
        }
        
    }
}
