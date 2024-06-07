<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Baskets List</title>
</head>
<body>
<h1>Baskets</h1>
<table border="1">
    <tr>
        <th>Email</th>
        <th>Basket ID</th>
    </tr>
    <c:forEach var="basket" items="${baskets}">
        <tr>
            <td>${basket.email}</td>
            <td>${basket.basketId}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>