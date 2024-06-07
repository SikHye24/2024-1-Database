<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books by Publisher</title>
</head>
<body>
<h1>Books by ${publisherName}</h1>
<table border="1">
    <tr>
        <th>Title</th>
        <th>Price</th>
        <th>Stock</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.title}</td>
            <td>${book.price}</td>
            <td>
                <c:choose>
                    <c:when test="${fn:length(stocks) > 0}">
                        <c:forEach var="stock" items="${stocks}">
                            <c:if test="${stock.isbn == book.isbn}">
                                ${stock.num}
                            </c:if>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        재고 없음
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>