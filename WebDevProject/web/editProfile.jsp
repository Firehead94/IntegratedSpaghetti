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
                    <form action="updateUser" method="post">
                        <table>
                            <tr><td>First Name: </td><td><input type="textbox" size="20" name="FirstName" value="${sessionScope.user.getUser_first_name()}"  /></td></tr>
                            <tr><td>Last Name:  </td><td><input type="textbox" size="20" name="LastName" value="${sessionScope.user.getUser_last_name()}"  /></td></tr>
                            <tr><td>DOB:        </td><td><input type="textbox" size="20" name="DOB" value="${sessionScope.user.getUser_dob()}" pattern="(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d"  /></td></tr>
                            <tr><td>Address:    </td><td><input type="textbox" size="20" name="Address" value="${sessionScope.user.getUser_address()}"  /></td></tr>
                            <tr><td>City:       </td><td><input type="textbox" size="5" name="City" value="${sessionScope.user.getUser_city()}"  />
                            <tr><td>State:      </td><td><input type="textbox" size="5" name="State" value="${sessionScope.user.getUser_state()}"  /></td></tr>
                            <tr><td>Zip:        </td><td><input type="textbox" size="10" name="Zip" value="${sessionScope.user.getUser_zip()}"  /></td></tr>
                            <tr><td>Country:    </td><td><input type="textbox" size="20" name="Country" value="${sessionScope.user.getUser_country()}"  /></td></tr>
                            <tr><td>Password:   </td><td><input type="password" size="10" name="Password" placeholder="Password" /></td></tr>
                            <tr><td>Confirm Password: </td><td><input type="password" size="10" name="PasswordConfirm" placeholder="Password" /></td></tr>
                        </table>
                        <input type="Submit" value="Save" name="save" /><input type="Submit" value="Cancel" name="cancel" />
                    </form>
                </article>
            </section>  
        </section>
        
        <footer>
            <jsp:include page="modules/footer.jsp" />
        </footer>
    </body>
</html>
