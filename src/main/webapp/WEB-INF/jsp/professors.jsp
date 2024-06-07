<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Professors List</title>
</head>
<body>
<h1>Professors</h1>
<p>Total number of professors: ${professorCount}</p>
<table border="1">
    <tr>
        <th>PNO</th>
        <th>PNAME</th>
        <th>PMAJOR</th>
        <th>PDEPT</th>
    </tr>
    <c:forEach var="professor" items="${professors}">
        <tr>
            <td>${professor.pno}</td>
            <td>${professor.pname}</td>
            <td>${professor.pmajor}</td>
            <td>${professor.pdept}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>