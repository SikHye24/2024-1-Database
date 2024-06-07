<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enrolls List</title>
</head>
<body>
<h1>Enrolls</h1>
<p>Total number of enrolls: ${enrollCount}</p>
<table border="1">
    <tr>
        <th>SNO</th>
        <th>CNO</th>
        <th>GRADE</th>
        <th>EXAM</th>
    </tr>
    <c:forEach var="enroll" items="${enrolls}">
        <tr>
            <td>${enroll.sno}</td>
            <td>${enroll.cno}</td>
            <td>${enroll.grade}</td>
            <td>${enroll.exam}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>