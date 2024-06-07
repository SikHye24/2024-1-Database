<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course Scores</title>
</head>
<body>
<h1>Highest and Lowest Scorers by Course</h1>
<h2>Highest Scorers</h2>
<table border="1">
    <tr>
        <th>Course Number</th>
        <th>Course Name</th>
        <th>Student Name</th>
        <th>Student Number</th>
        <th>Score</th>
    </tr>
    <c:forEach var="entry" items="${highestScorers}">
        <tr>
            <td>${entry.key}</td>
            <td>${entry.value.course.cname}</td>
            <td>${entry.value.student.sname}</td>
            <td>${entry.value.sno}</td>
            <td>${entry.value.exam}</td>
        </tr>
    </c:forEach>
</table>

<h2>Lowest Scorers</h2>
<table border="1">
    <tr>
        <th>Course Number</th>
        <th>Course Name</th>
        <th>Student Name</th>
        <th>Student Number</th>
        <th>Score</th>
    </tr>
    <c:forEach var="entry" items="${lowestScorers}">
        <tr>
            <td>${entry.key}</td>
            <td>${entry.value.course.cname}</td>
            <td>${entry.value.student.sname}</td>
            <td>${entry.value.sno}</td>
            <td>${entry.value.exam}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>