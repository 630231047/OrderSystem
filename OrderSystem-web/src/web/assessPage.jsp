<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>该店评价</title>
</head>
<body>
	<h1>该店评价</h1>
	<h2>该店铺信息:名字:${store.store_name}&nbsp;&nbsp;地址:${store.store_address}</h2>
	<center>
		<c:forEach items="${assessList}" var="assess" varStatus="s"
			begin="${(pageNos-1)*pageSize}" end="${pageNos*pageSize-1}">
			<td>评价${s.count+(pageNos-1)*pageSize}:</td>
			<td>评分(1-5分):</td>
			<td>${assess.mark}分</td>
			<br />
			<td>描述文字:</td>
			<td>${assess.words}</td>
			<br />
			<td><img
				src="/uploadAccess${assess.savepath}/${assess.uuidname}"
				width="200" height="200"></td>
			<br />
		</c:forEach>
	</center>
	<center>
		<c:if test="${pageNos>1 }">
			<a href="/AssessPageServlet?pageNos=1">首页</a>
			<a href="/AssessPageServlet?pageNos=${pageNos-1 }">上一页</a>
		</c:if>
		<c:if test="${pageNos<countPage }">
			<a href="/AssessPageServlet?pageNos=${pageNos+1 }">下一页</a>
			<a href="/AssessPageServlet?pageNos=${countPage }">末页</a>
		</c:if>
		<form action="/AssessPageServlet">
			<h4 align="center">
				共${countPage}页 <input type="text" value="${pageNos}" name="pageNos"
					size="1">页 <input type="submit" value="go">
				<a href="/StorePageServlet"><button type="button">返回</button></a>
			</h4>
		</form>
	</center>
</body>
</html>