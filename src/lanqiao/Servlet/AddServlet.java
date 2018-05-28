package lanqiao.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lanqiao.entity.Student;
import lanqiao.service.StudentService;

//@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out= response.getWriter();
		String SstuId=request.getParameter("stuid");
		String stuName=request.getParameter("stuname");
		String major=request.getParameter("major");
		if(SstuId.equals("")||stuName.equals("")||major.equals("")){
			out.print("<h3>添加失败<h3>");
			out.close();
		}
		Integer stuId=Integer.parseInt(SstuId);
		Student student=new Student();
		student.setStuId(stuId);
		student.setStuName(stuName);
		student.setMajor(major);
		boolean flg= StudentService.add(student);
		if(flg){
			request.setAttribute("student", student);
			request.getRequestDispatcher("addResult.jsp").forward(request, response);
		}else{
			out.print("<h3>学生信息已经存在....<h3>");
			out.close();
		}
		
	}

}
