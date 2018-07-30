<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员界面</title>
</head>
<body>
	<h1>欢迎您，管理员!</h1>
				<a href="/LogOffServlet"><button type="button">注销</button></a>
	<br />
	<h3>申请商家的用户名单</h3>
	<form action="/JudgeServlet" method="post">
		<table>
			<c:forEach items="${applyStores}" var="i" varStatus="s">
				<tr>
					<td>用户id:${i.user_id }</td>
					<td>店铺名:${i.store_name }</td>
					<td>地址:${i.store_address}</td>
					<td><label><input name="isCorrect" type="checkbox"
									  value="${i.user_id}" />选择 </label></td>

				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" name="submit" value="allow" /></td>		
				<td><input type="submit" name="submit" value="reject" /></td>		
			</tr>
			</table>
	</form>	
	<c:if test="${!empty msg6 }">
		<!-- 提示框 -->
		<script>
			alert("${msg6}");
		</script>
	</c:if>	
	<c:if test="${!empty msgPerError }">
		<!-- 提示框 -->
		<script>
			alert("${msgPerError}");
		</script>
	</c:if>
</body>
</html>