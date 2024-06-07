<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lectures List</title>
</head>
<body>
<h1>Lectures</h1>
<p>Total number of lectures: ${lectureCount}</p>
<table border="1">
    <tr>
        <th>CNO</th>
        <th>PNO</th>
        <th>LEC_TIME</th>
        <th>ROOM</th>
    </tr>
    <c:forEach var="lecture" items="${lectures}">
        <tr>
            <td>${lecture.cno}</td>
            <td>${lecture.pno}</td>
            <td>${lecture.lecTime}</td>
            <td>${lecture.room}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>