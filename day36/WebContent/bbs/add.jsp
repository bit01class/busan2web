<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력페이지</h1>
	<form action="bbs/insert.jsp">
	<table width="400" align="center">
		<tr>
			<td>empno</td>
			<td><input type="text" name="empno"></td>
		</tr>
		<tr>
			<td>ename</td>
			<td><input type="text" name="ename"></td>
		</tr>
		<tr>
			<td>job</td>
			<td><input type="text" name="job"></td>
		</tr>
		<tr>
			<td>sal</td>
			<td><input type="text" name="sal"></td>
		</tr>
		<tr>
			<td>comm</td>
			<td><input type="text" name="comm"></td>
		</tr>
		<tr>
			<td>deptno</td>
			<td><input type="text" name="deptno"></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="입력">
			<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>