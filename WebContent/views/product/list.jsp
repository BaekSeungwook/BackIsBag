<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Karma">
<link
	href="https://fonts.googleapis.com/css?family=Pacifico&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat&display=swap"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style>

/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}

.carousel {
	width: 80%;
	margin: 0 auto;
}

.carousel-inner img {
	width: 100%; /* Set width to 100% */
	margin: auto;
	min-height: 200px;
}

.carousel-control.right, .carousel-control.left {
	background-image: none !important;
}

/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
	}
}

/* .item>img{width: 1000px; height: 800px;margin: auto;}
#myCarousel{width:1000px;height: 800px} */
#proName {
	text-decoration: none;
	font-weight: bold;
	color: red;
	font-family: "Montserrat"
}

.data:hover {
	background: #f2d9d9;
	cursor: pointer;
}

ul li {
	width: 25%;
	float: left;
	list-style: none;
}

ol li {
	color: black;
}

img {
	height: 200px;
	width: 200px;
	border-radius: 48px;
}

strong {
	text-decoration: none;
	font-size: 40px;
	font-family: "Montserrat";
}

.discount {
	font-style: oblique;
	color: grey !important;
	font-family: "Permanent Marker", cursive;
	font-weight: normal;
	letter-spacing: 1px;
	text-align: right;
	text-decoration: line-through;
}

a {
	text-decoration: none !important;
}

.product-name {
	color: white;
	font-family: "Permanent Marker", cursive;
	font-weight: normal;
	letter-spacing: 1px;
	text-align: right;
}

.product-price {
	font-family: "Permanent Marker", cursive;
	font-weight: normal;
	letter-spacing: 1px;
	text-align: right;
}

.h1, .h2, .h3, h1, h2, h3 {
	margin-top: 0px !important;
	margin-bottom: inherit;
}

.best-item {
	font-family: "Permanent Marker", cursive;
	font-weight: normal;
	letter-spacing: 1px;
	text-align: center;
	font-size: 50px;
	margin-bottom: 30px;
}

.bag-name {
	font-family: "Montserrat";
	color: #4d4d4d;
	font-weight: lighter;
	font-size: 20px!important;
    margin-top: 10px!important;
}

.pagination>li {
	display: inline-block;
	width: auto;
	margin: 3px;
}
</style>

<script type="text/javascript">
	$(function() {
		$("#searchBtn").click(
				function() {
					if ($("[name=keyField]").val() == "0") {
						alert("검색필드를 선택해주세요.");
						return;
					}

					if ($("[name=keyWord]").val() == "") {
						alert("검색단어가 없습니다.");
						location.href = "product?command=productlist";
						$("[name=keyWord]").focus();
						return;
					}
					location.href = "product?command=productbysearch"
							+ "&keyField=" + $("select[name=keyField]").val()
							+ "&keyWord=" + $("input[name=keyWord]").val();
				});
	});
</script>
<title>BackIsBack: Choose your product</title>
</head>

<body>
	<c:set var="path" value="${pageContext.request.contextPath}"
		scope="application" />
	<%@ include file="../../top.jsp"%>



	<div id="myCarousel" class="carousel slide" data-ride="carousel"
		style="margin-top: 50px;">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="${path}/views/product/listImage/큰가방1.png" alt="Image">
				<div class="carousel-caption">
					<h1 class="product-name">MoneyBag Brown</h1>
					<h3 class="discount">69,000</h3>
					<h1 class="product-price">49,000</h1>
				</div>
			</div>

			<div class="item">
				<img src="${path}/views/product/listImage/큰가방2.png" alt="Image">
				<div class="carousel-caption">
					<h1 class="product-name">RIPSTOP CORDURA Bag</h1>
					<h3 class="discount">85,000</h3>
					<h1 class="product-price">67,000</h1>
				</div>
			</div>

			<div class="item">
				<img src="${path}/views/product/listImage/큰가방3.png" alt="Image">
				<div class="carousel-caption">
					<h1 class="product-name">6 Pocket 3 Way Bag_Wax</h1>
					<h3 class="discount">105,000</h3>
					<h1 class="product-price">7,800</h1>
				</div>
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>

	<hr>
	<div class="container text-center">
		<div class="best-item">Best Item</div>
		<div class="row">
			<div class="col-sm-4">
				<img src="${path}/views/product/listImage/아쿠르브 크로스백.jpg"
					class="img-responsive" style="width: 100%" alt="Image">
				<h3 class="bag-name">
					acourve crossbag <span class="badge badge-danger">New!</span>
				</h3>
			</div>
			<div class="col-sm-4">
				<img src="${path}/views/product/listImage/아메카지BAAN brownbag.jpg"
					class="img-responsive" style="width: 100%" alt="Image">
				<h3 class="bag-name">amekajiBAAN brownbag</h3>
			</div>
			<div class="col-sm-4">
				<img src="${path}/views/product/listImage/몬쓰 에코백.jpg"
					class="img-responsive" style="width: 100%" alt="Image">
				<h3 class="bag-name">
					month echobag <span class="badge badge-danger">New!</span>
				</h3>
			</div>

		</div>
	</div>
	<br>
	<hr>
	<table align="center" border="0" class="w3-main w3-content w3-padding">
		<div style="margin-right: 30px; margin-bottom: 10px">
			<div align="right">
				<button type="button" class="btn btn-info">
					<a href="views/product/write.jsp" style="font-size:large; color: white">상품 등록</a>
				</button>
			</div>

			<div align="right" style="padding: 10px 0px;">
				<select name="keyField"
					style="height: 32px; display: inline-block; vertical-align: middle;">
					<option value="0">--선택--</option>
					<option value="searchName">상품이름</option>
					<option value="searchBrand">상품브랜드</option>
				</select> <input type="text" name="keyWord"
					style="height: 32px; display: inline-block; vertical-align: middle;">
				<button type="button" class="btn btn-default" id="searchBtn">
					<i class="glyphicon glyphicon-search"></i>
				</button>
			</div>
		</div>

		<ul>
			<c:choose>
				<c:when test="${empty requestScope.list}">
					<tr>
						<td>
							<p align="center">
								<b><span style="font-size: 12pt;">등록된 상품이 없습니다.</span></b>
							</p>
						</td>
					</tr>
				</c:when>
				<c:otherwise>

					<c:forEach items="${requestScope.list}" var="proDto">
						<li><a
							href="product?command=productread&proCode=${proDto.proCode}">
								<div class="data" style="width: 220px; border-radius: 50px;"
									align="center">
									<div>
										<img src="${path}/views/product/save/${proDto.fileName}">
									</div>
									<h3>${proDto.proName}</h3>
									<br>
									<div style="font-weight: bold">${proDto.proBrand}</div>
									<br> <br>
									<div style="font-weight: bold; color: black">${proDto.proPrice}원</div>
									<br>
								</div>
						</a></li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</ul>


		<div class="pagenum" style="text-align: center;">
			<ul class="pagination" style="text-align: right;">
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</div>

	</table>



</body>
</html>