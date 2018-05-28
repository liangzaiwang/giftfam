<%@page import="org.lanqiao.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>新增加学生信息</h2>
<%
Student stu = (Student)request.getAttribute("stu");
%>
学号：<%=stu.getStuNo() %>
姓名：<%=stu.getStuName() %>
年龄：<%=stu.getStuAge() %>
年级：<%=stu.getgName() %>

</body>
</html>