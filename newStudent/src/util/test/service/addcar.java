package util.test.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.test.bean.buycar;
import util.test.bean.user;
import util.test.factory.DAOFactory;

public class addcar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public addcar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");	
		buycar a = new buycar();
			a.setUsername(request.getParameter("username"));
			a.setBook_id(request.getParameter("book_id"));
			a.setBuy_count(request.getParameter("buy_count"));
			DAOFactory.getBuycarDAOImpl().add(a);
			response.sendRedirect("html/book.jsp?book_id="+a.getBook_id());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
