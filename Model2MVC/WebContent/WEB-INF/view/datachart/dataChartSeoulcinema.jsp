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


    <p class="text-center" style="font-size: 28px;">서울극장 현재 예매율</p>
      <div class="row" style="margin: 0 auto; width: 100%;">
         <c:forEach var="i" begin="0" end="3">
         <div class="col-lg-3" style="padding-bottom: 0;">
            <p class="text-center" style="font-size: 20px; border: 1px solid black; margin:0;"><c:out value="${movieList[i].title}" /></p>
            <a href="http://m.seoulcinema.com/movie/${movieList[i].movieLink}">
               <img class="img-responsive center-block" src="${movieList[i].post}" style="max-width: 100%; height: auto; border: 1px solid gray;">
            </a>
            <p class="text-center" style="border: 1px solid gray;">${movieList[i].percent}</p>
         </div>         
         </c:forEach>
   </div>
      <div class="row" style="margin: 0 auto; width: 100%;">
         <c:forEach var="i" begin="4" end="7">
         <div class="col-lg-3" style="padding-bottom: 0;">
            <p class="text-center" style="font-size: 20px; border: 1px solid black; margin:0;">${movieList[i].title}</p>
            <a href="http://m.seoulcinema.com/movie/${movieList[i].movieLink}">
               <img class="img-responsive center-block" src="${movieList[i].post}" style="max-width: 100%; height: auto; border: 1px solid gray;">
            </a>
            <p class="text-center" style="border: 1px solid gray;">${movieList[i].percent}</p>
         </div>         
         </c:forEach>
   </div>
</body>
</html>