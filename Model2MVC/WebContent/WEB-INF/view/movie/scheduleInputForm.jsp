<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
			<p class="text-center" style="font-size: 20px; padding-bottom: 10px;">영화 상품 등록</p>
			<form method="post" action="<%= request.getContextPath() %>/movie/scheduleInputPro">
    			<select name="movie_num" class="custom-select mb-3">
      			<option>영화 선택</option>
      			<c:forEach var="list" items="${list}">
					<option value="${list.movie_num}">영화 번호: ${list.movie_num} - 영화 이름: ${list.movie_name}</option>      			
      			</c:forEach>
   				</select>
				<div class="form-group"><input type="text" class="form-control" placeholder="yyyy-mm-dd hh:mm 입력" name="movie_date" maxlength="16"></div>
				<div class="form-group"><input type="text" class="form-control" placeholder="영화 가격" name="movie_price" maxlength="16"></div>
    			<select name="loc_num" class="custom-select mb-3">
      			<option>상영관 선택</option>
      			<c:forEach var="i" begin="1" end="10">
      				<option value='<c:out value="${i}"></c:out>'><c:out value="${i}"></c:out>관</option>  
      			</c:forEach>
				</select>	
				<div class="row" style="padding-top: 10px;">
					<div class="col-lg-4"></div>
					<div class="col-lg-4">
						<div class="form-group"><input type="submit" class="btn btn-primary form-control" value="상품 등록"></div>	
					</div>
					<div class="col-lg-4"></div>
				</div>
			</form>
		</div>	
	</div>
</body>
</html>