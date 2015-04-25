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
                                        <td>Staff</td>
                                        <td>Day/Time</td>
                                        <td>Location</td>
                                        <td>Credits</td>
                                        <td>Select</td>
                                    </tr>
                                </thead>
                                <c:forEach varStatus="index" var="section" items="${sessionScope.sections}" >
                                    <tr>
                                        <d:semester semester="${section.key.getSection_semester()}" />
                                        <td>${section.key.getSection_num()}</td>
                                        <td><d:department id="${section.key.getDept_ID()}" />${section.key.getCourse_ID()}</td>
                                        <td style="width: 150px">${section.value.getCourse_title()}</td>
                                        <td><d:faculty id="${section.key.getFaculty_ID()}" /></td>
                                        <td><d:day code="${section.key.getSection_day()}" /> <br /> <d:time time="${section.key.getSection_time_start()}" /> - <d:time time="${course.key.getSection_time_end()}" /></td>
                                        <td>${section.key.getSection_location()}</td>
                                        <td>${section.value.getCourse_credits()}</td>
                                        <td><input type="checkbox" name="selectedSection" value="${section.key.getSection_num()}" /></td>                                    
                                    </tr>
                                </c:forEach>
                            </table>
                            <input type="submit" value="submit" /><button type="button" onclick="location.href = 'courseSelect'" value="Cancel" >Cancel</button>
                        </form>
                    </c:if>
                    <c:if test="${requestScope.students != null}">
                        <form action="selected" method="post" >
                            <table>
                                <thead>
                                    <tr>
                                        <td>Name</td>
                                        <td>Grade</td>
                                    </tr>
                                </thead>
                                <jsp:useBean id="newGrades" class="java.util.HashMap" scope="request" />
                                <form action="updateGrades" method="post" >
                                    <c:foreach items="${requestScope.students}" var="grade" >
                                        <tr>                                        
                                            <tr><td><d:student id="${grade.getStu_ID()}" /></td><td><c:set target="${requestScope.newGrades}" property="${grade.getGrade()}" value="<input type="textbox" name="newGrades" value="${grade.getGrade()}" />" /></td></tr>
                                            </form>                               
                                        </tr>
                                    </c:forEach>
                                </form>
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
