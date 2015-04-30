package util.test.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.test.bean.user;
import util.test.factory.DAOFactory;

public class YZ4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public YZ4() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		user YZ = new user();
		YZ.setUsername(request.getParameter("username"));
		YZ.setPassword1(request.getParameter("password1"));
		YZ.setPassword2(request.getParameter("password2"));
		if(!YZ.getPassword1().equals(YZ.getPassword2())){
			response.sendRedirect("user/jsp/findpassword.jsp?b=1&&c="+YZ.getUsername()+"#toregister");
		}
		else{
			DAOFactory.getMessageDAOInstance().yz4(YZ);
			response.sendRedirect("user/html/t3.html");}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
