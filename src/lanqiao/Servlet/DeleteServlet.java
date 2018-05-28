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
 * Servlet implementation class DeleteServlet
 */
//@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Sstuid=request.getParameter("stuId");
		Integer stuId=Integer.parseInt(Sstuid);
		Boolean flg= StudentService.delete(stuId);
		if(flg){
			request.getRequestDispatcher("ShowPageServlet").forward(request, response);
		}else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out= response.getWriter();
			out.println("删除失败....");
			out.close();
		}
	}

}
