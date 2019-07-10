<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>BackIsBag: Watch Out Your Bag</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BackIs</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Literata&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

		
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

<style>

.carousel-caption {
	top: 10px;
	right: 50px !important; 
	margin-top : 20px;
	padding-bottom: 20px;
	color: #fff;
	text-align: right !important;
	font-family: "Literata", sans-serif;
	font-size: 60px;
	height:100px;
	text-shadow: none;
}	

img{
	filter:brightness(70%);	
}

#carouselMain > div > div.carousel-item > div > a {font-size:40px; margin-top:10px; position:relative; opacity:0.8;}


</style>

</head>
<body>
	<%@include file="top.jsp"%>

	<div id="carouselMain" class="carousel slide" data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="w3images/main.jpg" class="d-block w-100">
				<div class="carousel-caption d-none d-md-block">get whatever
					you want.<br>
					<a class="btn btn-dark btn-lg" href="product" role="button">shop now</a></div>
					
			</div>
			<div class="carousel-item">
				<img src="w3images/main2.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">others might not care but we do.
				<br><a class="btn btn-dark btn-lg" href="memberLoginForm.jsp" role="button">join now</a></div>
			</div>
			<div class="carousel-item">
				<img src="w3images/main3.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">no worry. we got your back
				<br><a class="btn btn-dark btn-lg" href="product" role="button">shop now</a></div>
			</div>
			</div>
			
		<a class="carousel-control-prev" href="#carouselMain" role="button"
			data-slide="prev"> <span class="carousel-control-prev-icon"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselMain" role="button"
			data-slide="next"> <span class="carousel-control-next-icon"
			aria-hidden="true"></span> <span class="sr-only">Next</span>
		</a>
	</div>
	<%@include file="footer.jsp"%>


</body>
</html>