<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<link href="\resources\css\login.css" rel="stylesheet">
<meta charset="UTF-8">
<title>JJH's Blog</title>
</head>
<body>
	<div class="loginWrap">
		<form action="/loginProcess" method="post">
			<h6>ID</h6>
			<input type="text" name = "vusername" class="vusernameWindow"/>
			<h6>PASSWORD</h6>
			<input type="password" name = "vpassword" class="vpasswordWindow"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br/>
			<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
			    <font color="red">
			        <h6 class="errorText">아이디 혹은 비밀번호를<br/> 잘못 입력하셨습니다.</h6>
			        <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
			    </font>
			</c:if>
			<input type="submit" value="로그인" class="loginBtn"/>
			<button type="button" onclick="location.href='/user/singUp'">회원가입</button>
		</form>
	</div>
</body>
</html>