<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<br>	<p>		<br>	<p>		<br>
		
	<div align="center">
	<div align="center"  class="w3-card" style=" height:40%; width:50%;">
	
	<p>		<br>	<p><br>		<p>
		<br>	
		<h3>예매가 완료되었습니다!</h3>
		<br>		<p>			<br> 
		
		<button class="w3-button w3-hover-red w3-xlarge w3-round-xlarge" style="background-color: #ffdddd; width:20%;"  onclick="location.href='${pageContext.request.contextPath}/reservation/bookingList'">예매확인</button>
				
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
			
		<button class="w3-button w3-hover-red w3-xlarge w3-round-xlarge" style="background-color: #ffdddd; width:20%;" onclick="location.href='${pageContext.request.contextPath}/reservation/reservationForm'">예매페이지</button>
			<p>		<br>	<p>		<br><p>	
	</div>
	<p>	<br>
	</div>
	
<p>		<br>	<p>	<p>		<br>	<p>		<br>
	
</body>
</html>