<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Author Statistics</title>
</head>
<body>
<h2>Author Statistics</h2>

<table border="1">
    <tr>
        <th>Author</th>
        <th>Total Books</th>
        <th>Highest Price</th>
        <th>Lowest Price</th>
        <th>Average Price</th>
    </tr>
    <c:forEach var="entry" items="${authorStatistics}">
        <tr>
            <td>${entry[0]}</td>
            <td>${entry[1]}</td>
            <td>${entry[2]}</td>
            <td>${entry[3]}</td>
            <td>${entry[4]}</td>
        </tr>
    </c:forEach>
</table>

<a href="customers">Back to Customers</a>
</body>
</html>
