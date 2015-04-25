<?php

class UserDB
{

    public function __construct() 
    {
        
    }
    
    public function validateUser($user, $hash) 
    {
        include('/database.php');
        $query = 'SELECT * FROM USERS WHERE USERNAME = :username AND USER_PASSWORD = :hash';
        try {
            $statement = $db->prepare($query);
            $statement->bindValue(':username', $user);
            $statement->bindValue(':hash', $hash);
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