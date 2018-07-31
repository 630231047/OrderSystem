<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填写顾客信息界面</title>
</head>
<body>
	${msg2} ${msg3}
	<form action="/CustomerServlet" method="post">
		<table>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" value="${customer.name}" /></td>
			</tr>

			<tr>
				<td>手机号</td>
				<td><input type="text" name="phone" value="${customer.phone}" /></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email" value="${customer.email}" /></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" name="address"
					value="${customer.address}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="确认" /></td>
				<td><a href="/WEB-INF/view/customerPage.jsp"><button type="button">返回</button></a></td>
	
			</tr>
		</table>
	</form>
</body>
</html>