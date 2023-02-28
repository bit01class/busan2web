<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/head.jspf" %>
</head>
<body>
<%@ include file="../template/header.jspf" %>
<%@ include file="../template/menu.jspf" %>

<h2>List Page</h2>
<table class="table">
	<thead>
		<tr>
			<th>deptno</th>
			<th>dname</th>
			<th>loc</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list }" var="bean">
	<c:url value="detail.do" var="detail">
		<c:param name="deptno" value="${bean.deptno }"/>
	</c:url>
		<tr>
			<td><a href="${detail }">${bean.deptno }</a></td>
			<td><a href="${detail }">${bean.dname }</a></td>
			<td><a href="${detail }">${bean.loc }</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<%@ include file="../template/footer.jspf" %>
</body>
</html>