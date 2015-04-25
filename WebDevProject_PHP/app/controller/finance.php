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
        $this->model('UserDB');
        //require_once '../app/model/UserDB.php';
        //require_once '../app/model/FinancialDB.php';
        $username = $_POST['username'];
        $hash = md5($_POST['password']);
        $user = new UserDB();
        $userinfo = $user->validateUser($username, $hash);
        if (isset($userinfo[0])) {
            $this->model('FinancialDB');
            $finance = new FinancialDB();
            $financialInfo = $finance->getFinancialRecords($userinfo[0]["USER_ID"]);
            $this->view('finance/viewRecords', ['userinfo' => $userinfo, 'financialinfo' => $financialInfo]);
        }else {           
            header("location:../finance?error=invalid");            
        }        
    }
       
}