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
                    <form id="find" action="fine" method="post">
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
                                <td><select>
                                    <c:forEach var="abr" items="${requestScope.departmentlist}" >
                                        <option value="${abr}" form="find">${abr}</option>
                                    </c:forEach>
                                </select></td>
                            </tr>
                            <tr>
                                <td>Semester:</td>
                                <td><select>
                                        <option value="Summer1" form="find">Summer I 2015</option>
                                        <option value="Summer2" form="find">Summer II 2015</option>
                                        <option value="Fall" form="find">Fall 2015</option>
                                        <option value="Winter" form="find">Winter 2016</option>
                                    </select></td>
                            </tr>
                        </table> 
                        <input type="submit" value="Find Sections" name="find" />
                    </form>
                </article>
            </section>  
        </section>
        
        <footer>
            <jsp:include page="modules/footer.jsp" />
        </footer>
    </body>
</html>
