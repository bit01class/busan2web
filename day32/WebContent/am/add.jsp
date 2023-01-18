<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="100%">
	<tr>
		<td>
			<img alt="logo" src="/day32/imgs/logo.png">
		</td>
	</tr>
	<tr>
		<td bgcolor="gray">
			<p align="center">
			<a href="/day32/">[HOME]</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/day32/am/list.jsp">[ A M ]</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/day32/pm/list.jsp">[ P M ]</a>
			</p>
		</td>
	</tr>
	<tr>
		<td>
		<!-- 내용 작성 -->
		<h1>입력페이지</h1>
		<form action="insert.jsp">
		<table align="center">
			<tr>
				<td>제목</td>
				<td><input type="text" name="sub" placeholder="제목입력"></td>
			</tr>
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="id" placeholder="이름입력"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="content" cols="40" rows="5"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="입력">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
		</form>
		<!-- 내용 끝 -->
		</td>
	</tr>
	<tr bgcolor="gray">
		<td>
		<p align="center">
			&copy; by bitacademy co.ltd. All rights reserved
		</p>
		</td>
	</tr>
</table>
</body>
</html>