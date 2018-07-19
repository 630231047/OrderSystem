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
					<td>${order[1]}&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>数量:</td>
					<td>${order[3]}</td>
					<td>单价:</td>
					<td>${order[4]}</td>
					<td>顾客名:</td>
					<td>${order[5]}</td>
					<td>电话号码:</td>
					<td>${order[6]}</td>
					<td>地址:</td>
					<td>${order[7]}</td>
					<td><label><input name="isCorrect" type="checkbox"
							value="${order[0]}" />选择 </label></td>

				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="配送" /></td>
				<td><a href="/storerPage.jsp"><button type="button">返回</button></a></td>
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