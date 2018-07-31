<%--
  Created by IntelliJ IDEA.
  User: 63023
  Date: 2018/7/31
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆界面</title>
    <link href="${pageContext.request.contextPath }/css/logincss.css?v=<%= System.currentTimeMillis()%>" rel="stylesheet"/>
    <script type="text/javascript">
        function change() {
            //切换验证码
            document.getElementById("myimg").src = "/checkcode?"
                + new Date().getTime();
        }
    </script>
</head>
<body>
<div id="content">
    <div id="login">
        <center>
        <h1>登陆页面</h1>
        <form action="/login" method="post">
            <table>
                <tr>
                    <td>用户名</td>
                </tr>
                <tr>
                    <td><input type="text" name="username" value="${username}" /></td>
                </tr>
                <tr>
                    <td>密码</td>
                </tr>
                <tr>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td>请输入验证码(区分大小写)</td>
                </tr>
                <tr>
                    <td><input type="text" name="checkcode" /></td>
                </tr>
                <tr>
                    <td colspan="1"><img id="myimg" src="/checkcode"
                                         style="cursor: pointer;" onclick="change();" /><br /></td>
                </tr>
                <tr>
                    <td><label><input name="roles" type="radio"
                                      value="customer" checked />用户 </label> <label><input
                            name="roles" type="radio" value="storer" />商家 </label> <label><input
                            name="roles" type="radio" value="admin" />管理员 </label></td>
                </tr>
            </table>
            <input type="submit" value="登陆" />
            <a href="/WEB-INF/view/register.jsp/register.jsp">
                <button type="button">注册</button>
            </a>

        </form>
        </center>
    </div>
</div>
<!-- 验证码错误 -->
<!-- 该用户无此角色 -->
<!-- 密码输入错误 -->
<!-- 用户名不存在 -->
<!-- 已注销 -->
<c:if test="${!empty msg }">
    <!-- 提示框 -->
    <script>
        alert("${msg}");
    </script>
</c:if>
</body>
</html>