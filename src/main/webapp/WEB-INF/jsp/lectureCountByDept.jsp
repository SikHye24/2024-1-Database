<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lecture Count by Department</title>
</head>
<body>
<h1>Lecture Count by Department</h1>
<table border="1">
    <tr>
        <th>Department</th>
        <th>Lecture Count</th>
    </tr>
    <c:forEach var="entry" items="${lectureCountByDept}">
        <tr>
            <td>${entry.key}</td>
            <td>${entry.value}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>