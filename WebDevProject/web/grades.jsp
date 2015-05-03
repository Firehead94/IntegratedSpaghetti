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
                    
                    <c:if test="${requestScope.grades != null}">
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
                            <!-- Map<Course, Map<Section,Registration>> -->
                            <c:forEach varStatus="index" var="map" items="${requestScope.grades}" >
                                <tr>
                                    <td><d:semester semester="${map.get(1).section_semester}" /></td>
                                    <td>${map.get(1).section_num}</td>
                                    <td><d:department id="${map.get(1).dept_ID}" />${map.get(0).course_ID}</td>
                                    <td style="width: 150px">${map.get(0).course_title}</td>
                                    <td><d:day code="${map.get(1).section_day}" /> <br /> <d:time time="${map.get(1).section_time_start}" /> - <d:time time="${map.get(1).section_time_end}" /></td>
                                    <td>${map.get(1).section_location}</td>
                                    <td>${map.get(0).course_credits}</td>
                                    <td>${map.get(2).grade}</td>                              
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                    
                    
                            <% request.getParameter("grades"); %> test1 <br />
        <%= request.getParameter("grades") %> test2 <br />
                </article>
            </section>  
        </section>
        
        <footer>
            <jsp:include page="modules/footer.jsp" />
        </footer>
    </body>
</html>
