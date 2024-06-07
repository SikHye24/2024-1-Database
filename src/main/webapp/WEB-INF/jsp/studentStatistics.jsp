<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Statistics</title>
</head>
<body>
<h1>Student Statistics</h1>
<table border="1">
    <tr>
        <th>Student Number</th>
        <th>Student Name</th>
        <th>Total Credits</th>
        <th>Average Exam Score</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.sno}</td>
            <td>${student.sname}</td>
            <td>${statistics[student.sno].totalCredits}</td>
            <td>${statistics[student.sno].averageExamScore}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>