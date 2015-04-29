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
        session_destroy();
        session_start();        
        
        $this->model('UserDB');
        $username = $_POST['username'];
        $hash = md5($_POST['password']);
        $user = new UserDB();
        $userinfo = $user->validateUser($username, $hash);
        $this->model('StudentDB');
        $student = new StudentDB();
        if (isset($userinfo[0]) && $student->isStudent($userinfo[0]["USER_ID"])) 
        {
            $_SESSION['userinfo'] = $userinfo;
            $this->view('finance/options', []);
        }else {           
            header("location:../finance?error=invalid");            
        }        
    }
    
    public function options() {
        session_start();
        $this->view('finance/options', []);
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
    
    public function payselect()
    {
        session_start();
        $this->model('FinancialDB');
        $finance = new FinancialDB();
        if (isset($_POST['paymentoptions'])) {
            if ($_POST['paymentoptions'] == 'new') {
                $info = array('ccn' => $_POST['ccn'], 
                         'exp' => $_POST['expdate'], 
                         'name' => $_POST['billingname'],
                         'address' => $_POST['billingaddress'], 
                         'city' => $_POST['billingcity'], 
                         'state' => $_POST['billingstate'], 
                         'zip' => $_POST['billingzip'], 
                         'userid' => $_SESSION['userinfo'][0]['USER_ID']);
                $financialinfo = $finance->insertNewFinancialRecord($info);
                if ($financialinfo == false) {
                    header("location:payment?error=exists");
                }else {
                    unset($_SESSION['financialinfo']);
                    $_SESSION['paymentmethod'] = json_decode(json_encode($financialinfo));
                }
            }else {
                $selected = json_decode($_POST['paymentoptions']);
                $_SESSION['paymentmethod'] = $selected;
                unset($_SESSION['financialinfo']);
            }
            $this->getBalanceDue();
        }else {
            echo 'fail';
        }
        $this->view('finance/pay', []);
    }
    
    private function getBalanceDue() {
        $this->model('StudentDB');
        $student = new StudentDB();
        $balance = $student->getBalanceID($_SESSION['userinfo'][0]['USER_ID']);
        $_SESSION['balance'] = $balance;
        
    }
    
    public function makePayment() {
        session_start();
        $this->model('StudentDB');
        $student = new StudentDB();
        $newBal = $student->setBalanceID($_SESSION['userinfo'][0]['USER_ID'], $_SESSION['balance'] - $_POST['amount']);
        unset($_SESSION['balance']);
        $_SESSION['balance'] = $newBal;
        $this->model('FinancialDB');
        $financial = new FinancialDB();
        $financial->newInvoice($_SESSION['paymentmethod'], $_SESSION['userinfo'][0]['USER_ID'], $_POST['amount']);
        
        $this->view('finance/thankyou');
    }
       
}