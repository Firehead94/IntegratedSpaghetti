<?php

class User
{
    public function login($username, $hash) 
    {
        $query = 'SELECT * FROM USERS WHERE USERNAME = ' . $username . ' AND USER_PASSWORD = ' . $hash;
        echo $query;
    }
    
}