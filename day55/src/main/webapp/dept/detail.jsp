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
	<img alt="" src="https://dummyimage.com/600x100/000/fff&text=DetailPage">
<form action="update.action" method="post">
	<input type="hidden" name="id" value="${bean.id }">
	<div>
		<label>deptno</label>
		<input name="deptno" value="${bean.deptno }">
	</div>
	<div>
		<label>dname</label>
		<input name="dname" value="${bean.dname }">
	</div>
	<div>
		<label>loc</label>
		<input name="loc" value="${bean.loc }">
	</div>
	<div>
		<button>수정</button>
	</div>
</form>
</body>
</html>












