<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="5;url=/MyOrderPageServlet?operation=2" http-equiv="refresh">
<title>自动刷新</title>
</head>
<body>
	<h2>5秒后自动跳转</h2>
</body>
<c:if test="${!empty msg4 }">
	<script>
		alert("${msg4}");
	</script>
</c:if>
</html>