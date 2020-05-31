<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="includes/header.jsp"%>

<section id="home-section" class="hero">
	<div class="home-slider owl-carousel">
		<div class="slider-item"
			style="background-image: url(/resources/images/bg1.jpg);"></div>
		<div class="slider-item"
			style="background-image: url(/resources/images/bg2.jpg);"></div>
		<div class="slider-item"
			style="background-image: url(/resources/images/bg3.jpg);"></div>
	</div>
</section>

<section class="ftco-section-title">
	<div class="container">

		<div class="col-md-12 heading-section text-center ftco-animate">
			<h2 class="mb-4">할인 & 이벤트</h2>
		</div>
	</div>

</section>

<section class="ftco-section ftco-category ftco-no-pt ftco-no-pb">
	<div class="container">

		<div class="row">
			<div class="col-md-8">
				<div class="row">

					<div class="col-md-6">
						<div
							class="category-wrap ftco-animate img mb-4 d-flex align-items-end"
							style="background-image: url(/resources/images/event1.jpg);">
							<div class="text px-3 py-1">
								<h2 class="mb-0">
									<a href="#">이벤트1</a>
								</h2>
							</div>
						</div>

					</div>
					<div class="col-md-6">
						<div
							class="category-wrap ftco-animate img mb-4 d-flex align-items-end"
							style="background-image: url(/resources/images/event1.jpg);">
							<div class="text px-3 py-1">
								<h2 class="mb-0">
									<a href="#">이벤트2</a>
								</h2>
							</div>
						</div>

					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div
					class="category-wrap ftco-animate img mb-4 d-flex align-items-end"
					style="background-image: url(/resources/images/event1.jpg);">
					<div class="text px-3 py-1">
						<h2 class="mb-0">
							<a href="#">이벤트3</a>
						</h2>
					</div>
				</div>

			</div>
		</div>
	</div>
</section>

<section class="ftco-section-title">
	<div class="container">
		<div class="col-md-12 heading-section text-center ftco-animate">
			<h2 class="mb-4">최신 상품</h2>
		</div>

	</div>
</section>
<section class="ftco-section ftco-no-pt ftco-no-pb md-4">
	<div class="container">
		<div class="row">
			<c:if test="${empty items }">
				<p class="lead">등록된 상품이 없습니다.</p>
			</c:if>
			<c:forEach items="${items}" var="item">
				<div class="col-md-6 col-lg-3 ftco-animate">
					<div class="product">
						<a href="/shop/item?ino=<c:out value='${item.ino}'/>" class="img-prod"><img class="img-fluid"
							src="<c:url value="${item.itemThumbImg}"/>" alt="No Image"></a>
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
	</div>
	
</section>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">권한 없음</h4>
				</div>
				<div class="modal-body">관리자 페이지에 접근할 수 없습니다.</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
	$(document).ready(function() {
		var deny = '<c:out value="${deny}"/>';
		checkModal(deny);

		function checkModal(deny) {
			if (deny === '') {
				return;
			} else {
				$("#myModal").modal("show");
			}

		}
	});
</script>

<%@ include file="includes/footer.jsp"%>
