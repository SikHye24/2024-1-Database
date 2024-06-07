<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Written By List</title>
</head>
<body>
<h1>Written By</h1>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Address</th>
        <th>ISBN</th>
        <th>Action</th>
    </tr>
    <c:forEach var="writtenBy" items="${writtenBy}">
        <tr>
            <td>${writtenBy.name}</td>
            <td>${writtenBy.address}</td>
            <td>${writtenBy.isbn}</td>
            <td><a href="author_books?name=${writtenBy.name}&address=${writtenBy.address}">View Books</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>