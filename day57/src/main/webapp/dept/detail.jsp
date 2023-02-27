<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>수정페이지</h1>
<form action="edit.action" method="post">
	<div>
		<label>deptno</label>
		<input name="deptno" value="${bean.deptno }"/>
	</div>
	<div>
		<label>dname</label>
		<input name="dname" value="${bean.dname }"/>
	</div>
	<div>
		<label>loc</label>
		<input name="loc" value="${bean.loc }"/>
	</div>
	<div>
		<button>수정</button>
		<a href="delete.action?deptno=${bean.deptno }">삭제</a>
	</div>
</form>
</body>
</html>