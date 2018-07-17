<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申请商家</title>
</head>
<body>
	<c:if test="${!empty msgStatus}">
		<script>
			alert("${msgStatus}");
		</script>
		<td><a href="/customerPage.jsp"><button
					type="button">返回</button></a></td>

	</c:if>
	<center>
		<c:if test="${empty msgStatus}">
			<h3>请填写以下信息,由管理员审批通过后，方可拥有商铺</h3>
			<form action="/SubmitApplyServlet" method="post">
				<table>
					<tr>
						<td>店铺名</td>
						<td><input type="text" name="store_name" /></td>
					</tr>
					<tr>
						<td>地址</td>
						<td><input type="text" name="store_address" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="确认" /></td>
						<td><a href="/customerPage.jsp"><button
									type="button">返回</button></a></td>

					</tr>
				</table>
			</form>
		</c:if>
	</center>
	${msg2}
</body>
</html>