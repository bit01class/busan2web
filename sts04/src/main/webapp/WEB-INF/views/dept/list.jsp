<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css">
<style type="text/css">
	.navbar-brand>img{
		height: 100%;
	}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-1.12.4.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script> 
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">
        <img alt="Brand" src="${pageContext.request.contextPath }/resources/imgs/logo.jpg">
      </a>
    </div>
    <a class="navbar-text text-uppercase" href="${pageContext.request.contextPath }/">home</a>
    <a class="navbar-text text-uppercase" href="${pageContext.request.contextPath }/intro">intro</a>
    <a class="navbar-text text-uppercase" href="${pageContext.request.contextPath }/dept/list">dept</a>
    <a class="navbar-text text-uppercase navbar-right" href="${pageContext.request.contextPath }/join/login">login</a>
  </div>
</nav>

<ol class="breadcrumb">
  <li><a href="${pageContext.request.contextPath }/">Home</a></li>
  <li class="active">Dept</li>
</ol>

<div class="page-header">
  <h1>List page <small>Dept list</small></h1>
</div>

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

<a class="btn btn-default btn-block" href="add" role="button">입력</a>
</body>
</html>













