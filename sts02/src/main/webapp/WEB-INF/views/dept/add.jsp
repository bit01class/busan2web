<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/head.jspf" %>
<style type="text/css">
.form-group>label+span{
	color: red;
	font-style: italic;
	margin-left: 100px;
}
</style>
</head>
<body>
<%@ include file="../template/header.jspf" %>
<%@ include file="../template/menu.jspf" %>
<h2>Insert Page</h2>
<form action="insert.do" method="post">
  <div class="form-group">
    <label for="deptno">deptno</label><span>${errs.deptno }</span>
    <input type="text" class="form-control" name="deptno" id="deptno" placeholder="숫자를 입력">
  </div>
  <div class="form-group">
    <label for="dname">dname</label><span>${errs.dname }</span>
    <input type="text" class="form-control" name="dname" id="dname" placeholder="4~5자 입력">
  </div>
  <div class="form-group">
    <label for="loc">loc</label><span>${errs.loc }</span>
    <input type="text" class="form-control" name="loc" id="loc" placeholder="4~5자 입력">
  </div>
  <button type="submit" class="btn btn-primary btn-block">입력</button>
  <button type="reset" class="btn btn-default btn-block">취소</button>
  <button type="button" class="btn btn-default btn-block" onclick="history.back();">뒤로</button>
</form>
<%@ include file="../template/footer.jspf" %>
</body>
</html>







