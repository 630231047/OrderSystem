<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单</title>
</head>
<body>
	<a href="/MyOrderPageServlet?operation=1">未送达</a>
	<a href="/MyOrderPageServlet?operation=2">未评价</a>
	<a href="/MyOrderPageServlet?operation=3">已评价</a>
		<a href="/CustomerPageServlet"><button type="button">返回</button></a>
	<c:if test="${!empty msg3 }">
		<!-- 提示框 -->
		<script>
			alert("${msg3}");
		</script>
	</c:if>
</body>
</html>