<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css">
<style type="text/css">


</style>
<%@ include file="../template/head.jspf" %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="../template/header.jspf" %>
<%@ include file="../template/menu.jspf" %>
<h2>리스트 페이지</h2>
<div class="table">
	<div class="thead">
		<span>empno</span>
		<span>ename</span>
		<span>hiredate</span>
		<span>sal</span>
	</div>
	<%
	java.util.List<com.bit.model.EmpDto> list;
	list=(java.util.List<com.bit.model.EmpDto>)
			request.getAttribute("list");
	for(com.bit.model.EmpDto bean:list){
	%>
	<div class="tbody">
		<a href="emp.do?id=<%=bean.getId()%>">
		<span><%=bean.getEmpno() %></span>
		<span><%=bean.getEname() %></span>
		<span><%
		java.util.Date d=bean.getHiredate();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		out.print(df.format(d));
		%></span>
		<span><%=bean.getSal() %></span>
		</a>
	</div>
	<%} %>
</div>
<p><a class="btn" href="add.do">입력</a></p>
<%@ include file="../template/footer.jspf" %>
</body>
</html>








