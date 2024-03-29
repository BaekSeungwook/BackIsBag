<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
if("${message}"!=""){
    alert("${message}")
}
function login(th) {
   if(th.memberId.value == "" || th.memberPass.value == "") {
      alert("Please fill out all the information");
      return false; //함수빠져나가라.
   }
}

function check(th){//th는 form객체
   if(th.memberId.value == "" || th.memberPass.value == "" || th.memberPass_Check.value=="" || th.memberName.value=="" ||
      th.memberEmail.value=="" || th.memberCellphone.value=="" || th.memberAddr.value=="" ||
      th.memberAge.value==""){
      alert("Please fill out all the information");
      return false; //함수빠져나가라.
   }
  
   if(th.memberPass.value != th.memberPass_Check.value){
      alert("Please check your password.");
      th.memberPass.value="";
      th.memberPass_Check.value="";
      return false; //함수빠져나가라.
   }
   
   if(isNaN(th.memberAge.value)) {
      alert("Please write down your age numerically.");
      th.memberAge.value="";
      return false; //함수빠져나가라.
   }
}
 
</script>

<style>
body{
   margin:0;
   color:#6a6f8c;
   background:#c8c8c8;
   font:600 16px/18px 'Open Sans',sans-serif;
}
*,:after,:before{box-sizing:border-box}
.clearfix:after,.clearfix:before{content:'';display:table}
.clearfix:after{clear:both;display:block}
a{color:inherit;text-decoration:none}

.login-wrap{
   width:100%;
   margin:auto;
   max-width:525px;
   min-height:850px;
   position:relative;
   background:/*(https://raw.githubusercontent.com/khadkamhn/day-01-login-form/master/img/bg.jpg)*/ no-repeat center;
   box-shadow:0 12px 15px 0 rgba(0,0,0,.24),0 17px 50px 0 rgba(0,0,0,.19);
}
.login-html{
   width:100%;
   height:100%;
   position:absolute;
   padding:90px 70px 50px 70px;
   background:rgba(40,57,101,.9);
}
.login-html .sign-in-htm,
.login-html .sign-up-htm{
   top:0;
   left:0;
   right:0;
   bottom:0;
   position:absolute;
   transform:rotateY(180deg);
   backface-visibility:hidden;
   transition:all .4s linear;
}
.login-html .sign-in,
.login-html .sign-up,
.login-form .group .check{
   display:none;
}
.login-html .tab,
.login-form .group .label,
.login-form .group .button{
   text-transform:uppercase;
}
.login-html .tab{
   font-size:22px;
   margin-right:15px;
   padding-bottom:5px;
   margin:0 15px 10px 0;
   display:inline-block;
   border-bottom:2px solid transparent;
}
.login-html .sign-in:checked + .tab,
.login-html .sign-up:checked + .tab{
   color:#fff;
   border-color:#1161ee;
}
.login-form{
   min-height:345px;
   position:relative;
   perspective:1000px;
   transform-style:preserve-3d;
}
.login-form .group{
   margin-bottom:15px;
}
.login-form .group .label,
.login-form .group .input,
.login-form .group .button{
   width:100%;
   color:#fff;
   display:block;
}
.login-form .group .input,
.login-form .group .button{
   border:none;
   padding:15px 20px;
   border-radius:25px;
   background:rgba(255,255,255,.1);
}
.login-form .group input[data-type="password"]{
   text-security:circle;
   -webkit-text-security:circle;
}
.login-form .group .label{
   color:#aaa;
   font-size:12px;
}
.login-form .group .button{
   background:#1161ee;
}
.login-form .group label .icon{
   width:15px;
   height:15px;
   border-radius:2px;
   position:relative;
   display:inline-block;
   background:rgba(255,255,255,.1);
}
.login-form .group label .icon:before,
.login-form .group label .icon:after{
   content:'';
   width:10px;
   height:2px;
   background:#fff;
   position:absolute;
   transition:all .2s ease-in-out 0s;
}
.login-form .group label .icon:before{
   left:3px;
   width:5px;
   bottom:6px;
   transform:scale(0) rotate(0);
}
.login-form .group label .icon:after{
   top:6px;
   right:0;
   transform:scale(0) rotate(0);
}
.login-form .group .check:checked + label{
   color:#fff;
}
.login-form .group .check:checked + label .icon{
   background:#1161ee;
}
.login-form .group .check:checked + label .icon:before{
   transform:scale(1) rotate(45deg);
}
.login-form .group .check:checked + label .icon:after{
   transform:scale(1) rotate(-45deg);
}
.login-html .sign-in:checked + .tab + .sign-up + .tab + .login-form .sign-in-htm{
   transform:rotate(0);
}
.login-html .sign-up:checked + .tab + .login-form .sign-up-htm{
   transform:rotate(0);
}
</style>
</head>
<body>
<%@ include file="../top.jsp" %>
<div class="login-wrap">
   <div class="login-html">
      <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Login</label>
      <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Join</label>
      <div class="login-form">
         <form method="post" action="../product?command=login" onsubmit="return login(this)"> 
         <div class="sign-in-htm">
            <div class="group">
               <label for="memberId" class="label">ID</label>
               <input id="memberId" type="text" name="memberId" class="input">
            </div>
            <div class="group">
               <label for="memberPass" class="label">Password</label>
               <input id="memberPass" type="password" name="memberPass" class="input" data-type="password">
            </div>         
            <div class="group">
               <input type="submit" class="button" value="Sign In">
            </div>
            <div class="group">
               <input type="reset" class="button" value="cancle">
            </div>
            <div align="right">
               <a href="../index.jsp">Main</a>
            </div>
         </div>
         </form>
         <form method="post" action="../product?command=insert" onsubmit="return check(this)"> 
         <div class="sign-up-htm">
            <div class="group">
               <label for="memberId" class="label">ID</label>
               <input id="memberId" type="text" name="memberId"class="input">
            </div>
            <div class="group">
               <label for="memberPass" class="label">Password</label>
               <input id="memberPass" type="password" name="memberPass" class="input" data-type="password">
            </div>
            <div class="group">
               <label for="memberPass_Check" class="label">Repeat Password</label>
               <input id="memberPass_Check" type="password" name="memberPass_Check" class="input" data-type="password">
            </div>
            <div class="group">
               <label for="memberName" class="label">Name</label>
               <input id="memberName" type="text" name="memberName" class="input">
            </div>
            <div class="group">
               <label for="memberEmail" class="label">Email Address</label>
               <input id="memberEmail" type="text" name="memberEmail" class="input">
            </div>
            <div class="group">
               <label for="memberCellphone" class="label">Cell phone</label>
               <input id="memberCellphone" type="text" name="memberCellphone" class="input">
            </div>
            <div class="group">
               <label for="memberAddr" class="label">Address</label>
               <input id="memberAddr" type="text" name="memberAddr" class="input">
            </div>
            <div class="group">
               <label for="memberAge" class="label">Age</label>
               <input id="memberAge" type="text" name = "memberAge" class="input">
            </div>
            
            <div class="group">
               <input type="submit" class="button" value="Sign Up">
            </div>
            <div class="hr"></div>
            <div class="foot-lnk">
               <label for="tab-1">Already Member?</a>
            </div>
         </div>
         </form>
      </div>
   </div>
</div>
</body>
</html>