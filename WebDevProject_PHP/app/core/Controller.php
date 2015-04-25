<?php
/**
 * Description of Controller
 *
 * @author Justin
 */
class Controller 
{
    
    public function model($model) 
    {
        require_once '../app/model/' . $model . '.php';
    }
    
    public function view($view, $data = []) 
    {
        require_once '../app/views/' . $view . '.php';
    }
    
}
