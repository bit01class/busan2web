<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="imgs/bg.jpg">
<table width="800" align="center" bgcolor="white">
	<tr>
		<td colspan="3">
			<img alt="logo" src="imgs/logo.png">
		</td>
		<td colspan="3"></td>
	</tr>
	<tr>
		<td height="35" background="imgs/mn1.png"></td>
		<td width="150" background="imgs/mn1.png" align="center"><a href="index.jsp">[HOME]</a></td>
		<td width="150" background="imgs/mn1.png" align="center"><a href="intro.jsp">[INTRO]</a></td>
		<td width="150" background="imgs/mn1.png" align="center"><a href="list.jsp">[B B S]</a></td>
		<td width="150" background="imgs/mn1.png" align="center"><a href="login.jsp">[LOGIN]</a></td>
		<td background="imgs/mn1.png"></td>
	</tr>
	<tr>
		<td colspan="6" height="500" valign="top">
		<%@ page import="java.util.Map,java.sql.*" %>
		<%
		String sql="select num,sub,id,nalja,content from ";
		sql+="bbs01 where num="+request.getParameter("num");
		System.out.println(sql);
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/lecture";
		Map<String,String> env=System.getenv();
		String user=env.get("local.mysql.user");
		String password=env.get("local.mysql.password");
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()){
		%>
			<h1 align="center"><%=rs.getInt(1) %>번 글</h1>
			<form action="update.jsp">
			<input type="hidden" name="num" value="<%=rs.getInt(1) %>">
			<table align="center" width="600">
				<tr>
					<td>제목</td>
					<td colspan="3"><input type="text" name="sub" value="<%=rs.getString(2) %>"></td>
				</tr>
				<tr>
					<td>글쓴이</td>
					<td><%=rs.getString(3) %></td>
					<td>날짜</td>
					<td><%=rs.getDate(4) %></td>
				</tr>
				<tr>
					<td colspan="4" height="20">
					<textarea cols="50" rows="5" name="content"><%=rs.getString(5) %></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center">
					<input type="submit" value="수 정">
					<input type="reset" value="취 소">
					</td>
				</tr>
			</table></form>
			<%
			}
		}finally{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
			%>
		</td>
	</tr>
	<tr>
		<td colspan="6" background="imgs/footer.png">
		<p>(주)비트컴퓨터</p>
<p>&copy; bitacademy co.ltd. All rights reserved.</p>
		</td>
	</tr>
</table>
</body>
</html>