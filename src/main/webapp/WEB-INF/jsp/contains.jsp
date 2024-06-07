<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contains List</title>
</head>
<body>
<h1>Contains</h1>
<table border="1">
    <tr>
        <th>Basket ID</th>
        <th>ISBN</th>
        <th>Num</th>
    </tr>
    <c:forEach var="contains" items="${contains}">
        <tr>
            <td>${contains.basketId}</td>
            <td>${contains.isbn}</td>
            <td>${contains.num}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>