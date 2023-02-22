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
<%@ include file="../template/menu.jspf" %>
	<h1>리스트 페이지</h1>
	<table>
		<thead>
			<tr>
				<th>deptno</th>
				<th>dname</th>
				<th>loc</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="bean">
			<tr>
				<c:url value="detail.do" var="detail">
					<c:param name="deptno" value="${bean.deptno }"></c:param>
				</c:url>
				
				<td><a href="${detail }">${bean.deptno }</a></td>
				<td><a href="${detail }">${bean.dname }</a></td>
				<td><a href="${detail }">${bean.loc }</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>