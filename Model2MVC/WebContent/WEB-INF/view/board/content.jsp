<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Content</title>
</head>
<body>
   <div class="w3-container" style="padding: 50px;">
      <table class="w3-table w3-bordered">
         <tr>
            <th align="center">글번호</th>
            <td align="center">${article.getBoard_num()}</td>
            <th align="center">조회수</th>
            <td align="center">${article.getReadcount()}</td>
         </tr>
         <tr>
            <th align="center">작성자</th>
            <td align="center">${article.getMem_id()}</td>
            <th align="center">작성일</th>
            <td align="center">${article.getReg_date()}</td>
         </tr>
         <tr>
            <th align="center">글제목</th>
            <td align="center" colspan="3">${ article.getSubject()}</td>
         </tr>
         <tr>
            <th align="center">글내용</th>
            <td align="center" colspan="3">${ article.getContent()}</td>
         </tr>
         <tr>
            <td colspan="4" class="w3-center">
               <input type="button" value="글수정" onClick="document.location.href='${pageContext.request.contextPath}/board/updateForm?board_num=${article.getBoard_num()}'">&nbsp;&nbsp;&nbsp;&nbsp;
               <c:if test="${boardid eq '2' && mem_id eq 'admin'}">
                  <input type="button" value="답변쓰기" onClick="document.location.href='${pageContext.request.contextPath}/board/writeForm?board_num=${article.getBoard_num()}&ref=${ article.getRef()}&re_level=${article.getRe_level()}&re_step=${ article.getRe_step()}'">&nbsp;&nbsp;&nbsp;&nbsp;
               </c:if> 
               <input type="button" value="글삭제" onClick="document.location.href='${pageContext.request.contextPath}/board/deleteForm?board_num=${article.getBoard_num()}'"> 
            </td>
         </tr>
      </table>
   </div>
</body>
</html>
