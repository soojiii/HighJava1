<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Cookie카운트</h2>
<a href="<%=request.getContextPath()%>
/cookieCountServlet.do">Cookie Count 증가 하기</a><br><br>
<a href="<%=request.getContextPath()%>
/cookieCountDelServlet.do">Cookie Count 초기화 하기</a>

</body>
</html>