<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Details</title>
</head>
<body>
<h2>Customer Details</h2>
<p>Email: ${customer.email}</p>
<p>Name: ${customer.name}</p>
<p>Address: ${customer.address}</p>
<p>Phone: ${customer.phone}</p>

<h3>Ordered Books</h3>
<table border="1">
    <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>Publisher</th>
        <th>Author</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>
                <c:choose>
                    <c:when test="${publishers[book.isbn] != null}">
                        ${publishers[book.isbn].name}
                    </c:when>
                    <c:otherwise>
                        Unknown Publisher
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:forEach var="author" items="${authors}">
                    <c:if test="${author.isbn == book.isbn}">
                        ${author.name} (${author.address})
                    </c:if>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="customers">Back to Customers</a>
</body>
</html>
