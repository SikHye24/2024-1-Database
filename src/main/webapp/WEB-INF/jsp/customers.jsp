<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customers List</title>
</head>
<body>
<h1>Customers</h1>
<table border="1">
    <tr>
        <th>Email</th>
        <th>Name</th>
        <th>Address</th>
        <th>Phone</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.email}</td>
            <td>${customer.name}</td>
            <td>${customer.address}</td>
            <td>${customer.phone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>