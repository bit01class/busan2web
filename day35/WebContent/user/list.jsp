<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../template/header.jsp"/>
<jsp:include page="../template/menu.jsp">
	<jsp:param value=".." name="path"/>
</jsp:include>
<h1>회원목록</h1>
<table width="400" align="center">
	<tr>
		<th width="200">번호</th>
		<th>id</th>
	</tr>
	<%@ page import="java.sql.*,com.bit.*" %>
	<%
	String sql="select * from user35";
	java.util.ArrayList<UserBean> list;
	list=new java.util.ArrayList<UserBean>();
	
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	try{
		conn=LocalSql.getConnection();
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		while(rs.next()){
			UserBean bean=new UserBean();
			bean.setNum(rs.getInt("num"));
			bean.setId(rs.getString("id"));
			list.add(bean);
		}
	}finally{
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
	for(UserBean bean:list){
	%>
		<tr>
			<td><%=bean.getNum() %></td>
			<td><%=bean.getId() %></td>
		</tr>
	<%} %>
</table>
<jsp:include page="../template/footer.jsp"/>
</body>
</html>