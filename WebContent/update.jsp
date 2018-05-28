<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@page import="lanqiao.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改学生信息</title>
<style type="text/css">
body {
	background-color: #00FFFF;
}
</style>
</head>
<style>
td {
	text-align: center;
	background-color: #00FFFF;
}
;
</style>
<body>
	<%
		Student stu = new Student();
		stu = (Student) request.getAttribute("stu");
	%>
	<form action="UpdateServlet?oldId=<%=stu.getStuId()%>" method="post">
		<div align="center">
			<table border="1" width="50%">
				<caption>修改学生信息</caption>
				<tr>
					<td>原始学号：<%=stu.getStuId()%></td>
					<td>修改后学号：<%=stu.getStuId()%></td>
				</tr>
				<tr>
					<td>原始姓名：<%=stu.getStuName()%></td>
					<td>修改后姓名：<input type="text" name="newName"
						placeholder="请输入新的姓名"></td>
				</tr>
				<tr>
					<td>原始专业：<%=stu.getMajor()%></td>
					<td>修改后专业：<input type="text" name="newMajor"
						placeholder="请输入新的专业名称"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="提交"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>