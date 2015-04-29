<?php

class FinancialDB
{
 
    public function __construct() 
    {
        
    }
    

    
    public function insertNewFinancialRecord($info) {
        include('/database.php');
        require_once 'StudentDB.php';
        $student = new StudentDB();
        if (!$this->recordExists($info['userid'], $info['ccn'])) {
            $query = 'INSERT INTO FINANCIAL (CREDITCARD_NUM, EXP_DATE, BILLING_NAME, BILLING_ADDRESS, BILLING_CITY, BILLING_STATE, BILLING_ZIP, STU_ID) '
                    . 'VALUES (:ccn, :exp, :name, :address, :city, :state, :zip, :stu_id);';       
            try {
                $statement = $db->prepare($query);
                $statement->bindValue(':ccn', $info['ccn']); 
                $statement->bindValue(':exp', $info['exp']); 
                $statement->bindValue(':name', $info['name']);
                $statement->bindValue(':address', $info['address']); 
                $statement->bindValue(':city', $info['city']);
                $statement->bindValue(':state', $info['state']); 
                $statement->bindValue(':zip', $info['zip']); 
                $statement->bindValue(':stu_id', $student->getStudentID($info['userid'])); 
                $statement->execute();
                $statement->closeCursor();
                return $this->getFinancialRecord($info['userid'], $info['ccn']);
            } catch (Exception $e) {
                $error_message = $e->getMessage();
                echo $error_message;
            }        
        }else {
            return false;
        }
    }
    
    public function recordExists($user_id, $ccn) 
    {
        include('/database.php');
        $query = 'SELECT COUNT(*) FROM FINANCIAL f, STUDENT s WHERE '
                . 's.USER_ID = :user_id AND s.STU_ID = f.STU_ID AND f.CREDITCARD_NUM = :ccn';
       try {
            $statement = $db->prepare($query);
            $statement->bindValue(':user_id', $user_id);
            $statement->bindValue(':ccn', $ccn);
            $statement->execute();
            $result = $statement->fetchAll();
            $statement->closeCursor();
            return ($result[0]["COUNT(*)"] != '0');
        } catch (Exception $e) {
            $error_message = $e->getMessage();
            echo $error_message;
        }
    }
    
    public function getFinancialRecord($user_id, $ccn) 
    {
        include('/database.php');
        $query = 'SELECT * FROM FINANCIAL f, STUDENT s WHERE '
                . 's.USER_ID = :user_id AND s.STU_ID = f.STU_ID AND f.CREDITCARD_NUM = :ccn';
        try {
            $statement = $db->prepare($query);
            $statement->bindValue(':user_id', $user_id);
            $statement->bindValue(':ccn', $ccn);
            $statement->execute();
            $result = $statement->fetchAll();
            $statement->closeCursor();
            return $result;
        } catch (Exception $e) {
            $error_message = $e->getMessage();
            echo $error_message;
        }
    }
    
    public function getFinancialRecords($user_id) 
    {
        include('/database.php');
        $query = 'SELECT * FROM FINANCIAL f, STUDENT s WHERE '
                . 's.USER_ID = :user_id AND s.STU_ID = f.STU_ID';
        try {
            $statement = $db->prepare($query);
            $statement->bindValue(':user_id', $user_id);
            $statement->execute();
            $result = $statement->fetchAll();
            $statement->closeCursor();
            return $result;
        } catch (Exception $e) {
            $error_message = $e->getMessage();
            echo $error_message;
        }
        
        var_dump($db);
    }
    
    public function getInvoices($user_id) 
    {
        include('/database.php');
        $query = 'SELECT * FROM INVOICE WHERE STU_ID = (SELECT STU_ID FROM STUDENT WHERE USER_ID = :user_id)';
        try {
            $statement = $db->prepare($query);
            $statement->bindValue(':user_id', $user_id);
            $statement->execute();
            $result = $statement->fetchAll();
            $statement->closeCursor();
            return $result;
        } catch (Exception $e) {
            $error_message = $e->getMessage();
            echo $error_message;
        }
        
    }
    
    public function newInvoice($paymentmethod, $user_id, $amount)
    {
        include('/database.php');
        require_once 'StudentDB.php';
        $student = new StudentDB();
        $query = 'INSERT INTO INVOICE (CREDITCARD_NUM, STU_ID, INVOICE_PAYMENT) '
                . 'VALUES (:ccn, :stu_id, :amount);';
        try {
            $statement = $db->prepare($query);
            $statement->bindValue(':ccn', $paymentmethod->CREDITCARD_NUM);
            $statement->bindValue(':stu_id', $student->getStudentID($user_id));
            $statement->bindValue(':amount', $amount);
            $statement->execute();
            $statement->closeCursor();
        } catch (Exception $e) {
            $error_message = $e->getMessage();
            echo $error_message;
        }
    }
 
}