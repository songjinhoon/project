<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>석호꺼</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="../css/movie.css">
</head>
<body>
	<br>
	<div class="w3-row-padding">
	<div class="w3-third w3-margin-bottom" style="width: 80%; height: 60%; margin: 0 auto; float: none;">
			<ul class="w3-ul w3-center" style="width:100%;">
				<li class="w3-panel w3-border-top w3-border-bottom w3-border-green" style="height: 80px; font-size : 28px;">영화상세</li>
				<c:forEach var="li" items="${li}">
					<li class="w3-padding">
						<div class="media border p-3">
							<img src="${pageContext.request.contextPath}/uploadFile/${subContent.filename}" style="width:600px; height:800px;">
							<div class="media-body">
								<table>
									<tr>
										<th>제목:</th>
										<td>${li.movie_subject}</td>
									</tr>
									<tr>
										<th>장르:</th>
										<td>${subContent.movie_theme}</td>
									</tr>
									<tr>
										<th>출연:</th>
										<td>${li.movie_actor}</td>
									</tr>
									<tr>
										<th>상영시간:</th>
										<td>${li.running_time}분</td>
									</tr>
								</table>
								<dl>
									<dd>
										<button class="button" type="button" style="vertical-align: middle;" onclick="location.href='${pageContext.request.contextPath}/reservation/reservationForm'"><span>예매하기</span></button>
										<button class="button" type="button" style="vertical-align: middle;" onclick="location.href='${pageContext.request.contextPath}/movie/review_list?movie_num=${li.movie_num}&mem_id=${mem_id}'"><span>한줄평</span></button>
									</dd>
								</dl>
							</div>
						</div>
					</li>
					<li class="w3-padding">
						<h3>영화 줄거리</h3>
						<p>${li.movie_content}</p>
					</li>
					<li class="w3-padding">
						<h3>메인 예고편</h3> 
						<iframe type="text/html" width="100%" height="640" src="${li.url}" frameborder="0" ></iframe>
					</li>			
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>