<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../template/header.jspf" %>
<%@ include file="../template/menu2.jspf" %>
			<h2>학생성적 입력페이지</h2>
			<form action="insert.jsp" method="post">
			<table width="600" align="center">
				<tr>
					<td>국어</td>
					<td><input type="text" name="kor"></td>
				</tr>
				<tr>
					<td>영어</td>
					<td><input type="text" name="eng"></td>
				</tr>
				<tr>
					<td>수학</td>
					<td><input type="text" name="math"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="입력">
						<input type="reset" value="취소">
					</td>
				</tr>
			</table>
			</form>
<%@ include file="../template/footer.jspf" %>
</body>
</html>