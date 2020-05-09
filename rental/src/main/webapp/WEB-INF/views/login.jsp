<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="includes/header.jsp"%>

    <section id="home-section" class="hero">
		  <div class="home-slider owl-carousel">
	      <div class="slider-item" style="background-image: url(/resources/images/bg1.jpg);"></div>
	      <div class="slider-item" style="background-image: url(/resources/images/bg2.jpg);"></div>
	      <div class="slider-item" style="background-image: url(/resources/images/bg3.jpg);"></div>
	    </div>
    </section>

<div class="container">
          <div class="col-md-12 my-5 heading-section text-center ftco-animate">

<form action="/login" method="POST">
	<div class="form-group">
	<label for="id" class="form-control-lg">아&nbsp;&nbsp;이&nbsp;&nbsp;디&nbsp;&nbsp;&nbsp;: </label>
	<input type="text" class="form-signin form-control-lg" placeholder="아이디를 입력해주세요." name="id"/>

	</div>
	
		<div class="form-group-lg">
	<label for="password" class="form-control-lg">비밀번호&nbsp;&nbsp;&nbsp;: </label>

	<input type="password" class="form-signin form-control-lg" placeholder="아이디를 입력해주세요." name="password"/>

	</div>
	<button type="submit" class="btn btn-primary btn-lg my-2 px-5" id="btn-login">로 그 인</button>
</form>
</div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">로그인 실패</h4>
			</div>
			<div class="modal-body">아이디와 비밀번호를 확인해주세요.</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>

			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<script type="text/javascript">
	$(document).ready(function() {
		var login_fail = '<c:out value="${loginFail}"/>';
		checkModal(login_fail);

		function checkModal(login_fail) {
			console.log("run checkmodal-------");
			if (login_fail === '') {
				return;
			}
			else {
				$("#myModal").modal("show");
			}

		}
	});
</script>
		
<%@ include file="includes/footer.jsp"%>
   