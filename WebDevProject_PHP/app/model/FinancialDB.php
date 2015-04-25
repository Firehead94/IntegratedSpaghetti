<?php

class FinancialDB
{
 
    public function __construct() 
    {
        
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
        } catch (PDOException $e) {
            $error_message = $e->getMessage();
            display_db_error($error_message);
        }
        
        var_dump($db);
    }
    
    public function getInvoices($user_id) 
    {
        include('/database.php');
        $query = 'SELECT * FROM INVOICE i, STUDENT s, FINANCIAL f WHERE'
                . ' s.USER_ID = :user_id AND s.STU_ID = f.STU_ID AND f.STU_ID = i.STU_ID';
        try {
            $statement = $db->prepare($query);
            $statement->bindValue(':user_id', $user_id);
            $statement->execute();
            $result = $statement->fetchAll();
            $statement->closeCursor();
            return $result;
        } catch (PDOException $e) {
            $error_message = $e->getMessage();
            display_db_error($error_message);
        }
        
        var_dump($db);
    }
 
}