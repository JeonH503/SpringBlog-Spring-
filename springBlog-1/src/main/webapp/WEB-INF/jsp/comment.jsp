<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link href="\resources\css\commentModal.css" rel="stylesheet">
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		function commentChk(){
			if (!document.commentForm.comment.value){
				alert("공백을 입력할수 없습니다.");
				document.SingUpForm.comment.focus();
				return false;
			}
		}
	</script>
</head>
<body>
<div class="commentWrap">
	<c:if test="${not empty user}">
		<form action = "/commentRegist?postNo=${postData.ino}" method="post" class="commentForm" name="commentForm" onsubmit="return commentChk()">
			<input name = "comment" style="width:70%;height:37px;"/>
			<input type = "hidden" name = "boardNo" value = "${postData.ino}"/>
			<input type = "hidden" name = "vusername" value = "${user.getName() }"/>
			<input type = "hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type = "submit" class="commentBtn" value="등록"/>
		</form>
	</c:if>
	<c:if test="${empty user}">
		<form action = "/commentRegist?postNo=${postData.ino}" method="post" class="commentForm" name="NotLoginCommentForm" onsubmit="return commentChk()">
			<input name = "comment" placeholder="로그인후 이용 가능합니다." style="width:70%;height:37px;"/>
			<input type = "hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type = "submit" class="commentBtn" value="등록"/>
		</form>
	</c:if>
	<c:forEach var="el" items="${commentData}">
		<div class="commentTop">
			<p class="username">${el.vusername }</p> &nbsp;&nbsp;&nbsp;
			<p class="time">${el.ddatetime }</p>
		</div>
		<p class="comment">${el.comment }</p>
		<c:choose>
			<c:when test="${el.vusername eq user.getName()}">
				<div class = "commentBtns">
					<form action="/commentDelete" method="post" class="commentDelForm">
						<input type="hidden" name="ino" value="${el.ino}">
						<input type="hidden" name="boardNo" value="${el.boardNo}">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<button type = "submit" value="삭제"">삭제</button>
					</form>
					<button id="open">수정</button>
					<div class="modal hidden">
						<div class="modal_overlay"></div>
						<div class="modal_content">
							<form class="updateForm" action="/commentUpdate" method="post">
								<textarea class="updateContent" cols='40' rows='6' name = "comment" style="resize: none;"></textarea>
								<input type="hidden" name="ino" value="${el.ino}">
								<input type="hidden" name="boardNo" value="${el.boardNo}">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<input class="updateBtn" type = "submit" value="수정">
							</form>
							<button id="close">닫기</button>
						</div>
					</div>
					<script>
						const openBtn = document.getElementById("open");
						const closeBtn = document.getElementById("close");
						const modal = document.querySelector(".modal");
						const overlay = modal.querySelector(".modal_overlay");
						const openModal = () => {
				            modal.classList.remove("hidden");
				        }
						const closeModal = () => {
				            modal.classList.add("hidden");
				        }
						openBtn.addEventListener("click", openModal);
						closeBtn.addEventListener("click", closeModal);
						overlay.addEventListener("click", closeModal);
					</script>
				</div>
			</c:when>
		</c:choose>
		<br/>
	</c:forEach>
</div>
</body>
</html>