<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆界面</title>
<style type="text/css">
body,td,th {
	color: #FFF;
}
body {
	background-color: #00FFFF;
}
</style>
</head>

<body>


<h1 align="center">登陆学生管理系统</h1>
<form action="loginServlet" method="post">
<table width="370" height="79" align="center">
  <tr>
    <td width="82" height="21">用户名:</td>
    <td width="276"><input type="text" name="username"></td>
    </tr>
  <tr>
    <td height="21">密码:</td>
    <td><input type="password" name="password"></td>
    </tr>
  <tr>
    <td height="23"><input type="submit" value="提交"></td>
    </tr>
</table>
</form>

</body>
</html>