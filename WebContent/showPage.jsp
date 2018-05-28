<%@page import="lanqiao.entity.User"%>
<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@page import="lanqiao.entity.Page"%>
<%@page import="lanqiao.service.StudentService"%>
<%@page import="lanqiao.entity.Student"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style>
td {
	text-align: center;
	background: #00FFFF;
}
h1 {
	color: #FFF;
}
h3{
color:#CFF;
}
</style>
<body bgcolor="#00FFFF">
	<%
		LinkedList<Student> list = new LinkedList<Student>();
		Page p = (Page) request.getAttribute("page");
		User user=new User();
	    user=(User)session.getAttribute("user");
		if(user==null){
			out.print("<h1>请先登陆...</h1>");
		}else{
		int currentPage = p.getCurrentPage();
		Integer pageSize = new Integer(p.getPageSize());
		list = StudentService.findByPage(currentPage, pageSize);
		
	%>
	<div align="center">
	<h1 align="center">欢迎进入</h1>
		<table border="1" width="51%">
			<caption>学生信息表</caption>
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>专业</td>
				<td colspan="2">操作</td>
			</tr>
			<%
				for (int i = 0; i < list.size(); i++) {
			%>
			<%-- <tr>
				<td><%=list.get(i).getStuId()%></td>
				<td><%=list.get(i).getStuName()%></td>
				<td><%=list.get(i).getMajor()%></td>
				<td><a href="DeleteServlet?stuId=<%=list.get(i).getStuId()%>">删除</a></td>
				<td><a href="SelectServlet?stuId=<%=list.get(i).getStuId()%>">修改</a></td>
			</tr> --%>
			
			${requestScope.student}<br/>
			${requestScope.student.Stuid}
			<%
				}
			%>
			<tr>
				<td colspan="3" bgcolor="#999999">当前页面大小：<%=p.getPageSize()%>&nbsp;&nbsp;&nbsp;<%=p.getCurrentPage()%>/<%=p.getTotlePage()%>
					<a
					href="ShowPageServlet?currentPage=<%=1%>&size=<%=p.getPageSize()%>">首页</a>&nbsp;
					<a
					href="ShowPageServlet?currentPage=<%=p.getCurrentPage() - 1%>&size=<%=p.getPageSize()%>">上一页</a>&nbsp;
					<a
					href="ShowPageServlet?currentPage=<%=p.getCurrentPage() + 1%>&size=<%=p.getPageSize()%>">下一页</a>&nbsp;
					<a
					href="ShowPageServlet?currentPage=<%=p.getTotlePage()%>&size=<%=p.getPageSize()%>">尾页</a>
				</td>
				<td colspan="2" bgcolor="#999999">
					<form action="ShowPageServlet" method="post">
						请选择页面大小： <select name="size">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
						</select> <input type="submit" value="提交">
					</form>
				</td>
			</tr>
			<tr>
				<td height="25" colspan="5">
					<form action="add.jsp">
						<div align="center">
							<input type="submit" value="添加学生信息">
						</div>
					</form>
				</td>
			</tr>
		</table>
	</div>
	<div align="left">
		<h3>查找学生信息:</h3>
		<table>
			<tr>
				<td><form action="SelectByName">
						根据姓名查找：<input type="text" name="selectName"> <input
							type="submit" value="提交">
					</form></td>
			</tr>
			<tr>
				<td><form action="SelectById">
						根据学号查找：<input type="text" name="selectId"> <input
							type="submit" value="提交">
					</form></td>
			</tr>
		</table>
	</div>
	<%} %>
</body>
</html>