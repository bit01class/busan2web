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
#content{}
#content>h2{}
#content>h2+div{}
#content>h2+div>div{
width:500px;
margin: 10px auto;
}
#content>h2+div>div>span{
display:inline-block;
width: 100px;
height: 35px;
line-height: 40px;
}
#content>h2+div>div>span:nth-child(2n){
border-bottom: 1px solid gray;
}
#content>h2+div>div>span:nth-child(2n-1){
border-left: 5px solid gray;
padding-left: 5px;
color:#333333;
}
#content>h2+div>div:last-child{
	text-align: center;
}
#content>h2+div>div>a{
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
#content>h2+div>div>a:nth-child(2){
	background-color: red;
}
#footer{}
</style>
<script type="text/javascript" src="<%=root%>/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#content')
		.find('a')
			.last().click(function(){
				history.back();
			})
			.prev().click(function(){
				var url=$(this).attr('href');
				var param=url.substring(url.indexOf('?')+1);
				var url=url.substring(0,url.indexOf('?'));
				console.log(url+"\n"+param);
				if(confirm('삭제하시겠습니까?')){
					$.post(url,param,function(){
						location.replace('list.do');
					});
				}
				return false;
			})
	;
	
});
</script>
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
		<%@ page import="com.bit.model.EmpDto" %>
		<%
		EmpDto bean=(EmpDto)request.getAttribute("dto");
		%>
			<h2><%=bean.getEmpno() %></h2>
			<div>
				<div>
					<span>ename</span>
					<span><%=bean.getEname() %></span>
				</div>
				<div>
					<span>hiredate</span>
					<span><%=bean.getHiredate() %></span>
				</div>
				<div>
					<span>sal</span>
					<span><%=bean.getSal() %></span>
					<span>comm</span>
					<span><%=bean.getComm() %></span>
				</div>
				<div>
					<span>job</span>
					<span><%=bean.getJob() %></span>
					<span>mgr</span>
					<span><%=bean.getMgr() %></span>
				</div>
				<div>
					<a href="edit.do?idx=<%=bean.getEmpno()%>">수정</a>
					<a href="delete.do?idx=<%=bean.getEmpno()%>">삭제</a>
					<a href="#">뒤로</a>
				</div>
			</div>
			
		</div>
		<div id="footer">
			Copyright by bitacademy co.ltd. All rights reserved.
		</div>
	</div>
</body>
</html>