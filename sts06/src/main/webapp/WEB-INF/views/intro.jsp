<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='${pageContext.servletContext.contextPath }/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/webjars/jquery/1.12.4/dist/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/webjars/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<style type="text/css">
#carousel-example-generic img{
	margin: 0px auto;
}
</style>
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
        <li class="active"><a href="${pageContext.servletContext.contextPath }/intro">Intro</a></li>
        <li class="dropdown">
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

<div class="jumbotron">
  <h1>Hello, world!</h1>
  <p>...</p>
  <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
</div>
	
</body>
</html>










