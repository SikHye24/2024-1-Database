<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>JSP test selectAll</title>
</head>
<body>
<h2>Hello! Test Table: </h2>

<table class="table table-hover table table-striped">
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    <c:forEach items="${tests}" var="test">
    <tr>
        <th>${test.getId()}</th>
        <th>${test.getName()}</th>
    </tr>
    </c:forEach>
</body>
</html>
