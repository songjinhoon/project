<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>deletePro</title>
</head>
<body>
	<c:if test="${check == 0 }">
		<script>
			alert("~비밀번호가 일치하지않습니다~");
			history.go(-1);
		</script>
	</c:if>
	<c:if test="${check == -2 }">
		<script>
			alert("DB~오류");
			history.go(-1);
		</script>
	</c:if>
</body>
</html>



