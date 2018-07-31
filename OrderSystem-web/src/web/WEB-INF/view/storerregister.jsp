<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商家信息修改界面</title>
</head>
<body>
		${msg2} 	${msg3}
	<form action="/StorerServlet" method="post">
		<table>
			<tr>
				<td>店铺名</td>
				<td><input type="text" name="store_name" value="${storer.store_name}"  /></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" name="store_address" value="${storer.store_address}"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="确认" /></td>
				<td><a href="/WEB-INF/view/storerPage.jsp"><button type="button">返回</button></a></td>
			</tr>
		</table>
	</form>
</body>
</html>