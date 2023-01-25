<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ex01 page</h1>
<p>다음은 ex01 page의 내용입니다</p>
<%
int before=1111;
%>
<%@ include file="ex02.jspf" %>
<p>여기도 ex01 page의 내용입니다<%=before %></p>
</body>
</html>