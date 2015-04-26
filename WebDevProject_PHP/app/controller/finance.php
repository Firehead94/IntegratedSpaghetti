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
        session_start();
        
        $this->model('UserDB');
        $username = $_POST['username'];
        $hash = md5($_POST['password']);
        $user = new UserDB();
        $userinfo = $user->validateUser($username, $hash);
        if (isset($userinfo[0])) 
        {
            $_SESSION['userinfo'] = $userinfo;
            $this->view('finance/options', []);
        }else {           
            header("location:../finance?error=invalid");            
        }        
    }
    
    public function payment()
    {
        session_start();
        $userinfo = $_SESSION['userinfo'];
        $this->model('FinancialDB');
        $finance = new FinancialDB();
        $financialinfo = $finance->getFinancialRecords($userinfo[0]["USER_ID"]);
        if (isset($financialinfo[0])) 
        {
            $_SESSION['financialinfo'] = $financialinfo;           
        }
        else 
        {
            echo 'no payment info';
        }
        $this->view('finance/payment', []);
    }
    
    public function invoices()
    {
        session_start();
        $userinfo = $_SESSION['userinfo'];
        $this->model('FinancialDB');
        $invoice = new FinancialDB();
        $invoiceinfo = $invoice->getInvoices($userinfo[0]["USER_ID"]);
        if (isset($invoiceinfo[0])) 
        {
            $_SESSION['invoiceinfo'] = $invoiceinfo;
        }
        else 
        {
            echo 'no invoices';
        }
        $this->view('finance/invoices', []);
    }
       
}