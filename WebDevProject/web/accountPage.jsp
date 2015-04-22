<%-- 
    Document   : index
    Created on : Mar 19, 2015, 4:50:21 PM
    Author     : Justin
--%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        
        <link rel="stylesheet" href="css/main.css" type="text/css" />
    </head>
    <body class="body">
        <header>
            <jsp:include page="modules/header.jsp" />
        </header>
        <section class="main">
            <nav>                
                <jsp:include page="modules/navBar.jsp" />
            </nav>
            <section class="content">
                <article class="info">
                    <table>
                        <tr><td>First Name:</td><td>${sessionScope.user.getUser_first_name()}</td></tr>
                        <tr><td>Last Name:</td><td>${sessionScope.user.getUser_last_name()}</td></tr>
                        <tr><td>DOB:</td><td>${sessionScope.user.getUser_dob_date()}</td></tr>
                        <tr><td>Account Name:</td><td>${sessionScope.user.getUsername()}</td></tr>
                        <tr><td>Email:</td><td>${sessionScope.user.getUser_email()}</td></tr>
                        <tr><td>Address:</td><td>${sessionScope.user.getUser_address()}</td></tr>
                        <tr><td>City:</td><td>${sessionScope.user.getUser_city()}</td></tr>
                        <tr><td>State:</td><td>${sessionScope.user.getUser_state()}</td></tr>
                        <tr><td>Zip:</td><td>${sessionScope.user.getUser_zip()}</td></tr>
                    </table>
                    <button type="button" onclick="location.href = 'editProfile'" value="Edit" >Edit</button>
                </article>
            </section>  
        </section>
        
        <footer>
            <jsp:include page="modules/footer.jsp" />
        </footer>
    </body>
</html>
