<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../template/head.jspf" %>
<style type="text/css">
form{display:block;width: 50%;margin: 0px auto;}
.btn{width: 100%;}
form>div{margin-bottom: 5px;}
form>div>label{display:inline-block;width: 35%;}
form>div>input{width: 63%;}
</style>
<script type="text/javascript">
$(function(){
	$(":button").click(function(){history.back();});
});
</script>
<title>Insert title here</title>
</head>
<body>
<%@ include file="../template/header.jspf" %>
<%@ include file="../template/menu.jspf" %>
<h2>입력페이지</h2>
<form method="post">
	<div>
		<label>empno</label>
		<input name="empno"/>
	</div>
	<div>
		<label>ename</label>
		<input name="ename"/>
	</div>
	<div>
		<label>job</label>
		<input name="job"/>
	</div>
	<div>
		<label>sal</label>
		<input name="sal"/>
	</div>
	<div>
		<button class="btn">submit</button>
		<button class="btn" type="reset">reset</button>
		<button class="btn" type="button">back</button>
	</div>
</form>
<%@ include file="../template/footer.jspf" %>
</body>
</html>





