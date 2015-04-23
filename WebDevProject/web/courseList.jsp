<%-- 
    Document   : courseList
    Created on : Apr 23, 2015, 3:49:46 AM
    Author     : Justin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="d" uri="/WEB-INF/tlds/decoder" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display List</title>
        
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
                        <thead>
                            <tr>Number</tr>
                            <tr>Title</tr>
                            <tr>Description</tr>
                            <tr>Staff</tr>
                            <tr>Day/Time</tr>
                            <tr>Location</tr>
                            <tr>Credits</tr>
                        </thead>
                        <c:forEach varStatus="index" var="course" items="${sessionScope.sectionlist}" >
                            <tr>
                                <td><d:department id="${course.key.getDept_ID()}" />${course.key.getCourse_ID()}</td>
                                <td>${course.value.getCourse_title()}</td>
                                <td>${course.value.getCourse_descript()}</td>
                                <td><d:faculty id="${course.key.getFaculty_ID()}" /></td>
                                <td><d:day code="${course.key.getSection_day()}" />  ${course.key.getSection_time_start()} - ${course.key.getSection_time_end()}</td>
                                <td>${course.key.getSection_location()}</td>
                                <td>${course.value.getCourse_credits()}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </article>
            </section>  
        </section>       
        <footer>
            <jsp:include page="modules/footer.jsp" />
        </footer>
    </body>
</html>

