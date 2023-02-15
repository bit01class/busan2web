<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../template/head.jspf" %>
<script type="text/javascript">
$(function(){
	var callback=function(){
		history.back();
	};
	$('form button').eq(1).show();
	$('form button').eq(2).hide();
	$('form button').eq(3).click(callback);
	$('form').one('submit',function(){

		$('form button').eq(1).hide();
		$('form button').eq(2).show();
		$('form button').eq(3).off('click',callback);
		$('form button').eq(3).click(function(){
			location.reload();
		});
		$('.row>span').filter(':odd').each(function(idx,ele){
			var val=$(this).html();
			var name=$(this).prev().html();
			console.log(val,name);
			if(idx==0)
			$(this).html('<input type="text" name="'+name+'" value="'+val+'" readonly/>');
			else if(idx!=4)
			$(this).html('<input type="text" name="'+name+'" value="'+val+'"/>');
		});
		return false;
	});
});
</script>
<title>Insert title here</title>
</head>
<body>
<%@ include file="../template/header.jspf" %>
<%@ include file="../template/menu.jspf" %>
<h2>상세페이지</h2>
<%
	com.bit.model.EmpDto bean=
	(com.bit.model.EmpDto)request.getAttribute("bean");
%>
<form method="post">
<input type="hidden" name="id" value="<%=bean.getId()%>">
<div class="table">
	<div class="row">
		<span>empno</span>
		<span><%=bean.getEmpno() %></span>
		<span>ename</span>
		<span><%=bean.getEname() %></span>
	</div>
	<div class="row">
		<span>sal</span>
		<span><%=bean.getSal() %></span>
		<span>job</span>
		<span><%=bean.getJob() %></span>
		<span>hiredate</span>
		<span><%=bean.getHiredate() %></span>
	</div>
		<button class="btn">수정</button>
		<button class="btn" type="button">삭제</button>
		<button class="btn" type="reset">취소</button>
		<button class="btn" type="button">뒤로</button>
</div>
</form>
<%@ include file="../template/footer.jspf" %>
</body>
</html>






