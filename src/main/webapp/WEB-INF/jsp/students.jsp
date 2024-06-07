<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Students List</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $(".student-row").click(function() {
                var sno = $(this).data("sno");
                var url = "/student/courses?sno=" + sno;
                window.location.href = url;
            });
        });
    </script>
    <style>
        .student-row {
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>Students</h1>
<p>Total number of students: ${studentCount}</p>
<table border="1">
    <tr>
        <th>SNO</th>
        <th>PNO</th>
        <th>SNAME</th>
        <th>YEAR</th>
        <th>DEPT</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr class="student-row" data-sno="${student.sno}">
            <td>${student.sno}</td>
            <td>${student.pno}</td>
            <td>${student.sname}</td>
            <td>${student.year}</td>
            <td>${student.dept}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>