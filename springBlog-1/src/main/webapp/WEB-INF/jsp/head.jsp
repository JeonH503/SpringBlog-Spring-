<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="\resources\css\head.css" rel="stylesheet">
	<title>Insert title here</title>
</head>
<body>
	<div class="head">
		<h1><a href="/" class = "name">JJH's Blog</a></h1>
	</div>
	<c:choose>
		<c:when test="${empty user}">
			<div class="headNavi">
				<a href="/user/login">로그인</a>
			</div>
		</c:when>
		<c:otherwise>
			<div class="headNavi">
				<a href="/user/mypage">마이페이지</a>
				<a href="/user/logout">로그아웃</a>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>