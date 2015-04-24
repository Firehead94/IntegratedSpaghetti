<%-- 
    Document   : courseList
    Created on : Apr 23, 2015, 3:49:46 AM
    Author     : Justin
--%>
<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <c:if test="${requestScope.errormsg != null}">
                        ${requestScope.errormsg}
                    </c:if>
                    <c:if test="${requestScope.errormsg == null}">
                        <form action="selected" method="post" >
                            <table>
                                <thead>
                                    <tr>
                                        <td>Semester</td>
                                        <td>Section Number</td>
                                        <td>Course Number</td>
                                        <td>Title</td>
                                        <td>Staff</td>
                                        <td>Day/Time</td>
                                        <td>Location</td>
                                        <td>Credits</td>
                                        <td>Select</td>
                                    </tr>
                                </thead>
                                <c:forEach varStatus="index" var="course" items="${sessionScope.sectionlist}" >
                                    <tr>
                                        <td>${course.key.getSection_semester()}</td>
                                        <td>${course.key.getSection_num()}</td>
                                        <td><d:department id="${course.key.getDept_ID()}" />${course.key.getCourse_ID()}</td>
                                        <td style="width: 150px">${course.value.getCourse_title()}</td>
                                        <td><d:faculty id="${course.key.getFaculty_ID()}" /></td>
                                        <td><d:day code="${course.key.getSection_day()}" /> <br /> <d:time time="${course.key.getSection_time_start()}" /> - <d:time time="${course.key.getSection_time_end()}" /></td>
                                        <td>${course.key.getSection_location()}</td>
                                        <td>${course.value.getCourse_credits()}</td>
                                        <td><input type="checkbox" name="selectedCourses" value="${course.key.getSection_num()}" /></td>                                    
                                    </tr>
                                </c:forEach>
                            </table>
                            <input type="submit" value="submit" /><button type="button" onclick="location.href = 'courseSelect'" value="Cancel" >Cancel</button>
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

