<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Discount Books</title>
</head>
<body>
<h2>Search and Discount Books by Stock</h2>

<form action="search_books_by_stock" method="post">
    <label for="stockThreshold">Stock Threshold:</label>
    <input type="number" id="stockThreshold" name="stockThreshold" required>
    <input type="submit" value="Search">
</form>

<c:if test="${not empty books}">
    <h3>Books with Stock Greater than ${stockThreshold}</h3>
    <table border="1">
        <tr>
            <th>ISBN</th>
            <th>Title</th>
            <th>Year</th>
            <th>Price</th>
            <th>Stock</th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.isbn}</td>
                <td>${book.title}</td>
                <td>${book.year}</td>
                <td>${book.price}</td>
                <td>
                    <c:forEach var="stock" items="${book.stocks}">
                        ${stock.num}
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h3>Apply Discount</h3>
    <form action="apply_discount" method="post">
        <input type="hidden" name="stockThreshold" value="${stockThreshold}">
        <label for="discount">Discount Percentage:</label>
        <input type="number" id="discount" name="discount" required>
        <input type="submit" value="Apply Discount">
    </form>
</c:if>

<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>

<a href="customers">Back to Customers</a>
</body>
</html>
