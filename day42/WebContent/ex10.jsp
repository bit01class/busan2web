<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<root>
	<%
	String param=request.getParameter("cnt");
	if(param==null)param="1";
	int cnt=Integer.parseInt(param);
	for(int i=0; i<cnt; i++){
	%>
	<emp>
		<empno><%=i+1 %></empno>
		<ename><%="user"+i %></ename>
	</emp>
	<%} %>
</root>