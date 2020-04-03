<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원탈퇴</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginForm.css">
</head>
<body>

	<header class="w3-container w3-white"
		style="text-align: center; margin-bottom: 40px; font-size: 30px;">
		회원탈퇴 </header>

	<div class="w3-container w3-half w3-margin-top login_form">
		<form class="w3-container w3-card-4 w3-center"
			style="margin-top: 50px; margin-bottom: 150px;" method="post"
			action="${pageContext.request.contextPath}/member/deletePro">

			<p>
				<input class="w3-input" type="password" name="mem_passwd"
					id="myText2" placeholder="비밀번호" style="width: 90%" required>
			</p>


			<input type="submit" value="회원탈퇴"> 
			<input type="button"value="취소" 
			onclick="javascrip:window.location='${pageContext.request.contextPath}/main/main.jsp'">
			<p>
		</form>
	</div>
</body>
</html>