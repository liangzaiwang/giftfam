package org.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

		response.setContentType("text/html;charset=utf-8");
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		
		User user =new User();
		user.setUsername(uname);
		user.setPassword(upwd);
		
		UserService service = new UserService();
		//通过username 去查找user对象
		User user2 = service.findUserByUsername(uname);
		if(user2 != null) {
			if(user2.getPassword().equals(upwd)) {
				//登录成功
				//显示全部的学生信息
				request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);
			}
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
