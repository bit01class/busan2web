<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path=request.getParameter("path");
    %>
		<tr>
			<td bgcolor="gray">
				<center>
					<a href="<%=path %>/">[HOME]</a>
					<a href="<%=path %>/bbs/list.jsp">[BBS]</a>
					<a href="<%=path %>/user/list.jsp">[USER]</a>
					<jsp:useBean id="login" class="com.bit.UserBean" scope="session"/>
					<%if(login.isResult()){ %>
					<a href="<%=path %>/login/logout.jsp">[LOGOUT]</a>
					<%}else{ %>
					<a href="<%=path %>/login/login.jsp">[LOGIN]</a>
					<%} %>
				</center>
			</td>
		</tr>
		<tr>
			<td>
				<!-- 내용시작부분 -->