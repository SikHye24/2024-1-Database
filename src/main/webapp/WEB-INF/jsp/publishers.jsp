<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Publishers List</title>
</head>
<body>
<h1>Publishers</h1>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Address</th>
        <th>Phone</th>
        <th>URL</th>
        <th>Action</th>
    </tr>
    <c:forEach var="publisher" items="${publishers}">
        <tr>
            <td>${publisher.name}</td>
            <td>${publisher.address}</td>
            <td>${publisher.phone}</td>
            <td>${publisher.url}</td>
            <td><a href="publisher_books?name=${publisher.name}">View Books</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>