<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${path}/css/style.css">
<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<style type="text/css">
.data:hover {
	background: #eee; cursor: pointer;
}
.image{
	height: 250px;
	width: 100%;
}
.imagenone{
	height: 250px;
	width: 100%;
}
li{
	width: 25%;
	float: left;
	list-style: none;
}
</style>
<title>Insert title here</title>
</head>

<body>
<%@ include file="../../top.jsp" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<table align="center" border="0" class="w3-main w3-content w3-padding" style="margin-top: 150px;">
<%--<caption>상품 LIST</caption>
  	<colgroup>
		<col width="15%"/>
		<col width="30%"/>
		<col width="16%"/>
		<col width="16%"/>
		<col width="7%"/>
		<col width="7%"/>
		<col width="7%"/>
	</colgroup>
	<tr>
        <th bgcolor="black">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">상품이미지</span></b></font></p>
        </th>
        <th bgcolor="black">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">상품코드</span></b></font></p>
        </th>
        <th bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">상품이름</span></b></font></p>
        </th>
        <th bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">상품설명</span></b></font></p>
        </th>
        <th bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">등록일</span></b></font></p>
        </th>
        
        <th bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">가격</span></b></font></p>
        </th>
        <th bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">브랜드</span></b></font></p>
        </th>
    </tr>
    
    <c:choose>
    <c:when test="${empty requestScope.list}">
	   <tr>
        <td colspan="5">
            <p align="center"><b><span style="font-size:9pt;">등록된 상품이 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.list}" var="proDto">
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${proDto.proCode}</span></p>
		        </td>
		        
		        <td bgcolor="">
	            <p align="center"><span style="font-size:9pt;">
	            <img src="${path}/views/product/save/${proDto.fileName}" style="height: 150px; width: 200px;"></span></p>
		        </td>
		        
		        <td bgcolor="">
					<p><span style="font-size:9pt;">
					<a href="product?command=productread&proCode=${proDto.proCode}">
					  ${proDto.proName}
					</a>
					</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${proDto.proDesc}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${proDto.proWriteDate}</span></p>
		        </td>
		         
		         
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${proDto.proBrand}</span></p>
		        </td>
		        
	            <td bgcolor="">
	            <p align="center"><span style="font-size:9pt;">
	            ${proDto.proPrice}</span></p>
		        </td>
		    </tr>
    </c:forEach>
	</c:otherwise>
    </c:choose> --%>

<ul>
<c:forEach items="${requestScope.list}" var="proDto">
<li>
     <div class="data" style="width: 200px;" align="center">
       <div>
       <img src="${path}/views/product/save/${proDto.fileName}" style="height: 200px; width: 200px;">
       </div>
       <div  style="font-weight: bold; color: red">&#9830; <a href="product?command=productread&proCode=${proDto.proCode}">
	  ${proDto.proName}
	</a> </div><br>
       <div style="font-weight: bold">&#9830; ${proDto.proBrand}</div><br><br>
       <div style="font-weight: bold">&#9830; ${proDto.proPrice}원</div><br>
     </div>
     </li>
</c:forEach>	
</ul>
	
</table>
<div align=right>
<span style="font-size:9pt;">&lt;<a href="views/product/write.jsp">글쓰기</a>&gt;</span></div>

</body>
</html>