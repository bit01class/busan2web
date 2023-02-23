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
	<div>
		<a href="${pageContext.request.contextPath }/index.action">HOME</a>
		<a href="${pageContext.request.contextPath }/intro.action">INTRO</a>
		<a href="${pageContext.request.contextPath }/dept/list.action">LIST</a>
		<a href="${pageContext.request.contextPath }/dept/add.action">INSERT</a>
	</div>
	<img alt="" src="https://dummyimage.com/600x100/000/fff&text=ListPage">
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
			<c:url value="detail.action" var="detail">
				<c:param name="id" value="${bean.id}"/>
			</c:url>
				<td><a href="${detail }" >${bean.deptno }</a></td>
				<td><a href="${detail }" >${bean.dname }</a></td>
				<td><a href="${detail }" >${bean.loc }</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>












