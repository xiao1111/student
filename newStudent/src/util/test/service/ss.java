package util.test.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.test.bean.buycar;
import util.test.bean.user;
import util.test.factory.DAOFactory;

public class ss extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ss() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");	
		buycar b= new buycar();
			b.setBookname(request.getParameter("bookname"));
			String c=DAOFactory.getBuycarDAOImpl().ss(b);
			if(c.equals("0")){
				response.sendRedirect("html/t4.html");
			}else{
				response.sendRedirect("html/book.jsp?book_id="+c);
			}
	}
			

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
