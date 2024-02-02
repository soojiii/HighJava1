<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/js/jquery-3.7.1.min.js"></script>
<script>
$(function(){
	$('#btn').on("click", function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/lprodList.do",
			type : "post",
			// data : 전송할 데이터, //전송할 데이터가 없으면 생략 가능
			success : function(resData){
				let htmlCode = "<table border=1>";
				htmlCode += "<tr><td>LPROD_ID</td>";
				htmlCode += "<td>LPROD_GU</td>";
				htmlCode += "<td>LPROD_NM</td></tr>";

				$.each(resData, function(i, v){
					htmlCode += "<tr><td>"+v.lprod_id+"</td>";
					htmlCode += "<td>"+v.lprod_gu+"</td>";
					htmlCode += "<td>"+v.lprod_nm+"</td></tr>";
				});

				htmlCode += "</table>"
				
				$('#result').html(htmlCode);
			},
			error : function(xhr){
				alert("오류 : " + xhr.status);
			},
			dataType : "json"
		});
	});
	
	$("#btn2").on("click", function(){
		location.href="<%=request.getContextPath()%>/lprodList2.do";
	});
	
});
</script>
</head>
<body>

	<input type="button" id="btn" value="Lprod자료 가져오기(Ajax)">
	<input type="button" id="btn2" value="Lprod자료 가져오기(non Ajax)">

	<h2>Lprod 자료 목록</h2>
	<div id ="result"></div>

</body>
</html>