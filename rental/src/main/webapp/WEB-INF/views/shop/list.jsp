<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../includes/header.jsp"%>

<div class="hero-wrap hero-bread"
	style="background-image: url('/resources/images/bg1.jpg');"></div>

<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-10 mb-5 text-center">
				<ul class="product-category">

					<c:choose>
						<c:when test="${param.category1 eq '정수기'}">
							<li><a href="/shop/list?category1=정수기"
								class="<c:if test='${empty param.category2}'>active</c:if>">All</a></li>
							<li><a href="/shop/list?category1=정수기&category2=일반정수기"
								class="<c:if test='${param.category2 eq "일반정수기"}'>active</c:if>">일반정수기</a></li>
							<li><a href="/shop/list?category1=정수기&category2=업소용정수기"
								class="<c:if test='${param.category2 eq "업소용정수기"}'>active</c:if>">업소용정수기</a></li>
						</c:when>
						<c:when test="${param.category1 eq '주방가전/생활가전'}">
							<li><a href="/shop/list?category1=주방가전/생활가전"
								class="<c:if test='${empty param.category2}'>active</c:if>">All</a></li>
							<li><a href="/shop/list?category1=주방가전/생활가전&category2=가스레인지"
								class="<c:if test='${param.category2 eq "가스레인지"}'>active</c:if>">가스레인지</a></li>
							<li><a href="/shop/list?category1=주방가전/생활가전&category2=전기레인지"
								class="<c:if test='${param.category2 eq "전기레인지"}'>active</c:if>">전기레인지</a></li>
							<li><a href="/shop/list?category1=주방가전/생활가전&category2=의류건조기"
								class="<c:if test='${param.category2 eq "의류건조기"}'>active</c:if>">의류건조기</a></li>
							<li><a href="/shop/list?category1=주방가전/생활가전&category2=식기세척기"
								class="<c:if test='${param.category2 eq "식기세척기"}'>active</c:if>">식기세척기</a></li>
							<li><a href="/shop/list?category1=주방가전/생활가전&category2=제빙기"
								class="<c:if test='${param.category2 eq "제빙기"}'>active</c:if>">제빙기</a></li>
						</c:when>
						<c:when test="${param.category1 eq '공기청정기'}">
							<li><a href="/shop/list?category1=공기청정기" class="active">All</a></li>
						</c:when>
						<c:when test="${param.category1 eq '비데'}">
							<li><a href="/shop/list?category1=비데" class="active">All</a></li>
						</c:when>
						<c:when test="${param.category1 eq '안마의자'}">
							<li><a href="/shop/list?category1=안마의자" class="active">All</a></li>
						</c:when>
					</c:choose>

					<c:if test="${not empty admin}">
						<li><a href="/admin/shop/register"
							id="product-category-admin">상품등록</a></li>
					</c:if>
				</ul>
			</div>
		</div>

		<div class="row">
			<c:if test="${empty items }">
				<p class="lead">등록된 상품이 없습니다.</p>
			</c:if>
			<c:forEach items="${items}" var="item">
				<div class="col-md-6 col-lg-3 ftco-animate">
					<div class="product">
						<a href="/shop/item?ino=<c:out value='${item.ino}'/>" class="img-prod"><img class="img-fluid"
							src='<c:url value="${item.itemThumbImg}"/>' alt="No Image"></a>
						<div class="text py-3 pb-4 px-3 text-center">
							<h3>
								<a href="/shop/item?ino=<c:out value='${item.ino}'/>"><c:out value="${item.title}" /></a>
							</h3>
							<div class="d-flex">
								<div class="pricing">
									<p class="price">
										<span><c:out value="${item.itemFee}" /></span>
									</p>
								</div>
							</div>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>

		<!-- 	<div class="row mt-5">
		<div class="col text-center">
			<div class="block-27">
				<ul>
					<li><a href="#">&lt;</a></li>
					<li class="active"><span>1</span></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">&gt;</a></li>
				</ul>
			</div>
		</div>
	</div> -->
	</div>
</section>

<%@ include file="../includes/footer.jsp"%>