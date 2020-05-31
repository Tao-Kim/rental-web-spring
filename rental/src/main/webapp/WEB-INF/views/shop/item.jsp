<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp"%>


<div class="hero-wrap hero-bread"
	style="background-image: url('/resources/images/bg1.jpg');"></div>

<section class="ftco-section">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 mb-5 ftco-animate">
				<img src='<c:url value="${item.itemImg}"/>' class="img-fluid"
					alt="No Image">
			</div>
			<div class="col-lg-6 product-details pl-md-5 ftco-animate">
				<h3>
					<c:out value="${item.title}" />
				</h3>
				<div class="rating d-flex">
					<p class="text-left mr-2" style="color: #bbb;">분류 :</p>
					<p class="text-left mr-2">
						<a href='/shop/list?category1=<c:out value="${item.category1}"/>'
							style="color: #bbb;"><c:out value="${item.category1}" /></a>
					</p>
					<c:if test="${item.category2 ne '-'}">
						<p class="text-left mr-2" style="color: #bbb;">></p>
						<p class="text-left mr-2">
							<a
								href="/shop/list?category1=<c:out value='${item.category1}'/>&category2=<c:out value='${item.category2}'/>"
								style="color: #bbb;"><c:out value="${item.category2}" /></a>
						</p>
					</c:if>
				</div>
				<p class="price">
					<span><c:out value="${item.itemFee}" /></span>
				</p>
				<div class="row md-3">
					<div class="col-lg-3">상품명 :</div>
					<div class="col-lg-9">
						<c:out value="${item.itemName}" />
					</div>
				</div>
				<div class="row my-3">
					<div class="col-lg-3">상품특징 :</div>
					<div class="col-lg-9">
						<c:out value="${item.itemFeatures}" />
					</div>
				</div>

				<div class="row my-3">
					<div class="col-lg-3">상품크기 :</div>
					<div class="col-lg-9">
						<c:out value="${item.itemSize}" />
					</div>
				</div>

				<div class="row my-3">
					<div class="col-lg-3">약정안내 :</div>
					<div class="col-lg-9">
						<c:out value="${item.information}" />
					</div>
				</div>

				<p class="my-4">
					<c:choose>
						<c:when test="${not empty admin}">
							<a href="#" class="btn btn-danger py-3 px-5 mr-2"><del>상담신청</del></a>
							<a href="/admin/shop/item/modify?ino=<c:out value='${item.ino}'/>" class="btn btn-secondary py-3 px-5 mr-2">수정</a>
							<a href="/admin/shop/item/delete?ino=<c:out value='${item.ino}'/>" class="btn btn-secondary py-3 px-5">삭제</a>
						</c:when>
						<c:otherwise>
							<a href="#" class="btn btn-danger py-3 px-10 mr-2"><del>상담신청</del></a>
						</c:otherwise>
					</c:choose>


				</p>
			</div>
		</div>
		<div class="col-sm-12 mt-4">
			<img class="img-fluid img-detail-view"
				src="<c:out value="${item.itemDetailImg}" />" />
		</div>
	</div>
</section>

<%@ include file="../includes/footer.jsp"%>
