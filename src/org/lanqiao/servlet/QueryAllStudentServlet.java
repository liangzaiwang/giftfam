package org.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Student;
import org.lanqiao.service.StudentService;

/**
 * Servlet implementation class QueryAllStudentServlet
 */
public class QueryAllStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//查询全部学生信息
		StudentService service = new StudentService();
		List<Student> stus = service.queryAllStudents();
		request.setAttribute("stus", stus);
		request.getRequestDispatcher("showAll.jsp").forward(request, response);
		
		
		
	}

}
