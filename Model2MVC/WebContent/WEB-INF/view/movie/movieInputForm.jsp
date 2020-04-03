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
			<p class="text-center" style="font-size: 20px; padding-top: 10px;">영화 등록</p>
			<form method="post" action="${pageContext.request.contextPath}/movie/movieInputPro" enctype="multipart/form-data">
	   			<div class="form-group pt-3">
	   				<input type="text" class="form-control" placeholder="영화이름" name="movie_name">
   				</div>
				<div class="form-group custom-file">
					<input type="file" class="form-control custom-file-input" id="customFileLang" name="uploadfile">
					<label class="custom-file-label" for="customFileLang" style="color: #848484;">영화 포스터</label>	
				</div>
				<div class="form-group pt-3">
					<input type="text" class="form-control" placeholder="영화장르" id="movie_theme" name="movie_theme">
				</div>
				<div class="form-group pt-3">
					<input type="text" class="form-control" placeholder="네이버 영화 링크" id="movie_url" name="movie_url">
				</div>
				<div class="row pt-3">
					<div class="col-lg-4"></div>
					<div class="col-lg-4">
						<div class="form-group"><input type="submit" class="btn btn-primary form-control" value="영화등록"></div>	
					</div>
					<div class="col-lg-4"></div>
				</div>
				<div class="row pt-3">
					<div class="col-lg-4"></div>
					<div class="col-lg-4">
						<div class="form-group"><input type="reset" class="btn btn-primary form-control" value="다시작성"></div>	
					</div>
					<div class="col-lg-4"></div>
				</div>
			</form>
		</div>	
	</div>
	<script>
		$(".custom-file-input").on("change", function() {
		  var fileName = $(this).val().split("\\").pop();
		  $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
		});
	</script>
</body>
</html>