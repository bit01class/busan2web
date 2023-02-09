{"emp":[
<%
String driver="com.mysql.jdbc.Driver";
String url="jdbc:mysql://localhost:3306/lecture";
Map<String,String> env=System.getenv();
String user=env.get("MYSQL_USER");
String password=env.get("MYSQL_PW");
String sql="select * from emp";
Connection conn=null;
Statement stmt=null;
ResultSet rs=null;
try{
	Class.forName(driver);
	conn=DriverManager.getConnection(url, user, password);
	stmt=conn.createStatement();
	rs=stmt.executeQuery(sql);
	while(rs.next()){
		if(!rs.isFirst()) out.print(",");
%>
{
"empno":<%=rs.getInt("empno") %>,
"ename":"<%=rs.getString("ename") %>",
"hiredate":"<%=rs.getString("hiredate") %>",
"sal":<%=rs.getInt("sal") %>,
"comm":<%=rs.getInt("comm") %>
}
<%
	}
}finally{
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
} 
%>
]}
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Map,java.sql.*"%>