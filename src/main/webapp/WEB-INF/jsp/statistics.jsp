<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Statistics</title>
</head>
<body>
<h2>Book Statistics</h2>

<h3>Overall Average Price</h3>
<p>${averagePrice}</p>

<h3>Average Price by Year</h3>
<table border="1">
    <tr>
        <th>Year</th>
        <th>Average Price</th>
    </tr>
    <c:forEach var="entry" items="${averagePriceByYear}">
        <tr>
            <td>${entry[0]}</td>
            <td>${entry[1]}</td>
        </tr>
    </c:forEach>
</table>

<a href="customers">Back to Customers</a>
</body>
</html>
