<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Baskets List</title>
</head>
<body>
<h1>Shopping Baskets</h1>
<table border="1">
    <tr>
        <th>Basket ID</th>
    </tr>
    <c:forEach var="shoppingBasket" items="${shoppingBaskets}">
        <tr>
            <td>${shoppingBasket.basketid}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>