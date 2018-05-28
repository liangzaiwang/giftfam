package lanqiao.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lanqiao.entity.User;
import lanqiao.service.UserService;

/**
 * Servlet implementation class loginServlet
 */
//@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=new User();
		user=UserService.findManager(username);
		HttpSession session=request.getSession();
		session.setAttribute("user", user);
		if(user.getUsername()!=null){
			if(user.getPassword().equals(password)){
				request.getRequestDispatcher("ShowPageServlet").forward(request, response);
			}else{
				PrintWriter out= response.getWriter(); 
				out.println("<h1>密码不正确....</h1>");
			}
			
		}else{
			PrintWriter out= response.getWriter();
			out.println("<h1>该用户不存在.....</h1>");
		}
		
		
	}

}
