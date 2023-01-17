<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">insert EMP</h1>
	<form action="insert.jsp">
	<table align="center">
	<tr>
		<td>empno</td>
		<td><input type="text" name="empno"></td>
	</tr>
	<tr>
		<td>ename</td>
		<td><input type="text" name="ename"></td>
	</tr>
	<tr>
		<td>sal</td>
		<td><input type="text" name="sal"></td>
	</tr>
	<tr>
		<td>comm</td>
		<td><input type="text" name="comm"></td>
	</tr>
	<tr>
		<td>deptno</td>
		<td><select name="deptno">
			<%@ page import="java.sql.*,java.util.Map" %>
			<%
			String sql="select distinct deptno,dname from dept";
			Map<String,String> env=System.getenv();
			Connection conn=null;
			Statement stmt=null;
			ResultSet rs=null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/lecture"
						,env.get("local.mysql.user")
						,env.get("local.mysql.password")
						);
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
			%>
			<option value="<%=rs.getString(1)%>"><%=rs.getString(2) %></option>
			<%
				}
			}finally{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}
			%>
		</select></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="입력">
		<input type="reset" value="취소">
		</td>
	</tr>
	</table>
	</form>
</body>
</html>















