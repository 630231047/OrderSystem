<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>未送达的订单信息</title>
</head>
<body>
				<a href="/WEB-INF/view/myOrderPage.jsp"><button type="button">返回</button></a>
	<c:forEach items="${paidOrders}" var="order"
		begin="${(pageNos-1)*pageSize}" end="${pageNos*pageSize-1}">
		<center>
			<table>
				<tr>
					<td>商家名:</td>
					<td>${order.store_name}</td>
					<td>商品名:</td>
					<td>${order.name}</td>
					<td>状态:</td>
					<td>${order.status}</td>
					<td>数量:</td>
					<td>${order.num}</td>
					<td>单价:</td>
					<td>${order.price}元</td>
					<td>时间:</td>
					<td>${order.date}</td>
				</tr>
			</table>

		</center>
	</c:forEach>

	<center>
		<c:if test="${pageNos>1 }">
			<a href="/MyOrderPageServlet?operation=1&pageNos=1">首页</a>
			<a href="/MyOrderPageServlet?operation=1&pageNos=${pageNos-1 }">上一页</a>
		</c:if>
		<c:if test="${pageNos<countPage }">
			<a href="/MyOrderPageServlet?operation=1&pageNos=${pageNos+1 }">下一页</a>
			<a href="/MyOrderPageServlet?operation=1&pageNos=${countPage }">末页</a>
		</c:if>
	</center>
	<form action="/MyOrderPageServlet">
		<h4 align="center">
		<input type="hidden" name="operation" value="1">
			共${countPage}页 <input type="text" value="${pageNos}" name="pageNos"
				size="1">页 <input type="submit" value="go">
		</h4>
	</form>
</body>
</html>