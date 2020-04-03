<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>LIST</title>
</head>
<body>

   <div class="w3-bar w3-center">
      <a href="${pageContext.request.contextPath}/board/list?boardid=1"
         class="w3-bar-item w3-button w3-hover-none w3-border-white w3-bottombar w3-hover-border-black">공지사항</a>
      <a href="${pageContext.request.contextPath}/board/list?boardid=2"
         class="w3-bar-item w3-button w3-hover-none w3-border-white w3-bottombar w3-hover-border-black">Q&A</a>

      <c:if test="${boardid eq '1' && mem_id eq 'admin'}">
         <a href="${pageContext.request.contextPath}/board/writeForm" class="w3-bar-item w3-button w3-hover-none w3-border-white w3-bottombar w3-hover-border-black">글쓰기</a>
      </c:if>
      <c:if test="${mem_id eq 'admin' && boardid eq '2'}">
         <a href="${pageContext.request.contextPath}/board/writeForm" class="w3-bar-item w3-button w3-hover-none w3-border-white w3-bottombar w3-hover-border-black">글쓰기</a>
      </c:if>
      <c:if test="${mem_id ne 'admin' && mem_id ne '1' && boardid eq '2'}">
         <a href="${pageContext.request.contextPath}/board/writeForm" class="w3-bar-item w3-button w3-hover-none w3-border-white w3-bottombar w3-hover-border-black">글쓰기</a>
      </c:if>
   </div>
   <c:if test="${count==0}">
      <table class="w3-table w3-bordered">
         <tr class="w3-grey">
            <th align="center">게시판에 저장된 글이 없습니다.</th>
         </tr>
      </table>
   </c:if>
   <c:if test="${count!=0 }">
      <table class="w3-table w3-bordered">
         <tr>
            <th align="center">번호</th>
            <th align="center">제목</th>
            <th align="center">작성자</th>
            <th align="center">작성일</th>
            <th align="center">조회</th>
         </tr>
         <c:forEach var="article" items="${li}">
            <tr>
               <td align="center">${number}
                  <c:set var="number" value="${number-1}" />
               </td>
               <td align="center">
               <c:if test="${article.re_level >0}">
                  <img src="${pageContext.request.contextPath}/img/level.gif" width="{15 * (article.getRe_level}" height="16">
                  <img src="${pageContext.request.contextPath}/img/re.gif" /> 
               </c:if>
               <c:if test="${article.re_level ==0}">
                  <img src="${pageContext.request.contextPath}/img/level.gif" width="${0}" height="16" /> 
               </c:if>                  
               <a href="${pageContext.request.contextPath}/board/content?board_num=${ article.getBoard_num()}&pageNum=${ currentPage}">${article.getSubject()}</a>
               <td align="center">${ article.getMem_id()}</td>
               <td align="center">${ article.getReg_date()}</td>
               <td align="center">${ article.getReadcount()}</td>
            </tr>
         </c:forEach>
      </table>
      <br>
      <div class="w3-center">
         <c:if test="${startPage > bottomLine}">
            <a href="list?pageNum=${ startPage-bottomLine }">[이전]</a>
         </c:if>
         <c:forEach var="i" begin="${startPage}" end="${endPage}">
            <a href="list?pageNum=${i}">${i}</a>
         </c:forEach>
         <c:if test="${endPage < pageCount}">
            <a href="list?pageNum=${startPage+bottomLine}">[다음]</a>
         </c:if>
         </div>
 	</c:if>
   <br>
   <br>
</body>
</html>
