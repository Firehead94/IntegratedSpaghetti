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
                        <label>First Name: </label><input type="textbox" size="20" name="FirstName" placeholder="First Name" required /><br />
                        <label>Last Name:  </label><input type="textbox" size="20" name="LastName" placeholder="Last Name" required /><br />
                        <label>DOB:        </label><input type="textbox" size="20" name="DOB" placeholder="yyyy-mm-dd" pattern="(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])" required /><br />
                        <label>Address:    </label><input type="textbox" size="20" name="Address" placeholder="1234 Alphabet rd." required /><br />
                        <label>City:       </label><input type="textbox" size="5" name="City" placeholder="City" required />
                        <label>State:      </label><input type="textbox" size="5" name="State" placeholder="State" required /><br />
                        <label>Zip:        </label><input type="textbox" size="10" name="Zip" placeholder="Zip" required /><br />
                        <label>Country:    </label><input type="textbox" size="20" name="Country" placeholder="Country" required /><br />
                        <label>Password:   </label><input type="password" size="10" name="Password" placeholder="Password" required /><br />
                        <label>Confirm Password: </label><input type="password" size="10" name="PasswordConfirm" placeholder="Password" required /><br />
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
