<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row" style="height: 400px; background-color: #F2F2F2;">
		<div class="container-fluid my-auto">
			<p class="text-center" style="font-size: 20px; padding-bottom: 10px;">비밀 번호 입력</p>
			<form method="post" action="${pageContext.request.contextPath}/member/passwdCheckPro">
				<div class="form-group"><input type="password" class="form-control" placeholder="비밀번호 입력 란" name="mem_passwd"></div>
				<div class="row" style="padding-top: 10px;">
					<div class="col-lg-4"></div>
					<div class="col-lg-4">
						<div class="form-group"><input type="submit" class="btn btn-primary form-control" value="확인"></div>	
					</div>
					<div class="col-lg-4"></div>
				</div>
			</form>
		</div>	
	</div>
</body>
</html>