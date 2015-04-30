package util.test.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.test.bean.user;
import util.test.factory.DAOFactory;

public class YZ5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public YZ5() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		user YZ = new user();
		YZ.setUsername(request.getParameter("username"));
	   	YZ.setPassword(request.getParameter("password"));
		
		
		if(YZ.getUsername().equals("root")&&YZ.getPassword().equals("root")){
			response.sendRedirect("admin/jsp/MangerDemo.jsp");
		}
		else{
			response.sendRedirect("admin/html/t1.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
