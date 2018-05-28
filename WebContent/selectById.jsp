<%@page import="lanqiao.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
td{text-align: center;};
</style>
<body bgcolor="#00FFFF">
<%
Student stu=new Student();
stu=(Student)request.getAttribute("stu");
%>
<%
if(stu.getStuId()==0){
	out.print("没有查询到学生信息.....");
}else{
	%>
	<h3 align="center">查询结果</h3>
	<table border="1" width="50%" align="center" bgcolor="#FFF">
<tr>
        <td >学号</td>
        <td >姓名</td>
        <td >专业</td>
        <td colspan="2" >操作</td>
</tr>
	<% %>
		<tr>
		<td><%=stu.getStuId() %></td>
		<td><%=stu.getStuName() %></td>
		<td><%=stu.getMajor() %></td>
		<td><a href="DeleteServlet?stuId=<%=stu.getStuId()%>">删除</a></td>
		<td><a href="SelectServlet?stuId=<%=stu.getStuId()%>">修改</a></td>
		</tr>
		<%
	}
%>
</table>

</body>
</html>