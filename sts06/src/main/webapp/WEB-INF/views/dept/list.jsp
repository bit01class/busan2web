<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='${pageContext.servletContext.contextPath }/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/webjars/jquery/1.12.4/dist/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/webjars/bootstrap/3.1.0/js/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.servletContext.contextPath }/">비트교육센터</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="${pageContext.servletContext.contextPath }/">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="${pageContext.servletContext.contextPath }/intro">Intro</a></li>
        <li class="active dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dept <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.servletContext.contextPath }/dept/">List</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="${pageContext.servletContext.contextPath }/dept/add">Insert</a></li>
          </ul>
        </li>
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.servletContext.contextPath }/login/">Login</a></li>
        <li><a href="${pageContext.servletContext.contextPath }/join/">Join</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<p>&nbsp;</p>
<p>&nbsp;</p>

<ol class="breadcrumb">
  <li><a href="${pageContext.servletContext.contextPath }/">Home</a></li>
  <li class="active">Data</li>
</ol>

<div class="page-header">
  <h1>List page <small>Dept List</small></h1>
</div>

<div class="list-group">
	<c:forEach items="${list }" var="bean">
	  <a href="./${bean.deptno }" class="list-group-item">
	  	<span class="badge">${bean.deptno }</span>
	    <h4 class="list-group-item-heading">지역명 : ${bean.loc }</h4>
	    <p class="list-group-item-text">부서명 : ${bean.dname }</p>
	  </a>
	</c:forEach>
</div>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg btn-block" data-toggle="modal" data-target="#myModal">
  입력
</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">입력 페이지</h4>
      </div>
      <div class="modal-body">
      	<form method="post">
      		<div class="form-group">
      			<input name="deptno" placeholder="NUMBER"  class="form-control" />
      		</div>
      		<div class="form-group">
      			<input name="dname" placeholder="DOMAIN"  class="form-control" />
      		</div>
      		<div class="form-group">
      			<input name="loc" placeholder="LOCATION"  class="form-control" />
      		</div>
      		<div class="form-group text-center">
        <button type="submit" class="btn btn-primary">입력</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
      		</div>
      		
      	</form>
      </div>
    </div>
  </div>
</div>	
</body>
</html>










