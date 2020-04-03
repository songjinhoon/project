<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
img {
	width: 350px;
	height: 550px;
}

.wordcloud {
	margin: 0.5in auto;
	padding: 0;
	page-break-after: always;
	page-break-inside: avoid;
	height: 400px;
	width: 680px;
}
</style>

<html>
<head>
	<title>Chart</title>
	<meta name="description" content="A Word Cloud plugin for jQuery.">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
	<script	src="${pageContext.request.contextPath}/js/jquery.awesomeCloud-0.2.js"></script>
	<link href="http://www.jqueryscript.net/css/jquerysctipttop.css"	rel="stylesheet" type="text/css">
</head>
<body>
	<br>	<p>		<br>	<p>		<br>	<p>		<br>
	<div align="center" style="width: 90%; margin-left: 90px;">
		<table class="w3-table w3-bordered">
			<c:forEach var="list1" items="${list}" varStatus="status">
				<tr>
					<td rowspan="3" width="25%"><img src="${pageContext.request.contextPath}/uploadFile/${list1.getFilename()}"></td>
					<td>영화 번호 : ${list1.getMovie_num()}</td>
					<td rowspan="3" width="50%">
						<div id="${wordcloudID[status.index]}" class="wordcloud">
							<c:forEach var="str" items="${test}">
								<c:forEach var="str1" items="${str}">
									<c:if test="${str1.value >= 1}">
										<span data-weight="${str1.value * size}">${str1.key}</span>									
									</c:if>
								</c:forEach>	
							</c:forEach>
						</div>
					</td>
				</tr>
				<tr>
					<td>영화 제목 : ${list1.getMovie_name()}</td>
				</tr>
				<tr>
					<td>영화 장르 : ${list1.getMovie_theme()}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script>
		<c:forEach var="k" begin="0" end="4" varStatus="status">
			$("#wordcloud2" + "${status.index}").awesomeCloud({
				"size" : {
					"grid" : 12,
					"factor" : 1.7
				},
				"options" : {
					"color" : "random-dark",
					"rotationRatio" : 0.35
				},
				"font" : "'Times New Roman', Times, serif",
				"shape" : "circle"
			});
		</c:forEach>
	
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-36251023-1' ]);
		_gaq.push([ '_setDomainName', 'jqueryscript.net' ]);
		_gaq.push([ '_trackPageview' ]);
		
		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl': 'http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>
	<p align="center">
		<c:if test="${startPage > bottomLine }">
			<a href="chart_main_WordCloud_Seccess?pageNum=${startPage - bottomLine}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}"  varStatus="stat">
			<a href="chart_main_WordCloud_Seccess?pageNum=${stat.index}">${stat.index}</a>	
		</c:forEach>
		<c:if test="${endPage < pageCount}">
			<a href="chart_main_WordCloud_Seccess?pageNum=${startPage + bottomLine}">[다음]</a>			
		</c:if>
	</p>
</body>
</html>