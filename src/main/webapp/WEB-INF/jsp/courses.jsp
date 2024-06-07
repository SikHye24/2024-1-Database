<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Courses List</title>
</head>
<body>
<h1>Courses</h1>
<p>Total number of courses: ${courseCount}</p>
<table border="1">
    <tr>
        <th>CNO</th>
        <th>CNAME</th>
        <th>CREDIT</th>
        <th>SESSIONS</th>
    </tr>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.cno}</td>
            <td>${course.cname}</td>
            <td>${course.credit}</td>
            <td>${course.sessions}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>