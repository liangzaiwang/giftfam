package lanqiao.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lanqiao.entity.Student;
import lanqiao.service.StudentService;


//@WebServlet("/SelectById")
public class SelectById extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("selectId"));
		Student stu=new Student();
		stu=StudentService.findone(id);
		request.setAttribute("stu", stu);
		request.getRequestDispatcher("selectById.jsp").forward(request, response);
	}
}
