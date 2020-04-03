<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR:200,300,400,500,600,700,900&display=swap&subset=korean" rel="stylesheet">
	<style>
		*{font-family: 'Noto Serif KR', serif;}
	</style>
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
	<script> //사이드바 메뉴 선택 색상 변경
		window.onload = function () {
		var atag = document.getElementsByTagName("a");
		var url = document.location.href.split("/");
		
		
		if(url[url.length-1]=="main.jsp"){
			atag[0].className += " w3-black";
		}
		else if(url[url.length-1]=="movie_list.jsp"){
			atag[1].className +=" w3-black";
		}
		else if(url[url.length-1]=="reservationForm.jsp"){
			atag[2].className += " w3-black";
		}	
		else if(url[url.length-1]=="chart_main.jsp"){
			atag[3].className += " w3-black";
		}	
		else if(url[url.length-1]=="inputForm.jsp"){
			atag[4].className += " w3-black";
		}
		else if(url[url.length-1]=="passwdCheckForm.jsp"){
			atag[5].className += " w3-black";
		}
		
		else if(url[url.length-1]=="movieInputForm.jsp"){
			atag[6].className += " w3-black";
		}
		
		else if(url[url.length-1]=="scheduleInputForm.jsp"){
			atag[7].className += " w3-black";
		}
		
		else if(url[url.length-1]=="movieContentInputForm.jsp"){
			atag[8].className += " w3-black";
		}
	}
	</script>
<body>
	<div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none; width:30%;z-index: 999;" id="leftMenu">
  		<button onclick="closeLeftMenu()" class="w3-bar-item w3-button w3-large"><i class="fas fa-times"></i></button>
		<a href="${pageContext.request.contextPath}/movie/movie_list" class="w3-bar-item w3-button">
		<i class="fas fa-video"></i> 영화 소개</a>
		
		<a href="${pageContext.request.contextPath}/reservation/reservationForm" class="w3-bar-item w3-button">
		<i class="fas fa-ticket-alt"></i> 영화 예매</a>
		
		<a href="${pageContext.request.contextPath}/graph/bar_sample_success" class="w3-bar-item w3-button">
		<i class="fas fa-chart-pie"></i> 영화 데이터 차트</a>
		
		<a href="${pageContext.request.contextPath}/graph/chart_main_WordCloud_Seccess" class="w3-bar-item w3-button">
		<i class="fas fa-chart-pie"></i> 영화 WordCloud</a>
		
		<a href="${pageContext.request.contextPath}/datachart/dataChart" class="w3-bar-item w3-button"><i class="fas fa-chart-pie"></i> CGV 영화관 예매율</a>
		<a href="${pageContext.request.contextPath}/datachart/dataChartArthouse" class="w3-bar-item w3-button"><i class="fas fa-chart-pie"></i> ARTHOUSE 영화관 예매율</a>
		<a href="${pageContext.request.contextPath}/datachart/dataChartSeoulcinema" class="w3-bar-item w3-button"><i class="fas fa-chart-pie"></i> SEOULCINEMA 영화관 예매율</a>
		
		<a href="${pageContext.request.contextPath}/board/list?boardid=1" class="w3-bar-item w3-button">
		<i class="fas fa-edit"></i> 게시판 </a>
 		<c:if test="${mem_id eq 'admin'}">
 			<a href="${pageContext.request.contextPath}/movie/movieInputForm" class="w3-bar-item w3-button"><i class="far fa-smile"></i> 영화 등록</a>
			<a href="${pageContext.request.contextPath}/movie/scheduleInputForm" class="w3-bar-item w3-button"><i class="far fa-smile"></i> 스케줄 등록</a>
			<a href="${pageContext.request.contextPath}/movie/movieContentInputForm" class="w3-bar-item w3-button"><i class="far fa-smile"></i> 영화 콘텐츠 등록</a>
 		</c:if>
		<c:if test="${mem_id eq '1'}">
 			<a href="${pageContext.request.contextPath}/member/inputForm" class="w3-bar-item w3-button"><i class="far fa-smile"></i> 회원 가입</a>
			<a href="${pageContext.request.contextPath}/member/loginForm" class = "w3-bar-item w3-button">Login</a>	
		</c:if>
		<c:if test="${mem_id ne '1'}">
			<span class = "w3-bar-item w3-button"> >>>>>>${mem_id}님 안녕하세요</span>
			<a href="${pageContext.request.contextPath}/member/logout" class="w3-bar-item w3-button">Logout</a>
			<a href="${pageContext.request.contextPath}/member/passwdCheckForm" class="w3-bar-item w3-button">my page/회원정보수정</a>
			<a href="${pageContext.request.contextPath}/member/deleteForm" class="w3-bar-item w3-button">회원탈퇴</a>
			<a href="${pageContext.request.contextPath}/reservation/bookingList" class="w3-bar-item w3-button">예매내역</a>
		</c:if>
	</div>  
	<div class="w3-sidebar w3-bar-block w3-card w3-animate-right w3-dark-gray" style="display:none;right:0;width:30%;z-index: 999;" id="rightMenu">
		<button onclick="closeRightMenu()" class="w3-bar-item w3-button w3-large"><i class="fas fa-times"></i></button>
	 	<a href="#" class="w3-bar-item" style="text-decoration:none">현재상영작</a>
		<p>  
	   	<div align="center">
    	    <img src="../img/1.jpg" style="width:90%">
	        <p>
	        <img src="../img/2.jpg" style="width:90%">
	        <p>
	        <img src="../img/3.jpg" style="width:90%">
	        <p>
	         <img src="../img/7.jpeg" style="width:90%">
	      </div>
	</div>
	<c:if test="${main ne null}">
		<button class="w3-button w3-black w3-xlarge w3-left" onclick="openLeftMenu()">☰</button>
      	<button class="w3-button w3-black w3-xlarge w3-right" onclick="openRightMenu()"><i class="fas fa-crown"></i></button>
	</c:if>
	<c:if test="${main eq null}">
		<button class="w3-button w3-white w3-xlarge w3-left" onclick="openLeftMenu()">☰</button>
 	    <button class="w3-button w3-white w3-xlarge w3-right" onclick="openRightMenu()"><i class="fas fa-crown"></i></button>
	</c:if>
	<div class="logo" align="center">
		<a href="${pageContext.request.contextPath}/main/main"><img src="../img/logo.png" style="width:8%; height:8%;"></a>
	</div>
	<!-- Page Content -->
	<div class="w3-overlay w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" id="myOverlay"></div>

	<script> //사이드바 왼오
		function openLeftMenu() {
		  document.getElementById("leftMenu").style.display = "block";
		  document.getElementById("myOverlay").style.display = "block";
		}
		
		function closeLeftMenu() {
		  document.getElementById("leftMenu").style.display = "none";
		  document.getElementById("myOverlay").style.display = "none";
		}
		
		function openRightMenu() {
		  document.getElementById("rightMenu").style.display = "block";
		  document.getElementById("myOverlay").style.display = "block";
		}
		
		function closeRightMenu() {
		  document.getElementById("rightMenu").style.display = "none";
		  document.getElementById("myOverlay").style.display = "none";
		}
	</script>
	
</body>
</html>