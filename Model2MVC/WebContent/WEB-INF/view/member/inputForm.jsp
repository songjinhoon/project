<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>

<style>
table {
	margin: 60px;
}
</style>
<title>회원가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginForm.css">

</head>

<script>
function checkIt(){
	var userinput = eval("document.userinput");
	
	if(!document.userinput.id.value){ alert("ID를 입력하세요"); userinput.id.focus();
	return false;}
	if(!document.userinput.passwd.value){ alert("비밀번호를 입력하세요"); userinput.passwd.focus();
	return false;}
	if(!document.userinput.name.value){ alert("이름을 입력하세요"); userinput.name.focus();
	return false;}
	if(!document.userinput.gender.value){ alert("성별을 입력하세요"); userinput.gender.focus();
	return false;}
	if(!document.userinput.phone1.value){ alert("핸드폰번호를 입력하세요"); userinput.phone1.focus();
	return false;}
	if(!document.userinput.phone2.value){ alert("핸드폰번호를 입력하세요"); userinput.phone2.focus();
	return false;}
	if(!document.userinput.phone3.value){ alert("핸드폰번호를 입력하세요"); userinput.phone3.focus();
	return false;}
}
</script>
<body>
	<header class="w3-container w3-white"
		style="text-align: center; margin-bottom: 40px; font-size: 30px;">
		회원가입 </header>
	<div class="w3-container w3-half w3-margin-top login_form">
		<form class="w3-container w3-card-4 w3-center" name="userinput"
			style="margin-bottom: 60px;" method="post"
			action="${pageContext.request.contextPath}/member/inputPro" onsubmit="return checkIt()">

			<table class="w3-table" cellspacing="0" cellpadding="3">
				<tr>
					<td width="100">아이디</td>
					<td width="300"><input type="text" name="id" size="10"
						maxlength="12" autocomplete=off></td>
				</tr>
				<tr>
					<td width="100">비밀번호</td>
					<td width="300"><input type="password" name="passwd" size="15"
						maxlength="12"></td>
				</tr>


				<tr>
					<td width="100">이름</td>
					<td width="300"><input type="text" name="name" size="15"
						maxlength="10" autocomplete=off></td>
				</tr>


				<tr>
					<td width="100">성별</td>
					<td width="300"><select name="gender">
							<option value="여자">여자</option>
							<option value="남자">남자</option>
							<option value="성별" selected="selected">선택</option>
					</select></td>
				</tr>

				<tr>
					<td width="100">휴대전화</td>
					<td width="400"><input type="text" name="phone1" size="4"
						maxlength="3" autocomplete=off> - <input type="text"
						name="phone2" size="4" maxlength="4" autocomplete=off> - <input
						type="text" name="phone3" size="4" maxlength="4" autocomplete=off></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="confirm"
						style="margin-top: 20px; margin-left: 150px; margin-right: 10px;"
						value="등  록"> <input type="reset" name="reset"
						style="margin-right: 10px;" value="다시입력"> <input
						type="button" value="가입안함"
						onclick="javascript:window.location='${pageContext.request.contextPath}/main/main.jsp'"> <!--name을 DB에 넣을때 일치해서넣어야함.  --></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>