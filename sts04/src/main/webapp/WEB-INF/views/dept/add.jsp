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
  <li><a href="${pageContext.request.contextPath }/dept/list">List</a></li>
  <li class="active">Insert</li>
</ol>

<div class="page-header">
  <h1>Insert page <small>Add Dept</small></h1>
</div>
<form method="post">
  <div class="form-group">
    <label for="dname">dname</label>
    <input class="form-control" name="dname" id="dname" placeholder="dname">
  </div>
  <div class="form-group">
    <label for="loc">loc</label>
    <input class="form-control" name="loc" id="loc" placeholder="loc">
  </div>
  <div class="btn-group-vertical btn-block" role="group" aria-label="...">
  <button type="submit" class="btn btn-primary">입력</button>
  <button type="reset" class="btn btn-default">취소</button>
  <button type="button" class="btn btn-default" onclick="history.back();">뒤로</button>
  </div>
</form>

</body>
</html>













