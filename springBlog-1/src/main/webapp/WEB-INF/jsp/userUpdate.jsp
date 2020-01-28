<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function updateChk(){
		if (!document.updateForm.oldVpassword.value){
			alert("원래 PASSWORD를 입력해주세요.");
			document.updateForm.oldVpassword.focus();
			return false;
		} else if (!document.updateForm.vpassword.value) {
			alert("새로운 PASSWORD를 입력해주세요.");
			document.updateForm.vpassword.focus();
			return false;
		}else if (!document.updateForm.vpasswordChk.value) {
			alert("PASSWORD CHEACK를 입력해주세요.");
			document.updateForm.vpasswordChk.focus();
			return false;
		} else if (document.updateForm.vpassword.value !== document.updateForm.vpasswordChk.value) {
			alert("PASSWORD가 서로 다릅니다.");
			document.updateForm.vpasswordChk.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<div class="UpdateWrap">
		<form method="post" action = "/user/userUpdateConfirm" onsubmit="return updateChk()" name="updateForm">
			<h4>비밀번호 변경</h4>
			<h6>OLD PASSWORD</h6>
			<input type="password" name = "oldVpassword"/>
			<c:if test="${not empty updateError}">
			    <font color="red">
			        <h6 class="errorText">PASSWORD가 다릅니다.</h6>
			        <c:remove var="updateError"/>
			    </font>
			</c:if>
			<h6>NEW PASSWORD</h6>
			<input type = "password" name="vpassword"/>
			<h6>NEW PASSWORD CHECK</h6>
			<input type = "password" name="vpasswordChk"/>
			<input type="hidden" name = "vusername" value="${user.getName()}"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="submit" value="회원수정" class="updateBtn"/>
		</form>
	</div>
</body>
</html>