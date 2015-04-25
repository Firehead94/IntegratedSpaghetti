<?php

/**
 * Description of finance
 *
 * @author Justin
 */
class finance extends Controller {
    
    public function index() 
    {
        $this->view('finance/index', []);
    }
    
    public function login()
    {
        $user = $this->model('User');
        $username = $_POST['username'];
        $hash = md5($_POST['password']);
        echo $username;
        
        
    }
    
       
}