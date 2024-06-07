<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Authors List</title>
</head>
<body>
<h1>Authors</h1>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Address</th>
        <th>URL</th>
    </tr>
    <c:forEach var="author" items="${authors}">
        <tr>
            <td>${author.name}</td>
            <td>${author.address}</td>
            <td>${author.url}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>