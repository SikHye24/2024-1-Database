<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>JSP test SelectById</title>
</head>
<body>
<h2>Hello! select by ID</h2>

<table class="table table-hover table table-striped">
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    <tr>
        <th>${test.getId()}</th>
        <th>${test.getName()}</th>
    </tr>
</table>
</body>
</html>
