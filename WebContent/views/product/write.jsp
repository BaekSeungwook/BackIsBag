<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<script src="${path}/js/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<SCRIPT type="text/javascript">
$(function(){
	$("#cancleBtn").click(function(){
		history.back();
	})
}) 	
</SCRIPT>


</HEAD>
<BODY>
<%@ include file="../../top.jsp" %>
<form name="writeForm" method="post" action="../../product?command=productinsert" 
  onSubmit='return checkValid()' enctype="multipart/form-data" style="margin-top: 100px;">

<table align="center" cellpadding="5" cellspacing="2" width="600" border="1" >
  
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="black">
            <p align="center"><font color="white" size="3"><b>상품등록</b></font></p>
        </td>
    </tr>
    <tr>
        <th width="150" height="20" >
            <p align="right"><b><span style="font-size:12pt;">상품이름</span></b></p>
        </th>
        <td width="450" height="20"><b><span style="font-size:12pt;">
		<input type=text name="productName" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:12pt;">상품설명</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:12pt;">
		<input type=text name="description" size="30" style="height: 100px"></span></b></td>
    </tr>

    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:12pt;">브랜드</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:12pt;">
		<input type=text name="brandName" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:12pt;">상품가격</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:12pt;">
		<input type=text name="price" size="30"></span></b></td>
    </tr>
    
     <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:12pt;">첨부파일</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><span style="font-size:9pt;">
        		 <input type="file" name="file" maxlength="60" size="40">
        	   </span></b>
        </td>
    </tr>
    
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;"><input type=submit value=등록하기> 
        <input type=reset value=초기화>
        <input type="button" value="취소" id="cancleBtn"></span></b></td>
    </tr>
</table>

</form>

<hr>

</BODY>