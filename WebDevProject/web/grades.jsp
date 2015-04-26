<%-- 
    Document   : index
    Created on : Mar 19, 2015, 4:50:21 PM
    Author     : Justin
--%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="d" uri="/WEB-INF/tlds/decoder" %>
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
                    
                    <c:if test="${requestScope.sections != null}">
                        <form action="grades" method="post" >
                            kytcytcfiycfkyctc
                            <table>
                                <thead>
                                    <tr>
                                        <td>Semester</td>
                                        <td>Section Number</td>
                                        <td>Course Number</td>
                                        <td>Title</td>
                                        <td>Day/Time</td>
                                        <td>Location</td>
                                        <td>Credits</td>
                                        <td>Grade</td> 
                                    </tr>
                                </thead>
                                <c:forEach varStatus="index" var="section" items="${requestScope.sections}" >
                                    <tr>
                                        <td><d:semester semester="${section.key.getSection_semester()}" /></td>
                                        <td>${section.key.getSection_num()}</td>
                                        <td><d:department id="${section.key.getDept_ID()}" />${section.key.getCourse_ID()}</td>
                                        <td style="width: 150px">${section.value.getCourse_title()}</td>
                                        <td><d:day code="${section.key.getSection_day()}" /> <br /> <d:time time="${section.key.getSection_time_start()}" /> - <d:time time="${section.key.getSection_time_end()}" /></td>
                                        <td>${section.key.getSection_location()}</td>
                                        <td>${section.value.getCourse_credits()}</td>
                                        <td></td>                              
                                    </tr>
                                </c:forEach>
                            </table>
                            <input type="submit" value="submit" /><button type="button" onclick="location.href = 'home'" value="Cancel" >Cancel</button>
                        </form>
                    </c:if>
                    
                </article>
            </section>  
        </section>
        
        <footer>
            <jsp:include page="modules/footer.jsp" />
        </footer>
    </body>
</html>
