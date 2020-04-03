
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>예매조회</title>
</head>
<body>
	<p>		<br>	<p>	<p>		<br>	<p>
	
		
		<br>	<p>		<br>	<p>
	
	<table class="w3-table w3-bordered" style="width: 80%" align="center">
		<tr>
			<!-- <tr class="w3-grey"> -->
			<th align="center">영화제목</th>
			<th align="center">상영날짜</th>
			<th align="center">상영관</th>
			<th align="center">좌석번호</th>
		</tr>
		<c:forEach   var="entry"   items="${map}">
		<tr>
			<td align="center">${entry.value.get(0).movie_name}</td>
			
			
			<td align="center">
			${entry.value.get(0).movie_date }
			</td>
			
			
			<td align="center">
			${entry.value.get(0).loc_num }
			</td>
		
			<td align="center">
				<c:set var="ss"  value=""/>
				<c:forEach  var="l"   items="${entry.value }"  varStatus="c">
					<c:set var="ss"  value="${ss}${l.seat},"/>
				</c:forEach> 
				${ss }
			</td>			
			
			<c:set var="ff"  value=""/>
				<c:forEach  var="l"   items="${entry.value }"  varStatus="c">
					<c:set var="ff"  value="${ff}${l.booking_num},"/>
				</c:forEach> 
			
			
	
			<td align="center">
			<input type="button" class="w3-button w3-hover-red w3-small w3-round-large" style="background-color: #ffdddd;" 
			name="booking_nums" value="예매취소" onclick="location.href='${pageContext.request.contextPath }/reservation/bookingCancel?booking_nums=${ff }'">
			
		</tr>

		</c:forEach>
	</table>


	<br>	<p>	<p>		<br>	<p>		<br>	<p>		<br>	<p>
</body>
</html>
