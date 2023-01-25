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
		<%@ page import="java.sql.*,com.bit.stu.LocalMySql" %>
		<%
		int num=Integer.parseInt(request.getParameter("num"));
		int kor=0;
		int eng=0;
		int math=0;
		int tot=0;
		String sql="select kor,eng,math,kor+eng+math from stu33 where num="+num;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			stmt=LocalMySql.getConnection().createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				kor=rs.getInt(1);
				eng=rs.getInt(2);
				math=rs.getInt(3);
				tot=rs.getInt(4);
			}
		}finally{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(LocalMySql.getConnection()!=null)
				LocalMySql.getConnection().close();
		}
		%>
			<h2><%=num %>번 학생성적 페이지</h2>
			<table width="600" align="center">
				<tr>
					<td>학번</td>
					<td><%=num %></td>
				</tr>
				<tr>
					<td>국어</td>
					<td><%=kor %></td>
				</tr>
				<tr>
					<td>영어</td>
					<td><%=eng %></td>
				</tr>
				<tr>
					<td>수학</td>
					<td><%=math %></td>
				</tr>
				<tr>
					<td>합계</td>
					<td><%=tot %></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<a href="edit.jsp?num=<%=num%>">[수정]</a>
						<a href="delete.jsp?num=<%=num %>">[삭제]</a>
					</td>
				</tr>
			</table>
<%@ include file="../template/footer.jspf" %>
</body>
</html>