<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style>
.submit{
background-color: pink;}
</style>
</head>
<body>
	<p class="text-center" style="font-size: 28px;">상영 시간표</p>
	<br>
	<div class="container-fluid w3-container" style=" width:80%">
		<div style="height: 10px;"></div>
		<c:forEach var="mv"   items="${movieList}">
			<div class="container-fluid bg-light" style="border: 1px solid gray; margin-bottom: 10px;">
			<p style="padding-top: 10px;">${mv.movie_name }</p>
				<div class="container-fluid " style="padding: 0;">
					<form method="post"	action="${pageContext.request.contextPath }/reservation/reservationForm2">
						<select name="schedule_num" class="custom-select mb-3 ">
							<option>선택하세요.</option>
							 <c:if test="${!mv.li.isEmpty()}">
							<c:forEach var="check" items="${mv.li}">
								<option value="${check.getSchedule_num()}">
								상영관 : ${check.getLoc_num()}관 - 
								상영일 : ${check.getMovie_date()} - 
								가격 : ${check.getMovie_price()}
								</option>
							</c:forEach></c:if> 
							<input type="hidden" name="movie_num" value="${mv.movie_num}">	
							<input type="hidden" name="schedule_num" value="${li.schedule_num}">	
						</select> 
						<p>
					<input type="submit" value="예매하기" id="submit" >
		
					<p>
					</form>
				</div>
			</div>
		</c:forEach>
		<div style="height: 3px;"></div>
	</div>
</body>
</html>