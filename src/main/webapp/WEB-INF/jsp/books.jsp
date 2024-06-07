<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books List</title>
</head>
<body>
<h1>Books</h1>
<table border="1">
    <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>Year</th>
        <th>Price</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.year}</td>
            <td>${book.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>