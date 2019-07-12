<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<link href="https://fonts.googleapis.com/css?family=Pacifico&display=swap" rel="stylesheet">
<link rel="stylesheet" href="${path}/css/style.css">
<script src="${path}/js/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
p{font-family: "Karma", sans-serif}
th{background-color: black; color: white;}
select {
	size: 15px; width: 150px
}
</style>

<script type="text/javascript">
$(function(){
	$("#deleteBtn").click(function(){
		if(confirm("정말로 삭제하시겠습니까?")){
			location.href="product?command=productdelete&proCode=${productDTO.proCode}";
		}
	});
	$("#cartBtn").click(function(){
		if(confirm("장바구니에 담으시겠습니까?")){
			location.href="views/product/cart.jsp";
		}
	});
})
</script>
</head>

<body>
<%@ include file="../../top.jsp" %>

<table align="center" border="0" class="w3-main w3-content w3-padding" style="margin-top: 80px;">
<!-- <table align="center" cellpadding="5" cellspacing="2" width="600" border="1" > -->
  
    
    <c:choose>
    <c:when test="${empty requestScope.productDTO}">
	   <tr>
         <p align="center"><b><span style="font-size:9pt;">등록된 상품이 없습니다.</span></b></p>     
      </tr>
    </c:when>
    <c:otherwise>
    <tr><td colspan="4">
	<div class="data" align="center">
       <div align="center">
       <img src="${path}/views/product/save/${productDTO.fileName}" style="height: 500px; width: 600px;">
       </div>
       <div  style="font-weight: bold; color: red">
	  		<h1>${productDTO.proName}</h1>
		 </a> 
	   </div><br>
       <div style="font-weight: bold">${productDTO.proBrand}</div><br>
       <div style="font-weight: bold">${productDTO.proDesc}</div><br>
       <div style="font-weight: bold"><h3>${productDTO.proPrice}원</h3></div><br>
       
     </div>
     <hr color="black">
     <table style="width: 100%; font-size: large;">
     	 <tr>
     	 	<th width="25%">수량선택</th>
     	 	<th width="25%">색상</th>
     	 	<th width="25%">배송비</th>
     	 	<th>총결제금액</th>
     	 </tr>
	     <tr>
	     	<td>
		      <input type="text" name="keyField" size="10">
			</td>
	     	<td>
		      <select name="keyField" style="height: 31px">
			    <option value="0">--선택--</option>
			    <option value="M">black</option>
			    <option value="L">navy</option>
			  </select>
			</td>
	     	<td>
		      무료
			</td>
	     	<td>
		      90000원
			</td>
			<td></td>
		 </tr>
		 <tr><td colspan="4">
		 <div align="right" style="margin: 60px 0 60px 0">
			<button type="button" class="btn btn-info" style="font-size: large;">
				구매하기
			</button>
			<button type="button" class="btn btn-success" id="cartBtn" style="font-size: large;">
				장바구니
			</button>
		 </div>
		 </td></tr>
	</table>
	 
     
       <div style="color: gray" align="right">등록일 : ${productDTO.proWriteDate}</div><br>
     </td></tr>
	</c:otherwise>
    </c:choose>
	
<%-- 	<form id="requestForm" method=post action="${path}/product"> --%>
		<tr>
			<td height="20" colspan="4" align="right" valign="middle">
				<%-- <input type=hidden id="proCode" name="proCode" value="${productDTO.proCode}"> 
				<input type=hidden id="command" name="command" value="">  --%>
				<button><a href="product?command=productupdateForm&proCode=${productDTO.proCode}">
				수정하기</a></button>
				<button type="button" id="deleteBtn">
				삭제하기</button>
				<button id="listBtn"><a href="${path}/product?command=productlist">
				상품목록</a></button>
			</td>
		</tr>
<!--  	</form>  -->


	</table>
	<hr>

</body>
</html>