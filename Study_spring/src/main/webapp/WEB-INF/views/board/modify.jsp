<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form role="form" action="/board/modify" method="post">
		<div class="form-group">
			<label>Bno</label> <input class="form-control" name="bno"
				value='<c:out value="${board.bno }"/>' readonly="readonly">
		</div>
		<div class="form-group">
			<label>Title</label> <input class="form-control" name="title"
				value='<c:out value="${board.title }"/>'>
		</div>
		<div class="form-group">
			<label>Text Area</label>
			<textarea class="form-control" rows="3" name="content"><c:out
					value="${board.content}" /></textarea>
		</div>
		<div class="form-group">
			<label>Writer</label> <input class="form-control" name="writer"
				value='<c:out value="${board.writer }"/>' readonly="readonly">
		</div>
		<div class="form-group">
			<label>RegDate</label> <input class="form-control" name="regDate"
				value='<fmt:formatDate pattern ="yyyy/MM/dd" value="${board.regdate}"/>'
				readonly="readonly">
		</div>
		<div class="form-group">
			<label>Update</label> <input class="form-control" name="updateDate"
				value='<fmt:formatDate pattern ="yyyy/MM/dd" value="${board.updateDate}"/>'
				readonly="readonly">
		</div>
		<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
		<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
		<button type="submit" data-oper='list' class="btn btn-info">List</button>

	</form>

</body>
<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form");
		$('button').on("click", function(e) {
			e.preventDefault();
			var operation = $(this).data("oper");
			console.log(operation);

			if (operation === 'remove') {
				formObj.attr("action", "/board/remove");
			} else if (operation === 'list') {
				//move to list
				self.location = "/board/list";
				return;
			}
			formObj.submit();
		});
	});
</script>
</html>
<%@include file="../include/footer.jsp"%>