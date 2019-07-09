<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
<SCRIPT language=javascript>
function checkValid() {
    var f = window.document.writeForm;
		
	if ( f.model_num.value == "") {
	    alert( "ëª¨ë¸ë²í¸ë¥¼ ìë ¥í´ ì£¼ì¸ì." );
	    f.model_num.focus();
		return false;
    }
	if ( f.model_name.value == "" ) {
		alert( "ëª¨ë¸ì´ë¦ì ìë ¥í´ ì£¼ì¸ì." );
		f.model_name.focus();
		return false;
	}
	if ( f.price.value == "" ) {
		alert( "ê°ê²©ì ìë ¥í´ ì£¼ì¸ì." );
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
</SCRIPT>


</HEAD>
<BODY>

<form name="writeForm" method="post" action="../../product?command=productinsert" 
  onSubmit='return checkValid()' enctype="multipart/form-data">
    <input type="hidden" name="command" value="update" >
    <input type='hidden' name='proCode' value="${productDTO.proCode}">
<table align="center" cellpadding="5" cellspacing="2" width="600" border="1" >
  
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="black">
            <p align="center"><font color="white" size="3"><b>상품등록</b></font></p>
        </td>
    </tr>
    <tr>
        <th width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">상품이름</span></b></p>
        </th>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="productName" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">상품설명</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="description" size="30"></span></b></td>
    </tr>
    <tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">브랜드</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="brandName" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">상품가격</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="price" size="50"></span></b></td>
    </tr>
    
     <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">첨부파일</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><span style="font-size:9pt;">
        		 <input type="file" name="file" maxlength="60" size="40">
        	   </span></b>
        </td>
    </tr>
    
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;"><input type=submit value=수정하기> 
        <input type=reset value=초기화></span></b></td>
    </tr>
</table>

</form>

<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="../../product?command=productlist">상품리스트로</a>&gt;</span></div>

</BODY>