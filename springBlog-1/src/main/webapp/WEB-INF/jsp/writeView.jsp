<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<meta charset="UTF-8">
	<title>JJH's Blog</title>
    <script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
</head>
<body>
	<form name="writeForm" method="post" action="/writeConfirm">
		제목 : <input name = "vtitle" id="vtitle" size=80/><br/>
		내용 : <textarea name = "vcontents" id="vcontents" size=80></textarea><br/>
		태그 : <input name = "vtag" id="vtag" size=80/><br/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit"/>
 	</form>
	<script type="text/javascript">
			CKEDITOR.replace( 'vcontents', {//해당 이름으로 된 textarea에 에디터를 적용
				width:'100%',
				height:'400px',
				filebrowserImageUploadUrl: '<c:url value="/file/ckeditorImageUpload" />?${_csrf.parameterName}=${_csrf.token}'
		    });
			
			CKEDITOR.on('dialogDefinition', function( ev ){
			    var dialogName = ev.data.name;
			    var dialogDefinition = ev.data.definition;
			 
			    switch (dialogName) {
			    	case 'image': //Image Properties dialog
			        	//dialogDefinition.removeContents('info');
			            dialogDefinition.removeContents('Link');
			            dialogDefinition.removeContents('advanced');
			            break;
			    }
			});
	</script>
</body>
</html>