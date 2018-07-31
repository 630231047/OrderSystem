<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
<script type="text/javascript">
	function change() {
		//切换验证码
		document.getElementById("myimg").src = "/checkcode?"
				+ new Date().getTime();
	}
	function CheckForm() 
	{ 
	if (document.regForm.username.value.length == 0&&document.regForm.password.value.length == 0) { 
	alert("注册信息不能为空!"); 
	return false; 
	} 
	return true; 
	alert("注册信息不能为空!"); 
	} 
</script>
</head>
<body>

	<h1>注册页面</h1>
	<h3 style="color: red;">${requestScope.msg }</h3>
	<!-- 用户注册 -->
	<form action="/register" method="post" onsubmit="return CheckForm()" name="regForm">
		<table>
			<!-- 文本输入框 -->
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<!-- 密码框 -->
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<!-- 确认密码框 -->
			<tr>
				<td>确认密码</td>
				<td><input type="password" name="rePassword" /></td>
			</tr>

			<!-- 确认验证码-->
			<tr>
				<td>请输入验证码</td>
				<td><input type="text" name="checkcode" /></td>
			</tr>
			<tr>
				<td><img id="myimg" src="/checkcode"
					style="cursor: pointer;" onclick="change();" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="确认" /></td>
				<td><a href="/WEB-INF/view/login.jsp"><button type="button">返回</button></a></td>
			</tr>
		</table>
	</form>
</body>
</html>