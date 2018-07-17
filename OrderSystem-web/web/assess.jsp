<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评价</title>
</head>
<body>
	<h1>评价</h1>
	<form action="/UploadAssess" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>评分</td>
				<td><label><input name="mark" type="radio" value="1" />1</label>
					<label><input name="mark" type="radio" value="2" />2</label> <label><input
						name="mark" type="radio" value="3" />3</label> <label><input
						name="mark" type="radio" value="4" />4</label> <label><input
						name="mark" type="radio" value="5" />5</label></td>
			</tr>
			<tr>
				<td>评语</td>
				<td colspan="3"><textarea name="words" cols="30" rows="6"></textarea></td>
			</tr>
			<tr>
				<td>上传图片</td>
				<td><input type="file" name="upload" /></td>
			</tr>
			<tr>
				<td><input type="hidden" value="${param.orderId }"
					name="orderId">
				<td><input type="hidden" value="${param.storeId }"
					name="storeId">
				<td><input type="submit" value="上传" /></td>
				<td><a href="/sentPage.jsp"><button
							type="button">返回</button></a></td>
			</tr>
		</table>
	</form>

</body>
</html>