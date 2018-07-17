<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顾客界面</title>
</head>
<body>
	<!-- 根据session中是否存在user对象，判断用户是否登陆 -->
	<c:if test="${!empty(user)}">
		<h1>登陆成功, ${user.username }</h1>
	</c:if>
	<br />
	<c:if test="${empty(customer)&&!empty(user)}">
		<h2>
			<a href="/customerregister.jsp"><button type="button">完善用户信息</button></a>
		</h2>
	</c:if>
	<h2>
		<c:if test="${!empty(customer)}">
			<a href="/customerregister.jsp"><button type="button">更改用户信息</button></a>
		</c:if>
		<a href="/ApplyStoreServlet"><button type="button">我要开店</button></a>
		<a href="/myOrderPage.jsp">
			<button type="button">我的订单</button>
		</a> <a href="/LogOffServlet">
			<button type="button">注销</button>
		</a>
	</h2>
	<!-- 搜索表单 -->
	<center>
		<form action="/CustomerPageServlet">
			<input type="text" name="search" /> <input type="submit" value="搜索" />
			<input type="hidden" name="operation" value="search" />
		</form>
	</center>
	<br />
	<!-- 得到所有商铺名 -->
	<c:forEach items="${storerList}" var="storer"
		begin="${(pageNos-1)*pageSize}" end="${pageNos*pageSize-1}">
		<center>
				<form action="/StoreServlet" method="post">
				<input type="submit" value="${storer.store_name}" name="storeName">
				综合评分:${storer.avg_mark}
				</form>
			
		</center>
	</c:forEach>
	<center>
		<c:if test="${pageNos>1 }">
			<a href="/CustomerPageServlet?pageNos=1">首页</a>
			<a href="/CustomerPageServlet?pageNos=${pageNos-1 }">上一页</a>
		</c:if>
		<c:if test="${pageNos<countPage }">
			<a href="/CustomerPageServlet?pageNos=${pageNos+1 }">下一页</a>
			<a href="/CustomerPageServlet?pageNos=${countPage }">末页</a>
		</c:if>
	</center>
	<form action="/CustomerPageServlet">
		<h4 align="center">
			共${countPage}页 <input type="text" value="${pageNos}" name="pageNos"
				size="1">页 <input type="submit" value="go">
		</h4>
	</form>
	<!-- msg6为请先完善个人信息 -->
	<c:if test="${!empty msg6 }">
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