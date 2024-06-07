<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Stocks List</title>
</head>
<body>
<h1>Stocks</h1>
<table border="1">
    <tr>
        <th>ISBN</th>
        <th>Code</th>
        <th>Num</th>
    </tr>
    <c:forEach var="stock" items="${stocks}">
        <tr>
            <td>${stock.isbn}</td>
            <td>${stock.code}</td>
            <td>${stock.num}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>