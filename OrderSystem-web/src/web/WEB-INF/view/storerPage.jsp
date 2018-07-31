<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的商铺</title>
</head>
<body>
	<h1>店铺名:${storer.store_name }</h1>
	<h2>
		<c:if test="${empty(storer)&&!empty(user)}">
			<a href="/WEB-INF/view/storerregister.jsprregister.jsp">
				<button type="button">完善商铺信息</button>
			</a>
		</c:if>
		<c:if test="${!empty(storer)}">
			<a href="/WEB-INF/view/storerregister.jsprregister.jsp">
				<button type="button">更改商铺信息</button>
			</a>
		</c:if>
		&nbsp; <a href="/WEB-INF/view/updateFood1.jspdateFood1.jsp">
			<button type="button">增加商品</button>
		</a> &nbsp;<a href="/LookCusOrderServlet"><button
				type="button">查看已付款的订单</button></a> &nbsp; <a
			href="/LogOffServlet">
			<button type="button">注销</button>
		</a>
	</h2>

	<center>
		<c:forEach items="${foods}" var="food" varStatus="s"
			begin="${(pageNos-1)*pageSize}" end="${pageNos*pageSize-1}">
			<img src="/upload${food.savepath}/${food.uuidname}"
				width="200" height="200"> ${s.count+(pageNos-1)*pageSize}
			<tr>
				<td>商品名${s.count+(pageNos-1)*pageSize}:</td>
				<td>${food.name}</td>
				<td>单价:</td>
				<td>${food.price}元</td>
				<td><form action="/FoodServlet" method="post">
						<input type="hidden" name="foodIndex"
							value="${s.count+(pageNos-1)*pageSize}"> <input
							type="hidden" name="operation" value="2"> <input
							type="submit" value="删除商品">
					</form></td>
				<td><form action="/WEB-INF/view/updateFood.jsppdateFood.jsp" method="post">
						<input type="hidden" name="foodIndex"
							value="${s.count+(pageNos-1)*pageSize}"> <input
							type="hidden" name="operation" value="3"> <input
							type="submit" value="修改商品">
					</form></td>
			</tr>

		</c:forEach>
	</center>
	<center>
		<c:if test="${pageNos>1 }">
			<a href="/StorerPageServlet?pageNos=1">首页</a>
			<a href="/StorerPageServlet?pageNos=${pageNos-1 }">上一页</a>
		</c:if>
		<c:if test="${pageNos <countPage }">
			<a href="/StorerPageServlet?pageNos=${pageNos+1 }">下一页</a>
			<a href="/StorerPageServlet?pageNos=${countPage }">末页</a>
		</c:if>
	</center>
	<form action="/StorerPageServlet">
		<h4 align="center">
			共${countPage}页 <input type="text" value="${pageNos}" name="pageNos"
				size="1">页 <input type="submit" value="go">
		</h4>
	</form>

	${msg5}
	<!-- 如果商品数据为空 -->
	<c:if test="${!empty msgSize }">
		<!-- 提示框 -->
		<script>
			alert("${msgSize}");
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