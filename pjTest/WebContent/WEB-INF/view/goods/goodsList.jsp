<%@page import="kr.or.ddit.pj.goods.vo.GoodsImgVo"%>
<%@page import="kr.or.ddit.pj.goods.vo.GoodsVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  table, tr, td {borcer : 1px solid blue;}
  td {padding : 5px;}
</style>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<%
	List<GoodsVo> goodsList = (List<GoodsVo>)request.getAttribute("goodsList");
%>
<h2>상품 목록</h2>
<table border="1">
	<thead>
		<tr>
			<th>상품명</th>
			<th>상품가격</th>
			<th>상품이미지</th>
			<th>잔여수량</th>
		</tr>
	</thead>
	<tbody>
<%
	for(GoodsVo GoodsVo : goodsList){
%>	
	<tr>
		<td><%=GoodsVo.getGoods_name() %></td>
		<td><%=GoodsVo.getGoods_price() %></td>
		<td><%=GoodsVo.getGoods_qty() %></td>
	</tr>
<% 
	}
%>
	</tbody>

</table>
</body>
</html>