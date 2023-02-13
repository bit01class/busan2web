<%@page import="com.bit.model.EmpDto,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
String root=request.getContextPath();
%>
<style type="text/css">
*{
	margin: 0px;padding: 0px;
}
.container{
	width: 800px; margin: 0px auto;
}
.container>div{}
#header{
	overflow: hidden;
}
#header>h1{
	width: 205px;
	height: 42px;
	background-image: url("<%=root%>/imgs/logo.jpg");
	text-indent: -999px;
	float: left;
}
#header>div{
	float: right;
}
#header>div>form{}
#header>div>form button,#header>div>form a{
	border: 1px solid gray;
	border-radius: 2px;
	padding: 2px;
	background-color: darkgray;
	color:#333333;
	text-decoration: none;
	font-size: 12px;
	display:inline-block;
}
#menu{
	background-color: gray;
}
#menu>ul{
	list-style: none;
	overflow: hidden;
	width: 400px;
	margin: 0px auto;
}
#menu>ul>li{
	float: left;
	width: 100px;
}
#menu>ul>li>a{
	display: block;
	height: 35px;
	border: 1px solid darkgray;
	box-sizing: border-box;
	color:white;
	text-align: center;
	line-height: 35px;
	text-decoration: none;
}
#content table{
	border-collapse: collapse;
	width: 80%;
	margin: 10px auto;
}
#content table,
#content table th,
#content table td
{
	border:1px solid gray;
}
#content .box>p>a{
	box-shadow: 1px 1px 5px gray;
	display: inline-block;
	width: 100px;
	height: 50px;
	background-color: darkgreen;
	border-radius: 3px;
	text-align: center;
	line-height: 50px;
	color:white;
	font-weight: bold;
	text-decoration: none;
}
#content>p{
	text-align: center;
}
#content>p>a{
	text-shadow: -2px -2px 4px #000000;
	margin:50px auto;
	box-shadow: 1px 1px 5px gray;
	display: inline-block;
	width: 100px;
	height: 50px;
	background-color: darkgreen;
	border-radius: 3px;
	text-align: center;
	line-height: 50px;
	color:white;
	font-weight: bold;
	text-decoration: none;
}
#footer{}
</style>
<script type="text/javascript" src="<%=root%>/js/jquery-1.12.4.min.js"></script>
</head>
<body>
	<div class="container">
		<div id="header">
			<h1>비트교육센터</h1>
			<div>
				<form action="<%=root%>/user/result.do">
					<label>id</label><input />
					<label>pw</label><input type="password" />
					<button>login</button>
					<a href="<%=root%>/user/join.do">join</a>
				</form>
			</div>
		</div>
		<div id="menu">
			<ul>
				<li><a href="<%=root%>/">HOME</a></li>
				<li><a href="<%=root%>/intro.do">INTRO</a></li>
				<li><a href="<%=root%>/emp/list.do">EMP</a></li>
				<li><a href="<%=root%>/user/login.do">LOGIN</a></li>
			</ul>
		</div>
		<div id="content">
			<h2>EMP LIST</h2>
			<table>
				<thead>
					<tr>
						<th>empno</th>
						<th>ename</th>
						<th>hiredate</th>
						<th>sal</th>
					</tr>
				</thead>
				<tbody>
				<%
				List<EmpDto> list=null;
				list=(List<EmpDto>)request.getAttribute("empList");
				for(EmpDto bean:list){
				%>
				<tr>
					<td><a href="detail.do?idx=<%=bean.getEmpno() %>"><%=bean.getEmpno() %></a></td>
					<td><a href="detail.do?idx=<%=bean.getEmpno() %>"><%=bean.getEname() %></a></td>
					<td><a href="detail.do?idx=<%=bean.getEmpno() %>"><%=bean.getHiredate() %></a></td>
					<td><a href="detail.do?idx=<%=bean.getEmpno() %>"><%=bean.getSal() %></a></td>
				</tr>
				<%} %>
				</tbody>
			</table>
			<p>
				<a href="add.do">입력</a>
			</p>
		</div>
		<div id="footer">
			Copyright by bitacademy co.ltd. All rights reserved.
		</div>
	</div>
</body>
</html>