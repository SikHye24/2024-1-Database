<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course Statistics</title>
</head>
<body>
<h1>Course Statistics</h1>
<table border="1">
    <tr>
        <th>Course Number</th>
        <th>Course Name</th>
        <th>Average Score</th>
        <th>Grade</th>
        <th>Student Count</th>
    </tr>
    <c:forEach var="entry" items="${courseStatistics}">
        <tr>
        <td rowspan="${entry.value.gradeCounts.size()}">${entry.key}</td>
        <td rowspan="${entry.value.gradeCounts.size()}">${courseNames[entry.key]}</td>
        <td rowspan="${entry.value.gradeCounts.size()}">${entry.value.averageScore}</td>
        <c:forEach var="gradeEntry" items="${entry.value.gradeCounts}">
            <c:if test="${not empty gradeEntry.key}">
                <tr>
                    <td>${gradeEntry.key}</td>
                    <td>${gradeEntry.value}</td>
                </tr>
            </c:if>
        </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>