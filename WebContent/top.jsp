<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="js/jquery-3.4.1.min.js"></script>
<!-- 폰트스타일 -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
<link href="https://fonts.googleapis.com/css?family=Pacifico&display=swap" rel="stylesheet">
<!--  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>




<script type="text/javascript">
//Script to open and close sidebar
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
}
 
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
}
</script>

<style>
header{font-family: "Karma", sans-serif}
#mySidebar{
	background-color: black;
	color: white !important;
	min-width: 200px;
	width: 20%;
	display:none;
	z-index: 2;
}
#myTopbar{
	background-color: black;
	color: white;
	background-image: url("topBack.png");
	background-repeat: no-repeat;
	background-size: cover;
	background-position: bottom;
	background-color: rgba(0,0,0,0.5);
	text-shadow: 2px 3px 9px #424242;
	position:fixed;
}

.w3-bar-block .w3-bar-item{text-decoration: none; font-size: 15px;}

.w3-white, .w3-hover-white:hover {background-color:unset !important; color:#fff !important; }


strong{font-size: 70px; font-family: "Pacifico", sans-serif; font-weight: normal; text-shadow: 2px 3px 5px #424242;}
</style>
<title>BackIsBag : watch out your back</title>
</head>

<body>

<!-- Sidebar (hidden by default) -->
<nav class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left" id="mySidebar">
  <!-- <a href="javascript:void(0)">a태그의 링크기능 무효화</a> -->
  <a href="javascript:void(0)" onclick="w3_close()"
  class="w3-bar-item w3-button">Close Menu</a>
  <a href="login.html" onclick="w3_close()" class="w3-bar-item w3-button">login</a>
  <a href="product.html" onclick="w3_close()" class="w3-bar-item w3-button">product</a>
  <a href="join.html" onclick="w3_close()" class="w3-bar-item w3-button">join</a>
</nav>

<!-- Top menu -->
<header class="w3-top" id="myTopbar">
  <div class="w3-white w3-xlarge" style="max-width:1200px; margin:auto">
    <div class="w3-button w3-padding-16 w3-left" onclick="w3_open()" style="color: white;">☰</div>
    <div id="middle">
    <div class="w3-center w3-padding-16"><strong>BackIsBag</strong></div>
    </div>
  </div>
</header>

</body>
</html>