<%@ page info="회원정보 수정" contentType="text/html;charset=UTF-8" %>
<HTML>
<HEAD>
<link rel="stylesheet" href="css/style.css">
<SCRIPT >
function checkValid() {
	var f = window.document.updateForm;
	if ( f.model_name.value == "" ) {
		alert( "모델이름을 입력해 주세요." );
		f.model_name.focus();
		return false;
	}
	if ( f.price.value == "" ) {
		alert( "가격을 입력해 주세요." );
		f.price.focus();
		return false;
	}
	if ( f.description.value == "" ) {
        alert( "상품 설명을 입력해 주세요." );
        f.description.focus();
        return false;
    }
	if ( f.password.value == "" ) {
        alert( "비밀번호를 입력해 주세요" );
        f.password.focus();
        return false;
    }
}
</SCRIPT>
</HEAD>
<BODY>
<form name=updateForm method=post action="member" onSubmit="return checkValid()">
    <input type="hidden" name="command" value="update" >
    <input type='hidden' name='memberId' value="${dto.memberId}">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#00cc00">
            <p align="center"><font color="white" size="3"><b>  회원정보 수정</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">아이디</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="memberId" size="30"
		 value="${dto.memberId}" disabled style="border:none"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">이름</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="memberName" size="30"
		 value="${dto.memberName}" disabled style="border:none"></span></b></td>
    </tr>
    
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">나이</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type="text" name="memberAge" size="30" value="${dto.memberAge}" disabled style="border:none"></span></b></td>
    </tr>
    
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">이메일</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type="text" name="memberEmail" size="30" value="${dto.memberEmail}"></span></b></td>
    </tr>
    
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">휴대폰 번호</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type="text" name="memberCellphone" size="30" value="${dto.memberCellphone}"></span></b></td>
    </tr>
    
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">주소</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type="text" name="memberAddr" size="30" value="${dto.memberAddr}"></span></b></td>
    </tr>

    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">비밀번호</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;"><input type=password name="memberPass" size="12"> 
            (비밀번호가 맞아야 수정이 가능합니다.)</span></b></td>
    </tr>
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;">
		<input type="submit" value="수정하기"> <input type="reset" value="다시쓰기"></span></b></td>
    </tr>
</table>

</form>
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="${path}member">리스트로 돌아가기</a>&gt;</span></div>
</BODY>
</HTML>