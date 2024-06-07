<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Warehouses List</title>
</head>
<body>
<h1>Warehouses</h1>
<table border="1">
    <tr>
        <th>Code</th>
        <th>Address</th>
        <th>Phone</th>
    </tr>
    <c:forEach var="warehouse" items="${warehouses}">
        <tr>
            <td>${warehouse.code}</td>
            <td>${warehouse.address}</td>
            <td>${warehouse.phone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>