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
		<h1>페이징된 게시판</h1>
		
		<table border="1" cellspacing="0" align="center" width="600">
			<tr>
				<th width="100">글번호</th>
				<th>제목</th>
				<th width="100">글쓴이</th>
				<th width="100">날짜</th>
			</tr>
			<%@ page import="java.sql.*,java.util.Map" %>
			<%
			int limit=10;
			String msgLimit=request.getParameter("limit");
			if(msgLimit!=null)limit=Integer.parseInt(msgLimit);
			String key=request.getParameter("key");
			if(key==null)key="sub";
			String word=request.getParameter("word");
			if(word==null)word="";
			int maxCnt=0;
			String msgP=request.getParameter("page");
			int p=1;
			if(msgP!=null)p=Integer.parseInt(msgP);
			//String sql="select num,sub,id,nalja from bbs01 where num>=(select max(num)-10 from bbs01)-10*"+p+" and num<=(select max(num) from bbs01)-10*"+p+" order by num desc";
			//String sql="select num,sub,id,nalja from ";
			//sql+="(select num,sub,id,nalja,@rownum:=@rownum+1 ";
			//sql+=" as rn from bbs01 , (select @rownum:=0 from dual)R";
			//sql+=" order by num desc)R2 where rn>=1+10*";
			//sql+=(p-1)+" and rn<=10+10*"+(p-1);
			String sql="select num,sub,id,nalja from bbs01 where "+key;
			sql+=" like '%"+word+"%' order by num desc limit "+limit;
			sql+=" offset "+(limit*(p-1));
			
			String sql2="select CEILING(count(*)/"+limit;
			sql2+=") from bbs01 where "+key+" like '%"+word+"%'";
			
			Map<String,String> env=System.getenv();
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/lecture";
			String user=env.get("local.mysql.user");
			String password=env.get("local.mysql.password");
			Connection conn=null;
			Statement stmt=null;
			ResultSet rs=null;
			try{
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user, password);
				// get maxCnt
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql2);
				if(rs.next())maxCnt=rs.getInt(1);
				rs.close();
				stmt.close();
				// get List
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
			%>
			<tr>
				<td><%=rs.getInt(1) %></td>
				<td><%=rs.getString(2) %></td>
				<td><%=rs.getString(3) %></td>
				<td><%=rs.getDate(4) %></td>
			</tr>
			<%
				}
			}finally{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}
			%>
			<tr align="center">
				<td colspan="4">
				<form>
					<select name="key">
						<option value="sub">제목</option>
						<option value="id">글쓴이</option>
						<option value="content">내용</option>
					</select>
					<input type="text" name="word">
					<input type="submit" value="검색">
				</form>
				<%
				int start=0+5*((p-1)/5);
				int end=start+5;//maxCnt
				if(end>maxCnt)end=maxCnt;
				if(start!=0){%>
				<a href="list.jsp?limit=<%=limit %>&page=<%=start-1%>&key=<%=key%>&word=<%=word%>">[prev]</a>
				<%}
				for(int i=start; i<end; i++){ 
				%>
					<a href="list.jsp?limit=<%=limit %>&page=<%=i+1%>&key=<%=key%>&word=<%=word%>">[<%=i+1 %>]</a>
				<%} 
				if(end<maxCnt){%>
				<a href="list.jsp?limit=<%=limit %>&page=<%=end+1%>&key=<%=key%>&word=<%=word%>">[next]</a>
				<%} %>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="right">
					<a href="list.jsp?limit=5&page=<%=p%>&key=<%=key%>&word=<%=word%>">[5개씩 보기]</a>
					<a href="list.jsp?limit=10&page=<%=p%>&key=<%=key%>&word=<%=word%>">[10개씩 보기]</a>
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