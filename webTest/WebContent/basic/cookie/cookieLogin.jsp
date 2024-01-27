<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
label{
  display: inline-block;
  width: 46px;
  height : 30px;
}
#box{
  display: inline-block;
  margin-right: 10px;
}
#input{
  margin-left: 100px;
}
</style>
</head>
<body>
<%
	String id = "";
	String checked = "";
	Cookie[] cookieArr = request.getCookies();
	for(Cookie ck : cookieArr){
		if("id".equals(ck.getName())){
			id = ck.getValue();
			checked = "checked";
		}
	}

%>
<form action="http://localhost/webTest/cookieLoginServlret.do" method="get">
<label>ID :</label>
<input type="text" name="id" placeholder="ID 입력하세요." value="<%=id%>"><br>

<label>PASS :</label>
<input type="password" name="pass" placeholder="PassWord 입력하세요."><br>

<input type="checkbox" id="box" name="cbox" value="id기억하기" <%=checked%>>id 기억하기<br>

<input type="submit" id="input" value="Login">
</form>
</body>
</html>