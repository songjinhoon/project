<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>
	<p class="w3-left" style="padding-left: 30px;"></p>

	<div class="w3-container">
		<b>글쓰기</b>
		<form method="post" name="writeform" action="${pageContext.request.contextPath}/board/writePro">
			<input type="hidden" name="board_num" value="${board_num}">
			<input type="hidden" name="ref" value="${ref}"> 
			<input type="hidden" name="re_level" value="${re_level}"> 
			<input type="hidden" name="re_step" value="${re_step}">
			<table class="w3-table w3-bordered" style="width: 70%;">
				<tr>
					<td align="right" colspan="2"><a href="${pageContext.request.contextPath}/board/list">글 목록</a></td>
				</tr>
				<tr>
					<td align="center" width="70">아이디</td>
					<td width="330"><input type="text" size="10" maxlength="10" name="mem_id"></td>
				</tr>
				<tr>
					<td align="center" width="70">제목</td>
					<td width="330">
					<c:if test="${param.board_num == null}">
						<input type="text" size="40" maxlength="50" name="subject">

						</c:if> <c:if test="${param.board_num != null}">


							<input type="text" size="40" maxlength="50" name="subject"
								value="답변> ">


						</c:if></td>
				</tr>

				<tr>
					<td align="center" width="70">내용</td>
					<td width="330"><textarea name="content" rows="13" cols="40"></textarea>
					</td>
				</tr>

				<tr>
					<td align="center" width="70">비밀번호</td>
					<td width="330"><input type="password" size="8" maxlength="12"
						name="passwd"></td>
				</tr>

				<tr>
					<td colspan=2 align="center"><input type="submit" value="글쓰기">
						<input type="reset" value="다시작성"> <input type="button"
						value="목록보기"
						onClick="window.location='${pageContext.request.contextPath}/board/list'">
					</td>

				</tr>
			</table>
		</form>

	</div>
</body>
</html>