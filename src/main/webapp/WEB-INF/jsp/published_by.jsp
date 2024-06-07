<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Published By List</title>
</head>
<body>
<h1>Published By</h1>
<table border="1">
    <tr>
        <th>Name</th>
        <th>ISBN</th>
    </tr>
    <c:forEach var="publishedBy" items="${publishedByEntities}">
        <tr>
            <td>${publishedBy.name}</td>
            <td>${publishedBy.isbn}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>