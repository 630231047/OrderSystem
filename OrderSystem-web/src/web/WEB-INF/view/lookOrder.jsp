<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看我的店铺订单</title>
</head>
<body>
	<h1>${msg1}</h1>
	<c:if test="${empty orderPaidList}">
	<h2>暂时无订单</h2></c:if>
	<form action="/SendServlet" method="post">
		<table>
			<c:forEach items="${orderPaidList}" var="order" varStatus="s">
				<tr>
					<td>订单${s.count }
					<td>食品:</td>
					<td>${order.foodName}&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>数量:</td>
					<td>${order.num}</td>
					<td>单价:</td>
					<td>${order.price}</td>
					<td>顾客名:</td>
					<td>${order.customerName}</td>
					<td>电话号码:</td>
					<td>${order.phone}</td>
					<td>地址:</td>
					<td>${order.address}</td>
					<td><label><input name="isCorrect" type="checkbox"
							value="${order.id}" />选择 </label></td>

				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="配送" /></td>
				<td><a href="/WEB-INF/view/storerPage.jsptorerPage.jsp"><button type="button">返回</button></a></td>
			</tr>
		</table>
	</form>
	<c:if test="${!empty msg6 }">
	<script>
		alert("${msg6}");
	</script>
</c:if>

</body>
</html>