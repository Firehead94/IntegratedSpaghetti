<%-- 
    Document   : accountCreation
    Created on : Apr 19, 2015, 11:59:09 AM
    Author     : Justin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        
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
                    <form action="create" method="post">
                        <table>
                            <tr><td>First Name: </td><td><input type="textbox" size="20" name="FirstName" placeholder="First Name" required /></td></tr>
                            <tr><td>Last Name:  </td><td><input type="textbox" size="20" name="LastName" placeholder="Last Name" required /></td></tr>
                            <tr><td>DOB:        </td><td><input type="textbox" size="20" name="DOB" placeholder="MM-dd-yyyy" pattern="(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d" required /></td></tr>
                            <tr><td>Address:    </td><td><input type="textbox" size="20" name="Address" placeholder="1234 Alphabet rd." required /></td></tr>
                            <tr><td>City:       </td><td><input type="textbox" size="5" name="City" placeholder="City" required />
                            <tr><td>State:      </td><td><input type="textbox" size="5" name="State" placeholder="State" required /></td></tr>
                            <tr><td>Zip:        </td><td><input type="textbox" size="10" name="Zip" placeholder="Zip" pattern="[0-9]+" required /></td></tr>
                            <tr><td>Country:    </td><td><input type="textbox" size="20" name="Country" placeholder="Country" required /></td></tr>
                            <tr><td>Password:   </td><td><input type="password" size="10" name="Password" placeholder="Password" required /></td></tr>
                            <tr><td>Confirm Password: </td><td><input type="password" size="10" name="PasswordConfirm" placeholder="Password" required /></td></tr>
                        </table>
                        <input type="Submit" value="Create Account" />
                    </form>
                </article>
            </section>  
        </section>
        
        <footer>
            <jsp:include page="modules/footer.jsp" />
        </footer>
    </body>
</html>
