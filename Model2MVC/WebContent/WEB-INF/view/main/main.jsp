<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="../css/swiper.min.css">
	<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR:200,300,400,500,600,700,900&display=swap&subset=korean" rel="stylesheet">
	<link rel="stylesheet" href="../css/main.css">
</head>
<body>
  	<div class="swiper-container">
    	<div class="swiper-wrapper">
      		<div class="swiper-slide" style="background-image:url(../img/1.jpg)"></div>
	      	<div class="swiper-slide" style="background-image:url(../img/2.jpg)"></div>
      		<!-- <a href="http://localhost:8080/zModel3/movie/movie_info?movie_num=9"><div class="swiper-slide" style="background-image:url(../img/3.jpg)"></div></a> -->
	      	<div class="swiper-slide" style="background-image:url(../img/4.jpg)"></div>
	      	<div class="swiper-slide" style="background-image:url(../img/5.jpg)"></div>
	      	<div class="swiper-slide" style="background-image:url(../img/6.jpg)"></div>
	      	<div class="swiper-slide" style="background-image:url(../img/7.jpeg)"></div>
	      	<div class="swiper-slide" style="background-image:url(../img/8.jpg)"></div>
	    </div>
    	<div class="swiper-pagination"></div>
  	</div>
	<script src="../js/swiper.min.js"></script>
	<script>
	  var swiper = new Swiper('.swiper-container', {
	    effect: 'coverflow',
	    grabCursor: true,
	    centeredSlides: true,
	    slidesPerView: 'auto',
	    coverflowEffect: {
	      rotate: 50,
	      stretch: 0,
	      depth: 100,
	      modifier: 1,
	      slideShadows : true,
	    },
	    pagination: {
	      el: '.swiper-pagination',
	      clickable : true,
	    },
	  });
	</script>
</body>
</html>