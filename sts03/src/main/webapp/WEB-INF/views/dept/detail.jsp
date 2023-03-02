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
<h2>Edit Page</h2>
<form action="update.do" method="post">
  <div class="form-group">
    <label for="deptno">deptno</label><span>${errs.deptno }</span>
    <input type="text" class="form-control" name="deptno" id="deptno" value="${bean.deptno }" readonly>
  </div>
  <div class="form-group">
    <label for="dname">dname</label><span>${errs.dname }</span>
    <input type="text" class="form-control" name="dname" id="dname" value="${bean.dname }">
  </div>
  <div class="form-group">
    <label for="loc">loc</label><span>${errs.loc }</span>
    <input type="text" class="form-control" name="loc" id="loc" value="${bean.loc }">
  </div>
  <button type="submit" class="btn btn-primary btn-block">수정</button>
  <button type="reset" class="btn btn-default btn-block">취소</button>
  <a href="delete.do?deptno=${bean.deptno }" class="btn btn-danger btn-block" role="button">삭제</a>
  <button type="button" class="btn btn-default btn-block" onclick="history.back();">뒤로</button>
</form>
<%@ include file="../template/footer.jspf" %>
</body>
</html>







