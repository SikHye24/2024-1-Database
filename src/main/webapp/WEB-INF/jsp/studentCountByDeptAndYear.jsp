<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Count by Department and Year</title>
</head>
<body>
<h1>Student Count by Department</h1>
<table border="1">
    <tr>
        <th>Department</th>
        <th>Student Count</th>
    </tr>
    <c:forEach var="entry" items="${studentCountByDept}">
        <tr>
            <td>${entry.key}</td>
            <td>${entry.value}</td>
        </tr>
    </c:forEach>
</table>

<h1>Student Count by Year</h1>
<table border="1">
    <tr>
        <th>Year</th>
        <th>Student Count</th>
    </tr>
    <c:forEach var="entry" items="${studentCountByYear}">
        <tr>
            <td>${entry.key}</td>
            <td>${entry.value}</td>
        </tr>
    </c:forEach>
</table>

<h1>Student Count by Department and Year</h1>
<table border="1">
    <tr>
        <th>Department</th>
        <th>Year</th>
        <th>Student Count</th>
    </tr>
    <c:forEach var="deptEntry" items="${studentCountByDeptAndYear}">
        <c:forEach var="yearEntry" items="${deptEntry.value}">
            <tr>
                <td>${deptEntry.key}</td>
                <td>${yearEntry.key}</td>
                <td>${yearEntry.value}</td>
            </tr>
        </c:forEach>
    </c:forEach>
</table>
</body>
</html>