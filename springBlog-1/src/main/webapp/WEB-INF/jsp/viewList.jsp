<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="\resources\css\viewList.css" rel="stylesheet">
	<title>JJH's Blog</title>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="wrap">
		<div class="posts">
			<c:forEach var="el" items="${boardData}">
				<div class="post">
					<div class="postTop">
						<p class="postImg">${el.vfirstimg}</p>
						<h2><a class="title" href="/post?postNo=${el.ino}">${el.vtitle}</a></h2>
					</div>
					<div class="postFooter">
						<a class="tag" href="/?tag=${el.vtag}"><h4>${el.vtag}</h4></a>
						<h6>${el.ddatetime}</h6>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="side">
			<jsp:include page="myInfo.jsp"></jsp:include>
			<jsp:include page="navi.jsp"></jsp:include>
			<jsp:include page="search.jsp"></jsp:include>
		</div>
	</div>
	
</body>
</html>