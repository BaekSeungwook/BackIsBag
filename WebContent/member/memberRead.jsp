<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<link rel="stylesheet" href="css/style.css">
<style>
   /* table{border:5px solid black}
    tr,th,td{padding:5px; border: 1px solid yellow ; text-align: center } */
    .login-wrap{
   width:100%;
   margin:auto;
   max-width:525px;
   min-height:400px;
   position:relative;
   background:/*(https://raw.githubusercontent.com/khadkamhn/day-01-login-form/master/img/bg.jpg)*/ no-repeat center;
   box-shadow:0 12px 15px 0 rgba(0,0,0,.24),0 17px 50px 0 rgba(0,0,0,.19);
}
</style>
<script src="${path}/js/jquery-3.4.1.min.js"></script>
<!-- <script src="..//js/jquery-3.4.1.min.js"></script> -->
<script type="text/javascript">
/* function sendUpdate(){ //수정폼
   document.requestForm.command.value ="updateForm";
   document.requestForm.submit();
    if(val == "0"){
        location.href="member?command=updateForm&memberId=${dto.memberId}";
   } 
} */
/* function sendDelete(){//삭제
   if(document.requestForm.password.value==""){
      alert("삭제를 위한 비밀번호를 입력해주세요.");
      document.requestForm.password.focus();
      return;
   if(value == "1"){
        location.href="member?command=delete&memberId=${dto.memberId}";
   } 
}
   document.requestForm.command.value ="delete";
   document.requestForm.submit();
} */
$(function(){
      $("deleteBtn").click(function(){
         confirm("정말로 삭제하시겠습니까?");
      });
   })
</script>
</head>
<body>
<%@ include file="../top.jsp" %>
<div class="login-wrap">
<table align="center" cellpadding="5" cellspacing="2" width="500" border='1' style="text-align: center; margin-top: 40px">
    <tr>
        <td width="1220" height="20" colspan="4" bgcolor="black">
            <p align="center"><font color="white" size="3"><b>
             회원 상세정보</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="right"><b><span style="font-size:9pt;">아이디</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
           <span style="font-size:9pt;"><b>${dto.memberId}</b></span>
        </td>
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="right"><b><span style="font-size:9pt;">이름</span></b></p>
        </td>
        <td width="450" height="20">
           <span style="font-size:9pt;"><b>${dto.memberName}</b></span>
        </td>
       </tr>
       <tr>
        <td width="100" height="20" >
         <p align="right"><b><span style="font-size:9pt;">나이</span></b></p>
      </td>
        <td width="450" height="20">
         <b><span style="font-size:9pt;"></span>${dto.memberAge}</b>
      </td>
    </tr>
    <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">이메일</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
           <span style="font-size:9pt;"><b>${dto.memberEmail}</b></span>
        </td>
    </tr>
    <tr>
      <td width="100" height="20" valign="top">
            <p align="right"><b><span style="font-size:9pt;">휴대폰 번호</span></b></p>
        </td>
      <!-- 브라우저에 글 내용을 뿌려줄 때는 개행문자(\n)가 <br>태그로 변환된 문자열을 보여줘야 한다. -->
        <td width="100" height="20" colspan="3">
        <span style="font-size:9pt;"><b>${dto.memberCellphone}</b></span></td>
    </tr>
    
    <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">주소</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
           <span style="font-size:9pt;"><b>${dto.memberAddr}</b></span>
        </td>
    </tr>
    
    <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">가입날짜</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
           <span style="font-size:9pt;"><b>${dto.memberDate}</b></span>
        </td>
    </tr>
    
    
        
  <form name="requestForm" method="post" action="${path}/member">
    
    
    <tr>
        <td height="20" colspan="4" align="center" valign="middle">
         <!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
            <input type=hidden name="memberId" value="${dto.memberId}">
            <input type=hidden name="command" value="delete">
             <!-- <input type=button value="수정하기" onClick="sendUpdate()"> 
             <input type=button value="삭제하기" onClick="sendDelete()"> --> 
             <button><a href="product?command=updateForm&memberId=${dto.memberId }">수정하기</a>
             </button>
            <%-- <button id="deleteBtn" >
            <a href="member?command=delete&memberId=${dto.memberId }">삭제하기</a></button> --%>
            <a href="product?command=delete"><input type="submit" value="삭제하기"></a>
    </form>
         
      </td>
    </tr>
</table>
</div>
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="${path}product?command=select">회원목록으로 돌아가기</a>&gt;</span></div>
</body>
</html>