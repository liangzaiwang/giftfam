package lanqiao.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lanqiao.service.StudentService;

/**
 * Servlet implementation class UpdateServlet
 */
//@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Sid=request.getParameter("oldId");
		Integer id=Integer.parseInt(Sid);
		String newName=request.getParameter("newName");
		String newMajor=request.getParameter("newMajor");
		boolean flg=StudentService.update(id,newName, newMajor);
		if(flg){
			request.getRequestDispatcher("ShowPageServlet").forward(request, response);
		}else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out= response.getWriter();
			out.println("更新失败....");
		}
	}

}
