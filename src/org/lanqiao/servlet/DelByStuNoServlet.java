package org.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.service.StudentService;

public class DelByStuNoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	int stuNo = Integer.parseInt(request.getParameter("stuNo"));
	StudentService service = new StudentService();
	boolean flag = service.deleteStuByNo(stuNo);
	
	if(flag) {
		request.setAttribute("successmsg", "删除成功");
	}else {
		request.setAttribute("errormsg", "删除失败");
	}
	
	request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);
	
	
	}

}
