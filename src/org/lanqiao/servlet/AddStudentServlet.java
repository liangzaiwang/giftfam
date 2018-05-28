package org.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Student;
import org.lanqiao.service.StudentService;
public class AddStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		String stuName = request.getParameter("stuName");
		int stuAge = Integer.parseInt(request.getParameter("stuAge"));
		String gName =request.getParameter("gName");
		//将信息封装到学生信息中
		Student stu = new Student();
		stu.setgName(gName);
		stu.setStuAge(stuAge);
		stu.setStuName(stuName);
		stu.setStuNo(stuNo);
		//增加
		StudentService service = new StudentService();
		boolean flag = service.addStudent(stu);
		if(flag) {
			System.out.println("增加成功");
			request.setAttribute("stu", stu);
			request.getRequestDispatcher("success.jsp").forward(request, response);
			
		}else {
			System.out.println("增加失败");
			response.sendRedirect("addStudent.jsp");
		}
		
		
	}

}
