<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="\resources\css\viewDetailes.css" rel="stylesheet">
<meta charset="UTF-8">
<title>JJH's Blog</title>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="postWrap">
		<h2 class="title">${postData.vtitle}</h2>
		<p class="content">${postData.vcontents}</p>
		<a href="/postMod?postNo=${postData.ino}">수정</a>
		<a href="/postDel?postNo=${postData.ino}">삭제</a>
		<jsp:include page="comment.jsp"></jsp:include>
	</div>
	
</body>
</html>