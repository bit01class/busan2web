<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>주소</h1>
<c:url value="bbs/../ex01.jsp" var="link1">
	<c:param name="id" value="${'admin' }"></c:param>
	<c:param name="pw" value="${1234 }"></c:param>
</c:url>
<a href="${link1 }">link</a>
</body>
</html>