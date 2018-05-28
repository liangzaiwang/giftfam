<%@page import="lanqiao.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: #00FFFF;
}
</style>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
Student stu=(Student) request.getAttribute("student");
%>
<h3 align="center">添加成功...</h3>
<div align="center">学生编号：<%=stu.getStuId() %><br>
  学生姓名：<%=stu.getStuName() %><br>
  学生专业：<%=stu.getMajor() %><br>
  <a href="ShowPageServlet">返回上一级</a>
</div>
</body>
</html>