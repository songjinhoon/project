<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>쌍용극장</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/movie.css">
	<style>
		li { list-style: none; }
	</style>
</head>
<body>
	<div class="w3-row-padding" style="margin-left: 200px;">
		<div class="w3-third w3-margin-bottom" style="width: 240px;">
			<ul class="w3-ul  w3-center">
				<li class="w3-xlarge w3-padding-32" style="border-bottom: none;">	<img src="${pageContext.request.contextPath}/uploadFile/${subContent.filename}" style="height: 600px; width: 380px; float: left;"></li>
			</ul>
		</div>
		<div class="w3-third w3-margin-bottom" style =" width: 70%;float: right;">
			<ul class="w3-ul w3-center " style="width: 80%;">
					<li class="w3-panel w3-border-top w3-border-bottom w3-border-green" style="height: 80px; font-size : 28px;">한줄평</li>
			</ul>
			<form method="post" name="review_list" action="${pageContext.request.contextPath}/movie/reviewPro">
				<input type="hidden" name="movie_num" value="${movie_num}">
				<input type="hidden" name="mem_id" value="${mem_id}">
			<%-- 	<input type="hidden" name="filename" value="${filename}"> --%>
				
				<ul class="w3-ul w3-border" style="width: 80%;">
					<li class="w3-padding">
						<div class="media border p-3">
							<img src="${pageContext.request.contextPath}/img/pic.png" class="mr-3 mt-3 rounded-circle" style="width: 60px; height: 50px; float: left;"> 
							<div class="media-body">
								<textarea name="content" placeholder="관람평을 입력해주세요." style="resize: none; width: 80%; line-height: 2.0;"></textarea>
								<c:if test="${mem_id ne '1'}">
									<button type="submit" class="re_button">등록</button>
								</c:if>
							</div>
						</div>  
					</li>
				</ul>
			</form>
			<c:choose>
				<c:when test="${li == null}">
					<li class="w3-padding">
						<div class="media-body">관람평이 없습니다</div>
					</li>
				</c:when>
				<c:otherwise>
					<c:forEach var="li" items="${li}">
						<li class="w3-padding">
							<div class="media border p-3">
								<img src="${pageContext.request.contextPath}/img/pic.png" class="mr-3 mt-3 rounded-circle" style="width: 60px; height: 50px; float: left;">
								<div class="media-body">
									<h4>${li.mem_id}
										<small><i>${li.reg_date}</i></small>
									</h4>
									<small><i>${li.content}</i></small>
								</div>
							</div>
						</li>
					</c:forEach>				
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<br>
	<p>
	<div align="center">
		<button class="button" style="vertical-align: middle;" onclick="location.href='${pageContext.request.contextPath}/movie/movie_list'"><span>영화목록</span></button>
	</div>
</body>
</html>
