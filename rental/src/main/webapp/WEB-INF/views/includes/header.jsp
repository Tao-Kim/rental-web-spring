<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>SK먜직 렌탈</title>
<meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="/resources/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/animate.css">

<link rel="stylesheet" href="/resources/css/owl.carousel.min.css">
<link rel="stylesheet" href="/resources/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/resources/css/magnific-popup.css">

<link rel="stylesheet" href="/resources/css/aos.css">

<link rel="stylesheet" href="/resources/css/ionicons.min.css">

<link rel="stylesheet" href="/resources/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="/resources/css/jquery.timepicker.css">


<link rel="stylesheet" href="/resources/css/flaticon.css">
<link rel="stylesheet" href="/resources/css/icomoon.css">
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body class="goto-here">
	<script src="/resources/js/jquery.min.js"></script>
	<!-- 상단메뉴
		div class="py-1 bg-primary">
    	<div class="container">
    		<div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
	    		<div class="col-lg-12 d-block">
		    		<div class="row d-flex">
		    			<div class="col-md pr-4 d-flex topper align-items-center">
					    	<div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-phone2"></span></div>
						    <span class="text">+ 1235 2355 98</span>
					    </div>
					    <div class="col-md pr-4 d-flex topper align-items-center">
					    	<div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-paper-plane"></span></div>
						    <span class="text">youremail@email.com</span>
					    </div>
					    <div class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right">
						    <span class="text">3-5 Business days delivery &amp; Free Returns</span>
					    </div>
				    </div>
			    </div>
		    </div>
		  </div>
    </div>-->
	<nav
		class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
		id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="/">SK <span id="navbar-brand-magic">매직</span></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#ftco-nav" aria-controls="ftco-nav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>

			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="/shop/list?category1=정수기"
						aria-haspopup="true" aria-expanded="false">정수기</a>

						<div class="dropdown-menu">
							<a class="dropdown-item"
								href="/shop/list?category1=정수기&category2=일반정수기">일반정수기</a> <a
								class="dropdown-item"
								href="/shop/list?category1=정수기&category2=업소용정수기">업소용정수기</a>
						</div></li>
					<li class="nav-item"><a href="/shop/list?category1=공기청정기"
						class="nav-link">공기청정기</a></li>
					<li class="nav-item"><a href="/shop/list?category1=비데"
						class="nav-link">비데</a></li>
					<li class="nav-item"><a href="/shop/list?category1=안마의자"
						class="nav-link">안마의자</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle"
						href="/shop/list?category1=주방가전/생활가전" aria-haspopup="true"
						aria-expanded="false">주방가전/생활가전</a>
						<div class="dropdown-menu">
							<a class="dropdown-item"
								href="/shop/list?category1=주방가전/생활가전&category2=가스레인지">가스레인지</a>
							<a class="dropdown-item"
								href="/shop/list?category1=주방가전/생활가전&category2=전기레인지">전기레인지</a>
							<a class="dropdown-item"
								href="/shop/list?category1=주방가전/생활가전&category2=의류건조기">의류건조기</a>
							<a class="dropdown-item"
								href="/shop/list?category1=주방가전/생활가전&category2=식기섹척기">식기세척기</a>
							<a class="dropdown-item"
								href="/shop/list?category1=주방가전/생활가전&category2=제빙기">제빙기</a>
						</div>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="dropdown04"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><del>할인/이벤트</del></a>
						<div class="dropdown-menu" aria-labelledby="dropdown04">
							<a class="dropdown-item" href="#">패키지할인</a> <a
								class="dropdown-item" href="#">제휴카드할인</a> <a
								class="dropdown-item" href="#">사은품</a> <a class="dropdown-item"
								href="#">이벤트</a>
						</div></li>
					<li class="nav-item"><a href="#" class="nav-link"><del>상담신청</del></a></li>

				</ul>

			</div>
			<c:choose>
				<c:when test="${empty admin}">
					<span id="nav-admin"><a href="/login" id="nav-admin-link">관리자
							로그인</a></span>
				</c:when>
				<c:when test="${not empty admin}">
					<span id="nav-admin"><a href="/logout" id="nav-admin-link">로그아웃</a></span>
				</c:when>
			</c:choose>


		</div>
	</nav>