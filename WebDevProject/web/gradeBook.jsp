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
                
                    <c:if test="${requestScope.errormsg != null}">
                        ${requestScope.errormsg}
                    </c:if>
                    <c:if test="${requestScope.sections != null}">
                        <form action="grades" method="post" >
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
                                        <td>Select</td>
                                    </tr>
                                </thead>
                                <c:forEach varStatus="index" var="section" items="${requestScope.sections}" >
                                    <tr>
                                        <td><d:semester semester="${section.key.getSection_semester()}" /></td>
                                        <td>${section.key.section_num}</td>
                                        <td><d:department id="${section.key.dept_ID}" />${section.key.course_ID}</td>
                                        <td style="width: 150px">${section.value.course_title}</td>
                                        <td><d:day code="${section.key.section_day}" /> <br /> <d:time time="${section.key.section_time_start}" /> - <d:time time="${section.key.section_time_end}" /></td>
                                        <td>${section.key.section_location}</td>
                                        <td>${section.value.course_credits}</td>
                                        <td><input type="radio" name="selectedSection" value="${section.key.section_num}" /></td>                                    
                                    </tr>
                                </c:forEach>
                            </table>
                            <input type="submit" value="submit" /><button type="button" onclick="location.href = 'home'" value="Cancel" >Cancel</button>
                        </form>
                    </c:if>
                    <c:if test="${requestScope.students != null}">
                        <form action="finalizeGrades" method="post" >
                            <input type="hidden" name="selectedSection" value="${requestScope.selectedSection}"/>
                            <table>
                                <thead>
                                    <tr>
                                        <td>Grade</td>
                                        <td>Name</td>
                                    </tr>
                                </thead>
                                    <c:forEach items="${requestScope.students}" var="student" varStatus="loop" >
                                        <tr>                                        
                                            <td><input type="textbox" name="${student.stu_ID}" placeholder="${student.grade}" size="4" /></td>
                                            <td><d:student id="${student.stu_ID}" /></td>
                                            <input type="hidden" name="listCounter" value="${student.stu_ID}"/>
                                        </tr>
                                    </c:forEach>
                                </form>
                            </table>
                            <input type="submit" value="submit" /><button type="button" onclick="location.href = 'grades'" value="Cancel" >Cancel</button>
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
