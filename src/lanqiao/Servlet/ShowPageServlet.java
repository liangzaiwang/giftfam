package lanqiao.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableInterceptor.INACTIVE;

import lanqiao.entity.Page;
import lanqiao.entity.Student;
import lanqiao.service.StudentService;

/**
 * Servlet implementation class ShowPageServlet
 */
//@WebServlet("/ShowPageServlet")
public class ShowPageServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int currentPage;//
		Page page=new Page();
		int totleCount=StudentService.findCount();
		String Ssize=request.getParameter("size");
		int size;
		if(Ssize==null){
			size=5;
		}else{
			size=Integer.parseInt(Ssize);
		}
		page.setPageSize(size);
		page.setTotleCount(totleCount);
		page.setTotlePage();
		String ScurrentPage=request.getParameter("currentPage");
		if(ScurrentPage==null){
			currentPage=1;
		}
		else{
			currentPage=Integer.parseInt(ScurrentPage);
			if(currentPage<=0){
				currentPage=1;
			}else if(currentPage>page.getTotlePage()){
				currentPage=page.getTotlePage();
			}
		}
		page.setCurrentPage(currentPage);
		request.setAttribute("page", page);
		request.getRequestDispatcher("showPage.jsp").forward(request, response);
	}

}
