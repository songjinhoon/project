<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 수정</title>
</head>
<body>

	<p class="w3-left" style="padding-left: 30px;"></p>

	<div class="w3-container">
		<b>게시판 수정</b>
		<form method="post" name="writeform"
			action="${pageContext.request.contextPath}/board/updatePro">
			<input type="hidden" name="board_num"
				value="${article.getBoard_num()}">
			<table class="w3-table w3-bordered" style="width: 70%;">

				<tr>
					<td align="right" colspan="2"><a
						href="${pageContext.request.contextPath}/board/list">글 목록</a></td>
				</tr>
				<tr>
					<td align="center" width="70">이름</td>
					<td width="330"><input type="text" size="10" maxlength="10"
						name="mem_id" value="${ article.getMem_id()}"></td>
				</tr>

				<tr>
					<td align="center" width="70">제목</td>
					<td width="330"><input type="text" size="40" maxlength="50"
						name="subject" value="${ article.getSubject()}"></td>
				</tr>

				<tr>
					<td align="center" width="70">내용</td>
					<td width="330"><textarea name="content" rows="13" cols="40">${ article.getContent()}</textarea>
					</td>
				</tr>

				<tr>
					<td align="center" width="70">비밀번호</td>
					<td width="330"><input type="password" size="8" maxlength="12"
						name="passwd"></td>
				</tr>

				<tr>
					<td colspan=2 align="center"><input type="submit" value="수정">
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