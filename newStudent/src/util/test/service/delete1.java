package util.test.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.test.bean.buycar;
import util.test.bean.user;
import util.test.factory.DAOFactory;

public class delete1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public delete1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
			buycar b= new buycar();
			b.setBook_id(request.getParameter("book_id"));
			DAOFactory.getBuycarDAOImpl().del1(b);
			response.sendRedirect("admin/book.jsp");}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
