<%@page import="dao.BookingDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>예약취소</title>
</head>
<body>

	<br>
	<p>
		<br>
	<p>
		<br>
	<div align="center">
		<div align="center" class="w3-card" style="height: 40%; width: 50%;">

			<p>
				<br>
			<p>
				<br>
			<p>
			<h3>
				예매취소가 완료되었습니다.<br> 다음에 또 이용해주세요!
			</h3>
			<br> <br>
			<button class="w3-button w3-hover-red w3-xlarge w3-round-xlarge"
				style="background-color: #ffdddd; width: 20%;"
				onclick="location.href='${pageContext.request.contextPath }/reservation/bookingList'">예매확인</button>

			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

			<button class="w3-button w3-hover-red w3-xlarge w3-round-xlarge"
				style="background-color: #ffdddd; width: 20%;"
				onclick="location.href='${pageContext.request.contextPath }/main/main'">Home</button>
				<p><br>
		</div>
	</div>

	<p>
		<br>
	<p>
		<br>
	<p>
	<p>
		<br>
	<p>
		<br> <br>
</body>
</html>