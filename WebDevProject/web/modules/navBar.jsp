<%-- 
    Document   : navBar
    Created on : Mar 19, 2015, 7:56:06 PM
    Author     : Justin
--%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/navbar.css" type="text/css" />


<nav class="mainNav">
    <ul>
        <li><a href="home">HOME</a></li>
        <li><a href="courseSelect">SELECT COURSES</a></li>
        <li><a href="#" onclick="window.open('http://localhost/WebDevProject_PHP/public/finance', 'Popup', 'width=400,height=600,scrollbars=yes,resizable=0');" title="popup">PAYMENT</a></li>
        <li><a href="#" onclick="window.open('http://localhost/WebDevProject_PHP/public/finance', 'Popup', 'width=400,height=600,scrollbars=yes,resizable=0');" title="popup">FINANCIAL RECORDS</a></li>
        <li><a href="grades">GRADES</a></li>
    </ul>
</nav>
