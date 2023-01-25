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
			<h2>학생성적 리스트</h2>
			<table width="600" align="center">
				<tr>
					<th>학번</th>
					<th>국어</th>
					<th>영어</th>
					<th>수학</th>
				</tr>
				<%@ page import="com.bit.stu.StuDao,java.util.*" %>
				<%
				StuDao dao=new StuDao();
				ArrayList<int[]> list=dao.selectAll();
				for(int i=0; i<list.size(); i++){
					int[] stu=list.get(i);
				%>
				<tr>
					<td><a href="detail.jsp?num=<%=stu[0] %>"><%=stu[0] %></a></td>
					<td><%=stu[1] %></td>
					<td><%=stu[2] %></td>
					<td><%=stu[3] %></td>
				</tr>
				<%} %>
			</table>
<%@ include file="../template/footer.jspf" %>
</body>
</html>