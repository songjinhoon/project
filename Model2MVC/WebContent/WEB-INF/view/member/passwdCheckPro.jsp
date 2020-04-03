<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${check eq mem_passwd}">
		<meta http-equiv="Refresh" content="0;url=modifyForm">
	</c:if>
	<c:if test="${check ne mem_passwd}">
		<script>
			alert("비밀번호가 틀립니다.");
			history.back();
		</script>
	</c:if>
</body>
</html>