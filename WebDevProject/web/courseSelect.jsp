<%-- 
    Document   : index
    Created on : Mar 19, 2015, 4:50:21 PM
    Author     : Justin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <form id="find" action="find" method="post">
                        <table>
                            <tr>
                                <td>Section Number:</td>
                                <td><input type="number" size="20" name="SectionNum" placeholder="Section Number" /></td>
                            </tr>
                            <tr>
                                <td>Course Number:</td>
                                <td><input type="number" size="20" name="CourseNum" placeholder="Course Number" /></td>
                            </tr>
                            <tr>
                                <td>Course Dept:</td>
                                <td><select name="deptlist" form="find">
                                    <c:forEach var="abr" items="${requestScope.departmentlist}" >
                                        <option value="${abr}">${abr}</option>
                                    </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Semester:</td>
                                <td><select name="semesterlist" form="find">
                                        <option value="2">Summer 2015</option>
                                        <option value="3">Fall 2015</option>
                                        <option value="1">Winter 2016</option>
                                    </select>
                                </td>
                            </tr>
                        </table> 
                        <input type="submit" value="Find Sections" name="find" /><button type="button" onclick="location.href = 'viewSelection.jsp'" value="CurrentList" >View Current</button>
                    </form>
                </article>
            </section>  
        </section>
        
        <footer>
            <jsp:include page="modules/footer.jsp" />
        </footer>
    </body>
</html>
