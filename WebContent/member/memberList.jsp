<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "htt7://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
  table{width:100%; border:5px solid black}
  th,td{padding:5px; border: 1px solid pink ; text-align: center }
  a{text-decoration: none}
 </style>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script>
	$(function () {
		/* alert("jQeury Start"); */
		//삭제 이벤트 등록
		$("input[value=삭제]").click(function () {
			//현재 버튼을 기준으로 id를 찾기
			if(confirm("정말 삭제하시겠습니까?")) {
			var id = $(this).parent().parent().find("td:first").next().text();  //this(input) -> td -> tr -> 첫번째 td -> 옆
			//var id = ??;
			location.href="delete?id=" + id;
			//location.href="delete?id=id"; //서블릿이동
			}
		})
		
		$("input[value=검색]").click(function () {
			if($("[name=keyField").val()=="0") {
				alert("검색필드를 선택해주세요");
				return ;
			}
			if($("[name=keyWord]").val()=="") {
				alert("검색단어를 입력해주세요");
				$("[name=keyWord]").focus();
				return;
			}
			/* $("[name=search]").submit(); //form 전송 */
			location.href="member?command=selectBySearch"    //selectBySearch
					+ "&keyField="+$("select[name=keyField]").val()
					+ "&keyWord="+$("input[name=keyWord]").val();
		});
	})

</script>
</head>

<body>
<%-- \${requestScope.list} : ${requestScope.list} --%>  <!-- DB 갔다왔는지 테스트 -->
<%@ include file="../top.jsp" %>

<center>
 <h1>[ 회원 정보 LIST ]</h1>
<table cellspacing="0">
  <tr>
    <th colspan="10" style="text-align:right">
      <!-- <a href="memberForm.jsp">[ 회원가입 ]</a> -->&nbsp;&nbsp;&nbsp;
      <a href="member?command=select">[ 새로고침 ]</a>&nbsp;&nbsp;&nbsp;
    </th>
  </tr>
  <tr bgColor="green">

    <th>번호</th>
    <th>아이디</th>
    <th>이름</th>
    <!-- <th>나이</th> -->
    <!-- <th>이메일</th> -->
    <!-- <th>휴대폰번호</th> -->
    <th>주소</th>
    <!-- <th>가입일</th> -->
    <th>회원등급</th>
    <!-- <th>삭제</th> -->
  </tr>
  <!-- db 정보 출력하기 -->
	<c:forEach items="${list}" var="dto"  varStatus="state"> <!-- var 값은 직접 지정~ -->
	<tr>
		<td>${state.count }</td>
		<td><a href="product?command=read&memberId=${dto.memberId }">${dto.memberId }</a></td>
		<td>${dto.memberName }</td>
		<%-- <td>${dto.memberAge }</td> --%>
		<%-- <td>${dto.memberEmail }</td> --%>
		<%-- <td>${dto.memberCellphone }</td> --%>
		<td>${dto.memberAddr }</td>
		<%-- <td>${dto.memberDate }</td> --%>
		<td>${dto.memberGrade }</td>
		<!-- <td><input type="button" value="삭제" ></td> -->
 	</tr>
	</c:forEach>
</table>
<p>

<form name="search" action="selectBySearch" method="post">
 <select name="keyField">
   <option value="0">--선택--</option>
   <option value="memberId">아이디</option>
   <option value="memberName">이름</option>
   <option value="memberAddr">주소</option>
 </select>
 
<input type="text" name="keyWord"/>
<input type="button" value="검색" />  

</form>
</center>
</body>
</html>