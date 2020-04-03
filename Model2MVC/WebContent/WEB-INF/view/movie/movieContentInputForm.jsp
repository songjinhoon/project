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
	<div class="row" style="height: 600px; background-color: #F2F2F2;">
		<div class="container-fluid my-auto">
			<p class="text-center" style="font-size: 20px; padding-top: 10px;">영화 상세정보 입력</p>
			<form method="post" action="${pageContext.request.contextPath}/movie/movieContentInputPro">
	   			<div class="form-group pt-3">
					<select name="movie_num"> 
						<option>선택</option>
						<c:forEach var="li" items="${li}">
							<option value="${li.movie_num}">${li.movie_name}</option>							
						</c:forEach>						
					</select>
   				</div>
				<div class="form-group pt-3">
					<input type="text" class="form-control" placeholder="영화줄거리를 입력하세요." name="movie_content">
				</div>
				<div class="form-group pt-3">
					<input type="text" class="form-control" placeholder="출연진은 입력하세요." name="movie_actor">
				</div>
				<div class="form-group pt-3">
					<input type="text" class="form-control" placeholder="상영 시간은 입력하세요." name="running_time">
				</div>
				<div class="form-group pt-3">
					<input type="text" class="form-control" placeholder="url 주소" name="url">
				</div>
				<div class="form-group pt-3"><input type="submit" class="btn btn-primary form-control" value="컨텐츠 등록"></div>
				<div class="form-group pt-3"><input type="reset" class="btn btn-primary form-control" value="다시작성"></div>
			</form>
		</div>
	</div>
</body>
</html>