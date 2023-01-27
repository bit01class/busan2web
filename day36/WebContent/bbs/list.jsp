<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../template/sql.jspf" %>
<%@ page import="java.util.*,com.bit.EmpBean" %>
<%
List<EmpBean> list=new ArrayList<EmpBean>();
String sql="select * from emp";
try{
	conn=getConnection();
	stmt=conn.createStatement();
	rs=stmt.executeQuery(sql);
	while(rs.next()){
		EmpBean bean=new EmpBean();
		bean.setEmpno(rs.getInt("empno"));
		bean.setEname(rs.getString("ename"));
		bean.setHiredate(rs.getTimestamp("hiredate"));
		list.add(bean);
	}
}finally{
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
%>
<table width="80%" align="center">
	<tr>
		<th>empno</th>
		<th>ename</th>
		<th>hiredate</th>
	</tr>
	<%for(EmpBean bean:list){ %>
	<tr>
		<td><a href="./?title=bbs/detail&empno=<%=bean.getEmpno() %>"><%=bean.getEmpno() %></a></td>
		<td><a href="./?title=bbs/detail&empno=<%=bean.getEmpno() %>"><%=bean.getEname() %></a></td>
		<td><a href="./?title=bbs/detail&empno=<%=bean.getEmpno() %>"><%=bean.getHiredate() %></a></td>
	</tr>
	<%} %>
</table>
	<p align="center">
		<a href="./?title=bbs/add">[입력]</a>
	</p>
</body>
</html>





