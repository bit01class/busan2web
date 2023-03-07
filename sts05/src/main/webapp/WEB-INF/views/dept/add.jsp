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
  <li><a href="${pageContext.servletContext.contextPath }/dept/">List</a></li>
  <li class="active">Insert</li>
</ol>
<div class="page-header">
  <h1>Insert page <small>insert data</small></h1>
</div>
<form class="form-horizontal" method="post">
  <div class="form-group">
    <label for="dname" class="col-sm-2 control-label">dname</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="dname" id="dname" placeholder="DNAME" value="">
    </div>
  </div>
  <div class="form-group">
    <label for="loc" class="col-sm-2 control-label">loc</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="loc" id="loc" placeholder="LOCATION" value="">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
	    <div class="btn-group  btn-group-justified" role="group">
	      <button type="submit" class="btn btn-primary">입력</button>
	      <button type="reset" class="btn btn-default">취소</button>
	      <button type="button" class="btn btn-default" onclick="history.back();">뒤로</button>
	    </div>
    </div>
  </div>
</form>  
<%@ include file="../template/footer.jspf" %>
</body>
</html>










