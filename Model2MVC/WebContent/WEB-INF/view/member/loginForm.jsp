<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginForm.css">

</head>
<body>
<body>
	<header class="w3-container w3-white"
		style="text-align: center; margin-bottom: 40px; font-size: 30px;">
		로그인 </header>
	<div class="w3-container w3-half w3-margin-top login_form">
		<form class="w3-container w3-card-4 w3-center"
			style="margin-top: 50px; margin-bottom: 150px;" method="post"
			action="${pageContext.request.contextPath}/member/loginPro">


			<p>
				<input class="w3-input" type="text" name="mem_id" id="myText1"
					placeholder="아이디" style="width: 90%" required>
			</p>

			<p>
				<input class="w3-input" type="password" name="mem_passwd" id="myText2"
					 placeholder="비밀번호" style="width: 90%" required>
			</p>

			<p>
				<input type="submit" class="logbtn" value="Login">
			</p>

			<div class="bottom-text">
				아직 회원이 아니시면 <a
					href="${pageContext.request.contextPath}/member/inputForm"
					style="text-decoration: none"><b>회원가입</b></a>
			</div>

		</form>
	</div>

	<script>
		function myFunction() {
			document.getElementById("myText1").placeholder = "Type name here..";
		}

		function myFunction() {
			document.getElementById("myText2").placeholder = "Type password here..";
		}
	</script>

</body>
</html>