package lanqiao.Servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lanqiao.entity.Student;
import lanqiao.service.StudentService;

/**
 * Servlet implementation class UpdateServlet
 */
//@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String SstuId =request.getParameter("stuId");
		Integer stuId =Integer.parseInt(SstuId);
		Student stu=new Student();
		stu=StudentService.findone(stuId);
		request.setAttribute("stu", stu);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

}
