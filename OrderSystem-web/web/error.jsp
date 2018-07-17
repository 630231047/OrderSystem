<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--  设置当前页面是错误页面， 获得错误信息 exception  --%>
<%@page isErrorPage="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="3;url=/LogOffServlet" http-equiv="refresh">
<title>错误页面</title>
</head>
<body>
<!-- 错误友好信息页面 -->
<h4>对不起,系统出错,请确认您选择的身份是否正确！网站将在3秒之后 自动跳转到主页面！</h4>
</body>
</html>