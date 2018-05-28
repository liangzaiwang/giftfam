<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color:#00FFFF;
}
</style>
</head>
<style>
td{text-align: center;};
</style>
<body>
<h3 align="center">添加学生信息</h3>
<form action="AddServlet" method="post">
<table align="center">
<tr>
<td>请输入学生编号：</td>
<td><input type="text" name="stuid"></td>
</tr>
<tr>
<td>请输入学生姓名：</td>
<td><input type="text" name="stuname"></td>
</tr>
<tr>
<td>请输入学生专业：</td>
<td><input type="text" name="major"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="提交"></td>
</tr>
</table>
</form>
</body>
</html>