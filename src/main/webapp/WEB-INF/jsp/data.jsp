<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Data</title>
</head>
<body>
<h1>All Data</h1>

<h2>Courses</h2>
<p>Total number of courses: ${courseCount}</p>
<table border="1">
    <tr>
        <th>CNO</th>
        <th>CNAME</th>
        <th>CREDIT</th>
        <th>SESSIONS</th>
    </tr>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.cno}</td>
            <td>${course.cname}</td>
            <td>${course.credit}</td>
            <td>${course.sessions}</td>
        </tr>
    </c:forEach>
</table>

<h2>Enrolls</h2>
<p>Total number of enrolls: ${enrollCount}</p>
<table border="1">
    <tr>
        <th>SNO</th>
        <th>CNO</th>
        <th>GRADE</th>
        <th>EXAM</th>
    </tr>
    <c:forEach var="enroll" items="${enrolls}">
        <tr>
            <td>${enroll.sno}</td>
            <td>${enroll.cno}</td>
            <td>${enroll.grade}</td>
            <td>${enroll.exam}</td>
        </tr>
    </c:forEach>
</table>

<h2>Lectures</h2>
<p>Total number of lectures: ${lectureCount}</p>
<table border="1">
    <tr>
        <th>CNO</th>
        <th>PNO</th>
        <th>LEC_TIME</th>
        <th>ROOM</th>
    </tr>
    <c:forEach var="lecture" items="${lectures}">
        <tr>
            <td>${lecture.cno}</td>
            <td>${lecture.pno}</td>
            <td>${lecture.lecTime}</td>
            <td>${lecture.room}</td>
        </tr>
    </c:forEach>
</table>

<h2>Professors</h2>
<p>Total number of professors: ${professorCount}</p>
<table border="1">
    <tr>
        <th>PNO</th>
        <th>PNAME</th>
        <th>PMAJOR</th>
        <th>PDEPT</th>
    </tr>
    <c:forEach var="professor" items="${professors}">
        <tr>
            <td>${professor.pno}</td>
            <td>${professor.pname}</td>
            <td>${professor.pmajor}</td>
            <td>${professor.pdept}</td>
        </tr>
    </c:forEach>
</table>

<h2>Students</h2>
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
        <tr>
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