<%@page import="vo.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
</head>
<body>

<%
   List<BoardVO> boardList = (List<BoardVO>)request.getAttribute("boardList");
   
%>

<h2>게시물 목록 보기</h2>
<table border="1">
	<tr>
	  <td colspan="5" style="text-align:right;">
	     <input type="button" id="addBtn" value="글작성">
	  </td>
	</tr>
	
	<tr>
	  <th>게시판번호</th>
	  <th>ID</th>
	  <th>게시판 제목</th>
	  <th>게시판 내용</th>
	  <th>날짜</th>
	  <th>조회수</th>
	  <th>삭제여부</th>	
	</tr>

    <%
    	for(BoardVO bodvo : boardList){
    %> 
      <tr>
        <td><%=bodvo.getBoard_no()%></td>
        <td><%=bodvo.getUser_id()%></td>
        <td><%=bodvo.getBoard_title()%></td>
        <td><%=bodvo.getBoard_content()%></td>
        <td><%=bodvo.getBoard_date()%></td>
        <td><%=bodvo.getBoard_hits()%></td>
        <td><%=bodvo.getBoard_del()%></td>
      </tr>
<%
    	}
%>

</table>
</body>
</html>