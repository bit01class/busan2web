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
		<td><img src="imgs/logo.png"></td>
	</tr>
	<tr>
		<td align="center" bgcolor="gray">
			<a href="?title=home">[HOME]</a>
			<a href="?title=intro">[INTRO]</a>
			<a href="?title=bbs/list">[E M P]</a>
			<a href="#">[DEPT]</a>
		</td>
	</tr>
	<tr>
		<td>
		<%
		boolean read=true;
		String title=request.getParameter("title");
		read=request.getParameter("read")!=null?false:true;
		title=title==null?"home":title;
		title+=".jsp";//;
		%>
		<jsp:include page="<%=title %>">
			<jsp:param value="<%=read %>" name="read"/>
		</jsp:include>
		</td>
	</tr>
	<tr>
		<td align="center" bgcolor="gray">
		&copy; by bitacademy co.ltd. All rights reserved.
		</td>
	</tr>
</table>
</body>
</html>





