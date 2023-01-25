<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.bit.stu.StuDao" %>
<%
request.setCharacterEncoding("utf-8");
int kor=Integer.parseInt(request.getParameter("kor"));
int eng=Integer.parseInt(request.getParameter("eng"));
int math=Integer.parseInt(request.getParameter("math"));

StuDao dao=new StuDao();
dao.insertOne(kor,eng,math);
response.sendRedirect("list.jsp");
%>
</body>
</html>







