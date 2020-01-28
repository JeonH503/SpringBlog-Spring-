<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="delWrap">
		<form method="POST" action="/user/userDeleteConfirm">
			<h4>회원탈퇴</h4>
			<h6>PASSWORD CHECK</h6>
			<input type="password" name = "vpassword"/>
			<c:if test="${not empty error}">
			    <font color="red">
			        <h6 class="errorText">잘못된 비밀번호 입니다.</h6>
			        <c:remove var="error"/>
			    </font>
			</c:if>
			<input type="hidden" name = "vusername" value="${user.getName()}"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="submit" value="회원탈퇴" class="delBtn"/>
		</form>
	</div>
</body>
</html> 