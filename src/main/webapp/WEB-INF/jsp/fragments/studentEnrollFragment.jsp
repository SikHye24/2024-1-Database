<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div id="enrollTable">
    <h2>Enrollments for Student</h2>
    <table border="1">
        <tr>
            <th>Course Name</th>
            <th>Credit</th>
            <th>Exam</th>
        </tr>
        <c:forEach var="enroll" items="${enrolls}">
            <c:forEach var="course" items="${courses}">
                <c:if test="${enroll.cno == course.cno}">
                    <tr>
                        <td>${course.cname}</td>
                        <td>${course.credit}</td>
                        <td>${enroll.exam}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </c:forEach>
    </table>
</div>