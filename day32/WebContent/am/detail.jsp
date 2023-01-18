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
		<td>
			<img alt="logo" src="/day32/imgs/logo.png">
		</td>
	</tr>
	<tr>
		<td bgcolor="gray">
			<p align="center">
			<a href="/day32/">[HOME]</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/day32/am/list.jsp">[ A M ]</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/day32/pm/list.jsp">[ P M ]</a>
			</p>
		</td>
	</tr>
	<tr>
		<td>
		<!-- 내용 작성 -->
		<%@ page import="java.util.*,java.sql.*" %>
		<%
		int num=Integer.parseInt(request.getParameter("num"));
		String sub="";
		String id="";
		String content="";
		java.sql.Date nalja=null;
		
		Map<String,String> env=System.getenv();
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/lecture";
		String user=env.get("local.mysql.user");
		String password=env.get("local.mysql.password");
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select sub,id,nalja,content from bbs01 where num="+num;
		try{
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				sub=rs.getString(1);
				id=rs.getString(2);
				nalja=rs.getDate(3);
				content=rs.getString(4);
			}
		}finally{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
		%>
		<h1><%=num %>번 게시글</h1>
		<table align="center" width="600">
			<tr>
				<td width="100" bgcolor="gray">제목</td>
				<td colspan="3"><%=sub %></td>
			</tr>
			<tr>
				<td width="100" bgcolor="gray">글쓴이</td>
				<td><%=id %></td>
				<td width="100" bgcolor="gray">날짜</td>
				<td><%=nalja %></td>
			</tr>
			<tr>
				<td colspan="4" height="200" valign="top">
				<pre><%=content %></pre>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<a href="edit.jsp?num=<%=num%>">[수정]</a>
					<a href="delete.jsp?num=<%=num%>">[삭제]</a>
				</td>
			</tr>
		</table>
		<!-- 내용 끝 -->
		</td>
	</tr>
	<tr bgcolor="gray">
		<td>
		<p align="center">
			&copy; by bitacademy co.ltd. All rights reserved
		</p>
		</td>
	</tr>
</table>
</body>
</html>







