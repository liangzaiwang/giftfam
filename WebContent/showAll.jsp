<%-- <%@page import="org.lanqiao.entity.Student"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body back-groud="#00FFFF">
<% List<Student> stus =(List<Student>) request.getAttribute("stus");
String successmsg = (String)request.getAttribute("successmsg");
if(successmsg != null){
	out.print("<h2>删除成功</h2>");
}
String errormsg = (String)request.getAttribute("errormsg");
if(errormsg != null){
	out.print("<h2>删除失败</h2>");
}
%>
<table border="1" width="80%">
<caption>学生信息表</caption>
<tr>
	<th>学号</th><th>姓名</th><th>年龄</th><th>年级</th><th>操作</th>
</tr>
<%
if( stus != null){
	for(int i =0;i<stus.size();i++){
		out.print("<tr>");
		out.print("<td>"+stus.get(i).getStuNo()+"</td>");
		out.print("<td>"+stus.get(i).getStuName()+"</td>");
		out.print("<td>"+stus.get(i).getStuAge()+"</td>");
		out.print("<td>"+stus.get(i).getgName()+"</td>");
		out.print("<td><a href='DelByStuNoServlet?stuNo="+stus.get(i).getStuNo()+"'>删除</a><a href='show.jsp?stuNo="+stus.get(i).getStuNo()+"'>修改</a></td>");
		out.print("</tr>");
	}
}

%>
</table>
<a href="addStudent.jsp">增加学生</a>
</body>
</html> --%>