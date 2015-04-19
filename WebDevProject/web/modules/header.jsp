<%-- 
    Document   : header
    Created on : Mar 19, 2015, 4:59:30 PM
    Author     : Justin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/header.css" type="text/css" />

<header class="bar">
    <c:if test="${sessionScope.user == null}">
        <form action="login" method="post">
            <input type="submit" value="Login:" />
            <input type="textbox" size="10" name="loginInfo" placeholder="username" />
            <input type="password" size="5" name="loginInfo" placeholder="password" />
        </form>
        <a href="accountCreation">Create Account</a>
    </c:if>
    <c:if test="${sessionScope.user != null}">
        Welcome, <a href="profile?id=${sessionScope.user.getUser_ID()}">${sessionScope.user.getUser_first_name()} ${sessionScope.user.getUser_last_name()}</a>
    </c:if>
</header>
<section class="banner">
        <img src="images/OCC_LogoWide_White.png" height="100px" alt="OCC Logo" />
</section>