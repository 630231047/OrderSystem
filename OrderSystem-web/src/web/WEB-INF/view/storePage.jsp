<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>点单界面</title>
<script type="text/javascript">
	function sumbit_sure() {
		var idAndNum = document.getElementsByName('isCorrect');
		sum = 0;
		for (var i = 0; i < idAndNum.length; i++) {
			if (idAndNum[i].checked)
				sum = Number(sum) + Number(idAndNum[i].value.split(",")[1]);
		}
		var gnl = confirm("您需要支付" + sum + "元,是否需要继续支付");
		if (gnl == true) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<h1>购物车</h1>
	<center>
		<h3>
			<c:if test="${empty foods}"> 该店暂时无商品,请返回</c:if>
		</h3>
	</center>

	<!-- 搜索表单 -->
	<form action="/StoreServlet">
		<input type="text" name="search" /> <input type="submit" value="搜索" />
		<input type="hidden" name="storeName" value="${store.store_name}" /> <label><input
			name="orders" type="radio" value="asc" />价格升序 </label> <label><input
			name="orders" type="radio" value="desc" checked />价格降序 </label>
	</form>
	<h2>该店铺信息:名字:${store.store_name}&nbsp;&nbsp;地址:${store.store_address}</h2>
	<a href="/AssessPageServlet">
		<button type="button">店铺评价</button>
	</a>
	<center>
		<c:forEach items="${foods}" var="food" varStatus="s"
			begin="${(pageNos-1)*pageSize}" end="${pageNos*pageSize-1}">
			<td><img
				src="/upload${food.savepath}/${food.uuidname}"
				width="200" height="200"></td>
			<td>商品${s.count+(pageNos-1)*pageSize}:</td>
			<td>${food.name}</td>
			<td>单价:</td>
			<td>${food.price}元</td>
			<td>
				<form action="/OrderServlet" method=post>
					<input type="hidden" name="operation" value="1"> <input
						type="hidden" name="foodIndex"
						value="${s.count+(pageNos-1)*pageSize}"> <input
						type="submit" value="加入购物车">
				</form>
			</td>

			<form action="/OrderServlet" method=post>
				<input type="hidden" name="operation" value="2"> <input
					type="hidden" name="foodIndex"
					value="${s.count+(pageNos-1)*pageSize}"> <input
					type="submit" value="移出购物车">
			</form>

			<form action="/OrderServlet" method=post>
				<input type="hidden" name="operation" value="3"> <input
					type="hidden" name="foodIndex"
					value="${s.count+(pageNos-1)*pageSize}"> <input
					type="submit" value="清空购物车">
			</form>
		</c:forEach>
	</center>
	<center>
		<c:if test="${pageNos>1 }">
			<a href="/StorePageServlet?pageNos=1">首页</a>
			<a href="/StorePageServlet?pageNos=${pageNos-1 }">上一页</a>
		</c:if>
		<c:if test="${pageNos <countPage }">
			<a href="/StorePageServlet?pageNos=${pageNos+1 }">下一页</a>
			<a href="/StorePageServlet?pageNos=${countPage }">末页</a>
		</c:if>
		<form action="/StorePageServlet">
			<h4 align="center">
				共${countPage}页 <input type="text" value="${pageNos}" name="pageNos"
					size="1">页 <input type="submit" value="go">
			</h4>
		</form>
	</center>
	<form action="/PayServlet" method="post"
		onsubmit="return sumbit_sure()">
		<table>
			<c:forEach items="${orders}" var="order">
				<tr>
					<td>食品:</td>
					<td>${order.name}&nbsp;&nbsp;</td>
					<td>数量:</td>
					<td>${order.num}</td>
					<td>单价:</td>
					<td>${order.price}</td>
					<td><input type="hidden" value="${order.num*order.price}"
						name="orderId">
					<td><label><input name="isCorrect" type="checkbox"
							value="${order.id},${order.num*order.price}" />选择 </label></td>

				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="付款" /></td>
				<td><a href="/CustomerPageServlet"><button
							type="button">返回</button></a></td>
				<td>
			<tr>
				<td colspan="7">完成付款后,请到顾客界面查看送餐情况</td>
			</tr>

		</table>
	</form>

	<c:if test="${!empty msg1 }">
		<!-- 提示框 -->
		<script>
			alert("${msg1}");
		</script>
	</c:if>

</body>
</html>