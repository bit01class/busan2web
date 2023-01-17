<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="imgs/bg.jpg">
<table width="800" align="center" bgcolor="white">
	<tr>
		<td colspan="3">
			<img alt="logo" src="imgs/logo.png">
		</td>
		<td colspan="3"></td>
	</tr>
	<tr>
		<td height="35" background="imgs/mn1.png"></td>
		<td width="150" background="imgs/mn1.png" align="center"><a href="index.jsp">[HOME]</a></td>
		<td width="150" background="imgs/mn1.png" align="center"><a href="intro.jsp">[INTRO]</a></td>
		<td width="150" background="imgs/mn1.png" align="center"><a href="list.jsp">[B B S]</a></td>
		<td width="150" background="imgs/mn1.png" align="center"><a href="login.jsp">[LOGIN]</a></td>
		<td background="imgs/mn1.png"></td>
	</tr>
	<tr>
		<td colspan="6" height="500" valign="top">
			<h1 align="center">입력 페이지</h1>
			<form action="insert.jsp">
			<table align="center">
				<tr>
					<td>제목</td>
					<td><input type="text" name="sub"></td>
				</tr>
				<tr>
					<td>글쓴이</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="content" cols="30" rows="10"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="입 력">
						<input type="reset" value="취 소">
					</td>
				</tr>
			</table>
			</form>
		</td>
	</tr>
	<tr>
		<td colspan="6" background="imgs/footer.png">
		<p>(주)비트컴퓨터</p>
<p>&copy; bitacademy co.ltd. All rights reserved.</p>
		</td>
	</tr>
</table>
</body>
</html>