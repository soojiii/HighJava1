<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
  //Session에 저장된 값 가져오기
  String userId = (String)session.getAttribute("userId");

  if(session.getAttribute("userId") ==null){
%>
<h2>로그인 창</h2>
<form action="<%=request.getContextPath() %>/sessionDBLogin.do" method="post">
<table border="1">
<tr>
	<td>ID :</td>
	<td><input type="text" name="userid" placeholder="ID 입력하세요."></td>
</tr>

<tr>
	<td>PASS :</td>
	<td><input type="password" name="userpass" placeholder="PassWord 입력하세요."></td>
</tr>

<tr>
	<td colspan="2" style="text-align: center;">
	<input type="submit" value="Login">
	</td>
</tr>
</table>
</form>
<%
}else{  //로그인 되었을 때...
%>

<h2> <%=userId %>님 환영합니다.</h2><br><br>
<a href="<%=request.getContextPath()%>/sessionLogout.do">로그아웃</a>

<% 
}
%>

</body>
</html>