package util.test.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.test.bean.user;
import util.test.factory.DAOFactory;

public class message extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public message() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			user b = new user();
			b.setMessage(request.getParameter("message"));
			b.setTime(request.getParameter("time"));
			System.out.println(b.getMessage());
			DAOFactory.getMessageDAOInstance().addmessage(b);
			response.sendRedirect("html/center.jsp");}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
