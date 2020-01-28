<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="\resources\css\navi.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="navi">
		<c:forEach var="el" items="${naviData}">
			<li class="tag"><a href="/?tag=${el.vtag}">${el.vtag}(${el.count})</a></li>
		</c:forEach>
	</div>
</body>
</html>