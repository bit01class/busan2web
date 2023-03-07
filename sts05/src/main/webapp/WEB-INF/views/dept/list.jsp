<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/header.jspf" %>
</head>
<body>
<%@ include file="../template/menu.jspf" %>
<ol class="breadcrumb">
  <li><a href="${pageContext.servletContext.contextPath }/">Home</a></li>
  <li class="active">list</li>
</ol>
<div class="page-header">
  <h1>List page <small>dept list</small></h1>
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
  		<tr>
  			<td><a href="detail?deptno=${bean.deptno }">${bean.deptno }</a></td>
  			<td><a href="detail?deptno=${bean.deptno }">${bean.dname }</a></td>
  			<td><a href="detail?deptno=${bean.deptno }">${bean.loc }</a></td>
  		</tr>
  	</c:forEach>
  	</tbody>
  </table>
  <p><a href="add" class="btn btn-primary btn-block" role="button">입력</a></p>
</div>
<%@ include file="../template/footer.jspf" %>
</body>
</html>