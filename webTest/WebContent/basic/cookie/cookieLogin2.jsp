<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	//쿠키값(userId)가 저장될 변수 선언
	String cookieUserID = "";

	//checkbox체크 여부를 나타낼 변수 선언
	String chk = "";
	
	//쿠키 정보 가져오기
	Cookie[] cookieArr = request.getCookies();
	if(cookieArr!=null){
		for(Cookie cookie : cookieArr){
			//쿠키이름이 "USERID"인 쿠키의 쿠키값 구하기
			if("USERID".equals(cookie.getName())){
				cookieUserID = cookie.getValue();
				chk = "checked";
				break;
			}
		}
	}

    if(cookieArr!=null){
    	
    }

%>

</head>
<body>

<h2>로그인 창</h2>
<form action="<%=request.getContextPath() %>/cookieLoginServlret2.do" method="post">
<table>
<tr>
	<td>ID :</td>
	<td><input type="text" name="userid" value="<%=cookieUserID %>" placeholder="ID 입력하세요."></td>
</tr>

<tr>
	<td>PASS :</td>
	<td><input type="password" name="userpass" placeholder="PassWord 입력하세요."></td>
</tr>

<tr>
	<td colspan="2">
	<input type="checkbox" value="check" name="chkid" <%=chk %>>ID 기억하기
	</td>
</tr>

<tr>
	<td colspan="2" style="text-align: center;">
	<input type="submit" value="Login">
	</td>
</tr>
</table>
</form>
</body>
</html>