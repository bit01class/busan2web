<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="jumbotron">
  <h1>환영합니다!</h1>
  <p>스프링 3.X 문법으로 작성된 사이트 입니다</p>
  <p><a class="btn btn-primary btn-lg" href="./dept/list" role="button">글목록</a></p>
</div>
</body>
</html>













