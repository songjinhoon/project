<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"
	type="text/javascript"></script>

<br>
<p>

	<script>
		// html 이 다 로딩된 후 실행
		$(document).ready(function() {
			// 체크박스들이 변경됬을때
			$(":checkbox").change(function() {
				var cnt = $("#person").val();

				// 셀렉트박스의 값과 체크박스중 체크된 갯수가 같을때, 다른 체크박스들을 disable 처리
				if (cnt == $(":checkbox:checked").length) {
					$(":checkbox:not(:checked)").attr("disabled", "disabled");
				}
				// 체크된 갯수가 다르면 활성화 시킴

			});

			// 셀렉트박스에서 다른 인원수를 선택하면 초기화 시킴
			$("#person").change(function() {
				$(":checkbox").removeAttr("checked");
			});
		});
	</script>
</head>
<body>
	</p>
	</br>

	<div align="center">

		<form action="${pageContext.request.contextPath }/reservation/reservationPro" method="post">

			<input type="hidden" name="schedule_num" value="${schedule_num }">
			<input type="hidden" name="movie_num" value="${movie_num }>">

			<div>
				<table class="w3-table w3-border" style="width: 40%;" align="center">
					<tr>
						<td width="30%">영화 제목</td>
						<td>${movie_name }</td>
					</tr>
					<tr>
						<td>영화 가격</td>
						<td>${schedule.movie_price}원</td>
					</tr>
					<tr>
						<td>상영일</td>
						<td>${schedule.movie_date}</td>
					</tr>
					<tr>
						<td>상영관</td>
						<td>${schedule.loc_num}관</td>
					</tr>
					<tr>
						<td colspan="2"><span>인원수 선택 </span>
						
						&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						
						 
							<select	id="person">
								<option value="1">1명</option>
								<option value="2">2명</option>
								<option value="3">3명</option>
								<option value="4">4명</option>
								<option value="5">5명</option>
						</select></td>
					</tr>
				</table>
			</div>
			<p>
			<table class="w3-table" style="width: 40%;">

			
				<c:forEach var="i" begin="1" end="7">
					<tr>
						<td>${i}열</td>
					
						<c:forEach var="j" begin="1" end="9">
						<c:set var="seats" value="${i}${j},"/>

							<td><%-- [${seats}:${checkedSeats }] --%>
								 <c:if test="${fn:contains(checkedSeats,seats) == true}">
									<input type="checkbox" value="${i}${j}" name="seat"	style="width: 50px; height: 50px;" disabled="disabled">
								</c:if> 
								
								<c:if test="${fn:contains(checkedSeats,seats) == false}">
									  <input type="checkbox" value="${i}${j}" name="seat" style="width: 50px; height: 50px;">
								 </c:if> 
								
							</td>
						</c:forEach>
					</tr>

				</c:forEach>
			</table>
			<p />

			<a	href="${pageContext.request.contextPath}/reservation/reservationForm2?schedule_num=${param.schedule_num}&movie_num=${param.movie_num}"
				style="text-decoration: none"> <input type="button"	class="w3-button  w3-medium w3-round-large" value="좌석 초기화"	style="background-color: #ffdddd; width: 12%;">
			</a> 
			
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			
			 <input type="button" class="w3-button  w3-medium w3-round-large" style="background-color: #ffdddd; 
			 width: 12%;" value="예매취소" onclick="location.href='${pageContext.request.contextPath}/reservation/reservationForm'">

			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			
			<input type="submit" class="w3-button  w3-medium w3-round-large" value="구매확인"	style="background-color: #ffdddd; width: 12%;">
		</form>
	</div>
</body>

</html>


