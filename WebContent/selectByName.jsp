<%@page import="lanqiao.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#39C">
<%
LinkedList<Student> list=new LinkedList<Student>();
list=(LinkedList<Student>)request.getAttribute("list");
%>

<%
if(list.size()==0){
	out.print("没有查询到学生信息...");
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
	<% 
	for(int i=0;i<list.size();i++){
		%>
		<tr>
		<td><%=list.get(i).getStuId() %></td>
		<td><%=list.get(i).getStuName() %></td>
		<td><%=list.get(i).getMajor() %></td>
		<td><a href="DeleteServlet?stuId=<%=list.get(i).getStuId()%>">删除</a></td>
		<td><a href="SelectServlet?stuId=<%=list.get(i).getStuId()%>">修改</a></td>
		</tr>
		<%
	}
}
%>
</table>


</body>
</html>