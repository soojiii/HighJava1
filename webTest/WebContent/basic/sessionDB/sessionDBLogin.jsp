<%@page import="kr.or.ddit.sessionlogin.vo.MemberVO"%>
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

	//JSP문서에서 세션은 'session'이라는 이르미으로 이미 저장되어 있다.
	
  //Session에 저장된 값 가져오기
  MemberVO LoginMember = (MemberVO)session.getAttribute("LoginMember");
%>
<%
  if(LoginMember==null){  //로그인이 안되었을 떄...
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

<h2> <%=LoginMember.getMem_name() %>님 환영합니다.</h2><br><br>
<a href="<%=request.getContextPath()%>/sessionDBLogout.do">로그아웃</a>

<% 
}
%>
</body>
</html>