<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <title>석호꺼</title>
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/movie.css">
</head>
<body>
   <br>
   <div class="w3-row-padding">
   <div class="w3-third w3-margin-bottom" style="width: 80%; height: 60%; margin: 0 auto; float: none;">
         <ul class="w3-ul w3-center " style="width:100%;">
            <li class="w3-panel w3-border-top w3-border-bottom w3-border-green" style="height: 80px; font-size : 28px;" >현재상영작</li>
            <c:if test="${listSchedule == null}">
               <li class="list-group-item">상영중인 영화가 없습니다</li>
            </c:if>
            <c:if test="${listSchedule != null}">
               <c:forEach var="listMovie" items="${listMovie}">
                  <li class="w3-padding" style="height: 287px;">
                     <img src="${pageContext.request.contextPath}/uploadFile/${listMovie.filename}" style="height: 270px; width: 200px; float: left;">
                     <dl style="margin-left: 30%; text-align: left;">
                        <dt>제목: ${listMovie.movie_name}</dt>
                        <dt>장르: ${listMovie.movie_theme}</dt>
                        <p>
                        <br>
                        <button class="button" style="vertical-align: middle" onclick="location.href='${pageContext.request.contextPath}/reservation/reservationForm'"><span>예매하기</span></button>
                        <button class="button" style="vertical-align: middle" onclick="location.href='${pageContext.request.contextPath}/movie/movie_info?movie_num=${listMovie.movie_num}'"><span>상세정보</span></button>
                     </dl>
                  </li>
               </c:forEach>
            </c:if>
         </ul>
      </div>
   </div>
</body>
</html>