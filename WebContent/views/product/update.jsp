<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<script src="${path}/js/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function checkValid() {
    var f = window.document.writeForm;
		
	if ( f.model_num.value == "") {
		alert( "모델이름을 입력해 주세요." );
	    f.model_num.focus();
		return false;
    }
	if ( f.model_name.value == "" ) {
		alert( "상품이름을 입력해 주세요." );
		f.model_name.focus();
		return false;
	}
	if ( f.price.value == "" ) {
		alert( "상품 설명을 입력해 주세요." );
		f.price.focus();
		return false;
	}
	if ( f.description.value == "" ) {
        alert( "ìí ì¤ëªì ìë ¥í´ ì£¼ì¸ì." );
        f.description.focus();
        return false;
    }
	if ( f.password.value == "" ) {
        alert( "ë¹ë°ë²í¸ë¥¼ ìë ¥í´ ì£¼ì¸ì" );
        f.password.focus();
        return false;
    }
	
    return true;
}

$(function(){
	$("#cancleBtn").click(function(){
		history.back();
	})
})
</SCRIPT>
</HEAD>
<BODY>
<%@ include file="../../top.jsp" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<form name="updateForm" method="post" action="${path}/product?command=productupdate" 
		onSubmit="return checkValid()" enctype="multipart/form-data" style="margin-top: 150px;">
    <input type="hidden" name="command" value="productupdate" >
    <input type='hidden' name='proCode' value="${productDTO.proCode}">
	<table align="center" cellpadding="5" cellspacing="2" width="600" border="1" >
  
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="black">
            <p align="center"><font color="white" size="3"><b>상품수정</b></font></p>
        </td>
    </tr>
    <tr>
        <th width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">상품이름</span></b></p>
        </th>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="productName" size="30" value="${productDTO.proName}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">상품설명</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="description" size="30" value="${productDTO.proDesc}"></span></b></td>
    </tr>
    <tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">브랜드</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="brandName" size="30" value="${productDTO.proBrand}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">상품가격</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="price" size="30" value="${productDTO.proPrice}"></span></b></td>
    </tr>
    
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">원본이미지</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<img src="${path}/views/product/save/${productDTO.fileName}" width="200" height"180"></span></b></td>
    </tr>
    
    
    
     <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">수정이미지</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><span style="font-size:9pt;">
        		 <input type="file" name="file" maxlength="60" size="40">
        	   </span></b>
        </td>
        
    </tr>
    
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;">
        <input type=submit value=수정하기> 
        <input type=reset value=초기화>
        <input type="button" value="취소" id="cancleBtn"></a></span></b></td>
    </tr>
</table>

</form>

<hr>
<div align=right><span style="font-size:12pt;">&lt;<a href="${path}/product?command=productlist">상품리스트로</a>&gt;</span></div>

</BODY>