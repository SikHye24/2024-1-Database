<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books by Author</title>
</head>
<body>
<h1>Books by ${authorName} (${authorAddress})</h1>
<table border="1">
    <tr>
        <th>Title</th>
        <th>Stock</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.title}</td>
            <td>
                <c:forEach var="stock" items="${stocks}">
                    <c:if test="${stock.isbn == book.isbn}">
                        ${stock.num}
                    </c:if>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>