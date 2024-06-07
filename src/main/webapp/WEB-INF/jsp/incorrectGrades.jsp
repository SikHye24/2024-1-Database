<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Incorrect Grades</title>
</head>
<body>
<h1>Incorrect Grades</h1>
<table border="1">
    <tr>
        <th>Student Name</th>
        <th>Student Number</th>
        <th>Course Number</th>
        <th>Current Grade</th>
        <th>Correct Grade</th>
        <th>Action</th>
    </tr>
    <c:forEach var="enroll" items="${incorrectGrades}">
        <tr>
            <td>${enroll.student.sname}</td>
            <td>${enroll.sno}</td>
            <td>${enroll.cno}</td>
            <td>${enroll.grade}</td>
            <td>${enroll.correctGrade}</td>
            <td>
                <form action="/student/grades/update" method="post">
                    <input type="hidden" name="sno" value="${enroll.sno}" />
                    <input type="hidden" name="cno" value="${enroll.cno}" />
                    <input type="hidden" name="correctGrade" value="${enroll.correctGrade}" />
                    <input type="submit" value="Update Grade" />
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>