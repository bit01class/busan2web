<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<table width="100%">
		<tr>
			<td>
			<jsp:useBean id="login" class="com.bit.UserBean" scope="session"/>
			<img alt="" src="/day35/imgs/logo.png">
			<%if(login.isResult()){ %>
			<p align="right"><jsp:getProperty property="id" name="login"/>님 접속중.. </p>
			<%}else{ %>
			<p align="right">비회원으로 접속중.. </p>
			<%} %>
			</td>
		</tr>
