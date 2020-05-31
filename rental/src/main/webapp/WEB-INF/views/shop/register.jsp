<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>


<div class="hero-wrap hero-bread"
	style="background-image: url('/resources/images/bg1.jpg');"></div>
<% request.setCharacterEncoding("UTF-8"); %>
<section class="ftco-section">
	<form role="form" action="/admin/shop/register" method="post" accept-charset="UTF-8" enctype="multipart/form-data">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 mx-4 mb-5">
					<h1>상품등록</h1>
				</div>

				<div class="col-lg-12 product-details pl-md-5 ftco-animate">
					<div class="form-group row">
						<label for="img" class="col-sm-2 col-form-label col-form-label-lg">상품
							이미지</label>
						<div class="col-sm-4">
							<input type="file" name='img' id="img">
						</div>
						<div class="col-sm-6">
							<img class="img_view" src="" />
						</div>
					</div>
					<script src="/resources/js/jquery-3.2.1.min.js"></script>
					<script>
						$("#img").change(
								function() {
									if (this.files && this.files[0]) {
										var reader = new FileReader;
										reader.onload = function(data) {
											$(".img_view").attr("src",
													data.target.result).width(
													500);
										}
										reader.readAsDataURL(this.files[0]);
									}
								});
					</script>

					<div class="form-group row">
						<label for="title"
							class="col-sm-2 col-form-label col-form-label-lg">제목</label>
						<div class="col-sm-10">
							<input class="form-control" name='title' placeholder="제목">
						</div>
					</div>

					<div class="form-group row">
						<label for="category1"
							class="col-sm-2 col-form-label col-form-label-lg">대분류</label>
						<div class="col-sm-4">
							<select class="form-control" name="category1" id="category1">
								<option>정수기</option>
								<option>공기청정기</option>
								<option>비데</option>
								<option>안마의자</option>
								<option>주방가전/생활가전</option>
							</select>
						</div>
						<label for="category2"
							class="col-sm-2 col-form-label col-form-label-lg">소분류</label>
						<div class="col-sm-4">
							<select class="form-control" name="category2" id="category2">
								<option>일반정수기</option>
								<option>업소용정수기</option>
							</select>
						</div>
					</div>
					<script>
						$(document).ready(function(){
							$("#category1").change(function(){
								var c1 = $(this).val();
								$("#category2 option").remove()
								if(c1 === "정수기"){
									$("#category2").append("<option>일반정수기</option><option>업소용정수기</option>");
								} else if(c1 === "주방가전/생활가전") {
									$("#category2").append("<option>가스레인지</option><option>전기레인지</option><option>의류건조기</option><option>식기세척기</option><option>제빙기</option>");
								} else {
									$("#category2").append("<option></option>");
								}
							});
						});
					</script>
					<div class="form-group row">
						<label for="itemFee"
							class="col-sm-2 col-form-label col-form-label-lg">월렌탈료</label>
						<div class="col-sm-10">
							<textarea class="form-control form-control2" rows="5"
								name='itemFee' placeholder="월 렌탈료"></textarea>
						</div>
					</div>

					<div class="form-group row">
						<label for="itemName"
							class="col-sm-2 col-form-label col-form-label-lg">모델명</label>
						<div class="col-sm-10">
							<input class="form-control" name='itemName' placeholder="모델명">

						</div>
					</div>

					<div class="form-group row">
						<label for="itemFeatures"
							class="col-sm-2 col-form-label col-form-label-lg">제품특징</label>
						<div class="col-sm-10">
							<textarea class="form-control form-control2" rows="5"
								name='itemFeatures' placeholder="제품특징"></textarea>
						</div>
					</div>

					<div class="form-group row">
						<label for="itemSize"
							class="col-sm-2 col-form-label col-form-label-lg">제품크기</label>
						<div class="col-sm-10">
							<input class="form-control" name='itemSize' placeholder="제품크기">
						</div>
					</div>

					<div class="form-group row">
						<label for="information"
							class="col-sm-2 col-form-label col-form-label-lg">약정안내</label>
						<div class="col-sm-10">
							<textarea class="form-control form-control2" rows="5"
								name='information' placeholder="약정안내"></textarea>
						</div>
					</div>

					<div class="form-group row">
						<label for="imgDetail"
							class="col-sm-2 col-form-label col-form-label-lg">설명 이미지</label>
						<div class="col-sm-10">
							<input type="file" name='imgDetail' id="detail">
						</div>
					</div>


				</div>
					<div class="col-sm-12 text-center">
					<button type="submit" class="btn btn-danger mb-5 px-25 py-2" id="btn-submit">저장</button>
					</div>
					<div class="col-sm-12">
						<img class="img-fluid img-detail-view" src="" />
					</div>
					<script src="/resources/js/jquery-3.2.1.min.js"></script>
					<script>
						$("#detail").change(
								function() {
									if (this.files && this.files[0]) {
										var reader2 = new FileReader;
										reader2.onload = function(data) {
											$(".img-detail-view").attr("src",
													data.target.result).width(
													1100);
										}
										reader2.readAsDataURL(this.files[0]);
									}
								});
					</script>
			</div>
		</div>
	</form>
</section>






<%@ include file="../includes/footer.jsp"%>
