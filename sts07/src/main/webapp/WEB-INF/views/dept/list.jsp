<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/header.jspf" %>
<style type="text/css">
.panel{
	cursor: pointer;
}
</style>
</head>
<body>
<%@ include file="../template/menu.jspf" %>
<div class="page-header">
  <h1>List page <small>dept list</small></h1>
</div>
<c:forEach items="${list }" var="bean">
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${bean.deptno}. ${bean.dname }</h3>
  </div>
  <div class="panel-body">
    ${bean.loc }
  </div>
</div>
</c:forEach>
<button id="add" class="btn btn-primary btn-block btn-lg">입력</button>
<div id="addform" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">입력 페이지</h4>
      </div>
      <div class="modal-body">
        <form method="post">
        	<div class="form-group">
        		<input name="deptno" class="form-control" placeholder="deptno">
        	</div>
        	<div class="form-group">
        		<input name="dname" class="form-control" placeholder="dname">
        	</div>
        	<div class="form-group">
        		<input name="loc" class="form-control" placeholder="loc">
        	</div>
        	<div class="form-group">
        		<button class="btn btn-primary">입력</button>
        		<button class="btn btn-default" type="reset">취소</button>
        		<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        	</div>
        </form>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div id="editform" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">수정 페이지</h4>
      </div>
      <div class="modal-body">
        <form method="post">
        	<div class="form-group">
        		<input name="deptno" class="form-control" placeholder="deptno">
        	</div>
        	<div class="form-group">
        		<input name="dname" class="form-control" placeholder="dname">
        	</div>
        	<div class="form-group">
        		<input name="loc" class="form-control" placeholder="loc">
        	</div>
        	<div class="form-group">
        		<button class="btn btn-primary">수정</button>
        		<button type="button" class="btn btn-danger">삭제</button>
        		<button class="btn btn-default" type="reset">취소</button>
        		<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        	</div>
        </form>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<div id="delform" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">삭제하시겠습니까?</h4>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
        <button type="button" class="btn btn-danger">삭제</button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
$('#add').click(function(){
	$('#addform').modal('toggle');
});

$('.panel').click(function(){
	$.getJSON($(this).find('h3').text().substr(0,$(this).find('h3').text().indexOf('.')))
		.done(function( data ) {
			$('#editform').find('form').find('input')
				.eq(0).val(data.deptno)
				.end()
				.eq(1).val(data.dname)
				.end()
				.eq(2).val(data.loc);
			$('#editform').modal('toggle');
		});
	});
$('#editform').find('form').submit(function(e){
	var param={deptno:Number(this.deptno.value),dname:this.dname.value,loc:this.loc.value};
	console.log(param);
	$.ajax(this.deptno.value,{
		type:'put'
		,data:JSON.stringify(param)
		,contentType:'application/json; charset=utf-8'
		,processData:false
	}).done(function(){
		location.reload();
	});
	return false;
});
$('#editform').find('form').find('.btn-danger').click(function(){
	$('#delform').modal('toggle').find('.btn-danger').click(function(){
		$.ajax($('#editform').find('form').find('input').eq(0).val(),{
			type:'delete'
		}).done(function(){
			location.reload();
		});
	});
	
});
</script>
<%@ include file="../template/footer.jspf" %>
</body>
</html>







