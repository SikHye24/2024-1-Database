<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Courses</title>
</head>
<body>
<h1>Courses for Student</h1>
<table border="1">
    <tr>
        <th>Student Name</th>
        <th>Course Name</th>
        <th>Grade</th>
        <th>Exam</th>
    </tr>
    <c:forEach var="enroll" items="${enrolls}">
        <tr>
            <td>${enroll.student.sname}</td>
            <td>${enroll.course.cname}</td>
            <td>${enroll.grade}</td>
            <td>${enroll.exam}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>