<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../template/header.jsp"/>
<jsp:include page="../template/menu.jsp">
	<jsp:param value=".." name="path"/>
</jsp:include>
	<h1>회원가입</h1>
	<form action="result.jsp" method="post">
		<table width="400" align="center">
			<tr>
				<td width="100">id</td>
				<td><input type="text" name="id" value="<%=request.getParameter("id")==null?"":request.getParameter("id")%>"></td>
			</tr>
			<tr>
				<td>pw</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td>re</td>
				<td><input type="password" name="re"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
<jsp:include page="../template/footer.jsp"/>
</body>
</html>