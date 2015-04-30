package util.test.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.test.bean.user;
import util.test.factory.DAOFactory;

public class xm2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public xm2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		user YZ = new user();
		YZ.setUsername(request.getParameter("username"));
		response.sendRedirect("html/findpassword.jsp?c="+request.getParameter("username")+"#toregister");}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
