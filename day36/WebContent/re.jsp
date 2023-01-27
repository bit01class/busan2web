<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>답글</h1>
<%@ include file="template/sql.jspf" %>
<jsp:useBean id="bean" class="com.bit.BbsBean"/>
<jsp:setProperty property="*" name="bean"/>
<%
if("GET".equals(request.getMethod())){
	String sql="select * from bbs36 where num="+bean.getNum();
	try{
		conn=getConnection();
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		if(rs.next()){
			bean.setSub(rs.getString("sub"));
			bean.setContent(rs.getString("content"));
			bean.setRef(rs.getInt("ref"));
			bean.setSeq(rs.getInt("seq"));
			bean.setLvl(rs.getInt("lvl"));
		}
	}finally{
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
}else{
	String sql=null;
	try{
		conn=getConnection();
		stmt=conn.createStatement();
	if(bean.getSeq()==0){
	String seq="(select max(seq)+1 from bbs36 a where ref=";
	seq+=bean.getRef()+")";
	sql="insert into bbs36 values ";
	sql+="((select max(num)+1 from bbs36 a),'";
	sql+=bean.getSub()+"','"+bean.getContent()+"',";
	sql+=bean.getRef()+","+seq+","+bean.getLvl()+"+1)";
	}else{
		sql="update bbs36 set seq=seq+1 where ref=";
		sql+=bean.getRef()+" and seq>"+bean.getSeq();
		
		stmt.execute(sql);
		stmt.close();
		stmt=conn.createStatement();
		
		sql="insert into bbs36 values ";
		sql+="((select max(num)+1 from bbs36 a),'";
		sql+=bean.getSub()+"','"+bean.getContent()+"',";
		sql+=bean.getRef()+","+bean.getSeq()+"+1,"+bean.getLvl()+"+1)";
	}
		stmt.executeUpdate(sql);
	}finally{
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
	response.sendRedirect("list.jsp");
}

%>
<form method="post">
<input type="hidden" name="ref" value="<%=bean.getRef()%>">
<input type="hidden" name="seq" value="<%=bean.getSeq()%>">
<input type="hidden" name="lvl" value="<%=bean.getLvl()%>">
<input type="text" name="sub" value="re:<%=bean.getSub()%>"><br>
<textarea rows="" cols="" name="content"></textarea><br>
<input type="submit" value="작성">
</form>
</body>
</html>



