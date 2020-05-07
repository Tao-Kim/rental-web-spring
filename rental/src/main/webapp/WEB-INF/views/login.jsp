<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
<form action="/admin/login">
	<div class="form-group">
	<label for="id" class="form-control-lg">아&nbsp;&nbsp;이&nbsp;&nbsp;디&nbsp;&nbsp;&nbsp;: </label>
	<input type="text" class="form-signin form-control-lg" placeholder="아이디를 입력해주세요." id="id"/>
	</div>
	
		<div class="form-group-lg">
	<label for="password" class="form-control-lg">비밀번호&nbsp;&nbsp;&nbsp;: </label>
	<input type="password" class="form-signin form-control-lg" placeholder="아이디를 입력해주세요." id="password"/>
	</div>
	<button type="submit" class="btn btn-primary btn-lg my-2 px-5" id="btn-login">로 그 인</button>
</form>
</div>
</div>
	
		
<%@ include file="includes/footer.jsp"%>
   