<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>
</head>
<body>
	${msg4}
	<form action="/FoodServlet" method="post">
		<input type="hidden" name="foodIndex" value="${param.foodIndex}">
		<input type="hidden" name="operation" value="${param.operation}">
		<table>
			<c:if test="${param.operation==3 }">
				<tr>
					<td>食品名</td>
					<td><input type="text" name="name"
						value="${foods[param.foodIndex-1].name }" /></td>
				</tr>
				<tr>
					<td>价格</td>
					<td><input type="text" name="price"
						value="${foods[param.foodIndex-1].price }" /></td>
				</tr>
			</c:if>
			<tr>
				<td><input type="submit" value="确认" /></td>
				<td><a href="/WEB-INF/view/storerPage.jsp">
						<button type="button">返回</button>
				</a></td>
			</tr>
		</table>
	</form>
</body>
</html>