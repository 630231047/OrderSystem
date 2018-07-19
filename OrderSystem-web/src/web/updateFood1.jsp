<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
</head>
<body>
	<h1>添加商品</h1>
	<form action="/UploadStorer" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>食品名</td>
				<td><input type="text" name="name" value="" /></td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input type="text" name="price" value="" /></td>
			</tr>
			<tr>
				<td>上传图片</td>
				<td><input type="file" name="upload" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="上传" /></td>
				<td><a href="/storerPage.jsp"><button
							type="button">返回</button></a></td>
			</tr>
		</table>
	</form>
</body>
</html>