<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="\resources\css\singUp.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function chk(){
		if (!document.SingUpForm.vusername.value){
			alert("USERNAME을 입력해주세요.");
			document.SingUpForm.vusername.focus();
			return false;
		} else if (!document.SingUpForm.vpassword.value) {
			alert("PASSWORD를 입력해주세요.");
			document.SingUpForm.vpassword.focus();
			return false;
		} else if (document.SingUpForm.vpassword.value !== document.SingUpForm.vpasswordChk.value) {
			alert("PASSWORD가 서로 다릅니다.");
			document.SingUpForm.vpasswordChk.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<div class="singUpWrap">
		<form name="SingUpForm" method="post" action="/user/singUpConfirm" onsubmit="return chk()">
			<h6>USERNAME</h6>
			<input name = "vusername" class = "vusername"  />
			<c:if test="${not empty error}">
			    <font color="red">
			        <h6 class="errorText">중복된 아이디입니다.</h6>
			        <c:remove var="error"/>
			    </font>
			</c:if>
			<h6>PASSWORD</h6>
			<input name = "vpassword" class = "vpassword"/>
			<h6>PASSWORD CHEACK</h6>
			<input name = "vpasswordChk" class = "vpasswordChk"/>	
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
			<input type="submit" class="singUpBtn" value="회원가입"/>
		</form>
	</div>
</body>
</html>