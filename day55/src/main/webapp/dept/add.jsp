<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="${pageContext.request.contextPath }/index.action">HOME</a>
		<a href="${pageContext.request.contextPath }/intro.action">INTRO</a>
		<a href="${pageContext.request.contextPath }/dept/list.action">LIST</a>
		<a href="${pageContext.request.contextPath }/dept/add.action">INSERT</a>
	</div>
	<img alt="" src="https://dummyimage.com/600x100/000/fff&text=InsertPage">
<form action="insert.action" method="post">
	<div>
		<label>deptno</label>
		<input name="deptno">
	</div>
	<div>
		<label>dname</label>
		<input name="dname">
	</div>
	<div>
		<label>loc</label>
		<input name="loc">
	</div>
	<div>
		<button>입력</button>
	</div>
</form>
</body>
</html>












