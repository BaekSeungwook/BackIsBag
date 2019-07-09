<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${path}/css/style.css">

<title>Insert title here</title>
</head>

<body>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<table align="center" border="0" class="w3-main w3-content w3-padding">
<caption>상품 상세보기</caption>
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
            <font color="white"><b><span style="font-size:9pt;">상품코드</span></b></font></p>
        </th>
        <th bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">상품이름</span></b></font></p>
        </th>
        <th bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">상품설명</span></b></font></p>
        </th>
        
        
        <th bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">브랜드</span></b></font></p>
        </th>
        
        <th bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">가격</span></b></font></p>
        </th>
        <th bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">등록일</span></b></font></p>
        </th>
        
    </tr>
    
    <c:choose>
    <c:when test="${empty requestScope.productDTO}">
	   <tr>
        <td colspan="5">
            <p align="center"><b><span style="font-size:9pt;">등록된 상품이 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${productDTO.proCode}</span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:9pt;">
					<a href="#">
					  ${productDTO.proName}
					</a>
					</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${productDTO.proDesc}</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${productDTO.proBrand}</span></p>
		        </td>
		        
	            <td bgcolor="">
	            <p align="center"><span style="font-size:9pt;">
	            ${productDTO.proPrice}</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${productDTO.proWriteDate}</span></p>
		        </td>
		        
		    </tr>
	</c:otherwise>
    </c:choose>
</table>
<hr>
<div align=right>
<span style="font-size:9pt;">&lt;<a href="#">글수정</a>&gt;</span></div>

</body>
</html>