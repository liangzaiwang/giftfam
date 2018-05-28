package lanqiao.Servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lanqiao.entity.Student;
import lanqiao.service.StudentService;


//@WebServlet("/SelectByName")
public class SelectByName extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("selectName");
		LinkedList<Student> list=new LinkedList<Student>();
		list=StudentService.findoneByName(name);
		request.setAttribute("list", list);
		request.getRequestDispatcher("selectByName.jsp").forward(request, response);
	}

}
