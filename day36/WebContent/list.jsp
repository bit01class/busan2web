<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>답글 게시판</h1>
<table>
	<tr>
		<th>글번호</th>
		<th>제목</th>
	</tr>
	<%@ page import="java.util.*,com.bit.BbsBean" %>
	<%@ include file="template/sql.jspf" %>
	<%
	List<BbsBean> list=new ArrayList<BbsBean>();
	String sql="select * from bbs36 order by ref desc, seq asc";
	try{
		conn=getConnection();
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		while(rs.next()){
			BbsBean bean=new BbsBean();
			bean.setNum(rs.getInt("num"));
			bean.setSub(rs.getString("sub"));
			
			list.add(bean);
		}
	}finally{
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
	for(BbsBean bean:list){
	%>
	<tr>
		<td><%=bean.getNum() %></td>
		<td><%=bean.getSub() %></td>
	</tr>
	<%} %>
</table>
<p>
	<a href="add.jsp">[입력]</a>
</p>
</body>
</html>