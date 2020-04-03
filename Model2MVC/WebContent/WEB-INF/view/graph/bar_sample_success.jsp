<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><html>
<head>
<title>barChart</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/Chart.min_bar.js"></script>
</head>
<body>
	<br>
	<p>
		<br>
	<p>
	<div style="width: 100%" , align="center">
		<canvas id="canvas" height="550" width="800"></canvas>
	</div>
	<p>
		<script>
		var randomScalingFactor = function(){ return Math.round(Math.random()*100)};
		
		var months = [${json.toNameString()}]
		var barChart = null;
		var barChartData = {
			labels : [${json.toNameString()}],
			datasets : [
				{
					 fillColor : "#FFCC99",
		               strokeColor : "#ff99cc",
		               highlightFill: "#ffaeaa",
		               highlightStroke: "rgba(220,220,220,1)",
					data : [${json.toValueString()}]   
				}
			]

		};

		$(function() {
			var ctx = document.getElementById("canvas").getContext("2d");
			barChart = new Chart(ctx).Bar(barChartData, {
				scaleBeginAtZero : false,
				scaleShowGridLines : true,
				scaleGridLineColor : "#ff99cc",
				scaleGridLineWidth : 1,
				barShowStroke : false,
				barStrokeWidth : 2,
				barValueSpacing : 5,
				barDatasetSpacing : 1,
				onAnimationProgress: function() {
					console.log("onAnimationProgress");
				},
				onAnimationComplete: function() {
					console.log("onAnimationComplete");
				}
			});
		});

		$("canvas").on("click", function(e) {
			var activeBars = barChart.getBarsAtEvent(e);
			console.log(activeBars);

			for(var i in activeBars) {
				console.log(activeBars[i].value);
			}
		});

	</script>
</body>
</html>