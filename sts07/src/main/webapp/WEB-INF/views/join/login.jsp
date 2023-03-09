<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/header.jspf" %>
</head>
<body>
<%@ include file="../template/menu.jspf" %>
<div class="page-header">
  <h1>Login page <small></small></h1>
</div>
<div class="alert alert-danger" role="alert">
<button type="button" class="close" data-dismiss="alert" aria-label="Close">
  <span aria-hidden="true">&times;</span>
</button>
${err }
</div>
<form method="post">
	<div class="form-group">
		<input name="dname" placeholder="dname" class="form-control" >
	</div>
	<div class="form-group">
		<input name="loc" placeholder="loc" class="form-control" >
	</div>
	<div class="form-group">
		<button>로그인</button>
	</div>
</form>
<script type="text/javascript">
if('${err}'=='') $('.alert').alert('close');
</script>
<%@ include file="../template/footer.jspf" %>
</body>
</html>







