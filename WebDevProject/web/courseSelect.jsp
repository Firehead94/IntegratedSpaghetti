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
        <title>Course Selection</title>
        
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
                        <tr>
                            <td>Section Number:</td>
                            <!--Textbox -->
                        </tr>
                        <tr>
                            <td>Course Number:</td>
                            <!--Textbox -->
                        </tr>
                        <tr>
                            <td>Course Dept:</td>
                            <!--Drop down -->
                        </tr>
                        <tr>
                            <td>Semester:</td>
                            <!--Drop down -->
                        </tr>
                    </table> 
                    <!--Submit button -->
                </article>
            </section>  
        </section>
        
        <footer>
            <jsp:include page="modules/footer.jsp" />
        </footer>
    </body>
</html>
