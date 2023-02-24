<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<style type="text/css">
form label+span{
	color: red;
	font-style: italic;
}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</head>
<body>
	<div>
		<a href="../index.do">HOME</a>
		<a href="../intro.do">INTRO</a>
		<a href="./list.do">LIST</a>
		<a href="./add.do">INSERT</a>
	</div>
	<h2>${title }페이지</h2>
	<form action="${title eq '입력'?'insert.do':'update.do' }" method="post">
		<div class="form-group">
			<label for="deptno">deptno</label><span>${FieldErrors.deptno }</span>
			<input name="deptno" id="deptno" value="${bean.deptno }${deptno==0?'':deptno }" class="form-control" />
		</div>
		<div class="form-group">
			<label for="dname">dname</label><span>${FieldErrors.dname }</span>
			<input name="dname" id="dname" value="${bean.dname }${dname }" class="form-control" />
		</div>
		<div class="form-group">
			<label for="loc">loc</label><span>${FieldErrors.loc }</span>
			<input name="loc" id="bean.loc" value="${bean.loc }${loc }" class="form-control" />
		</div>
		<div class="form-group">
			<button class="btn btn-primary">${title }</button>
			<button type="reset" class="btn btn-default">취소</button>
		</div>
	</form>
</body>
</html>








