<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customers</title>
</head>
<body>
<h2>Customers</h2>
<table border="1">
    <tr>
        <th>Email</th>
        <th>Name</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Details</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.email}</td>
            <td>${customer.name}</td>
            <td>${customer.address}</td>
            <td>${customer.phone}</td>
            <td><a href="customer_details?email=${customer.email}">View Details</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
