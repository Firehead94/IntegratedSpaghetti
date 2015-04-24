<%-- 
    Document   : index
    Created on : Mar 19, 2015, 4:50:21 PM
    Author     : Justin
--%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="d" uri="/WEB-INF/tlds/decoder" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <c:if test="${requestScope.errormsg != null || sessionScope.selectedlist == null}">
                        Your cart is empty.
                    </c:if>
                    <c:if test="${requestScope.errormsg == null && sessionScope.selectedlist != null}">
                        <form action="removeSelection" method="post">
                            <table>
                                <thead>
                                    <tr>
                                        <td>Semester</td>
                                        <td>Number</td>
                                        <td>Title</td>
                                        <td>Staff</td>
                                        <td>Day/Time</td>
                                        <td>Location</td>
                                        <td>Credits</td>
                                        <td>Select</td>
                                    </tr>
                                </thead>
                                <c:forEach varStatus="index" var="course" items="${sessionScope.selectedlist}" >
                                    <tr>
                                        <td>${course.key.getSection_semester()}</td>
                                        <td><d:department id="${course.key.getDept_ID()}" />${course.key.getCourse_ID()}</td>
                                        <td style="width: 150px">${course.value.getCourse_title()}</td>
                                        <td><d:faculty id="${course.key.getFaculty_ID()}" /></td>
                                        <td><d:day code="${course.key.getSection_day()}" /> <br /> <d:time time="${course.key.getSection_time_start()}" /> - <d:time time="${course.key.getSection_time_end()}" /></td>
                                        <td>${course.key.getSection_location()}</td>
                                        <td>${course.value.getCourse_credits()}</td>
                                        <td><input type="checkbox" name="removeCourses" value="${course.key.getSection_num()}" /></td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <input type="submit" value="Remove Selected" onclick="alert('Are you sure you want to remove these courses?')"/><button type="button" onclick="alert('Removed All Sections'); location.href = 'removeall'" value="Clear" >Clear</button>
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
