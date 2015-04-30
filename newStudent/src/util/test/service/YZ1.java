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

public class YZ1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public YZ1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		user YZ = new user();
		YZ.setUsername(request.getParameter("username"));
	    YZ.setPassword(request.getParameter("password"));
		String a,b;
		HttpSession session=request.getSession();
		a=DAOFactory.getMessageDAOInstance().yz1(YZ);
		b=request.getParameter("save");
		if(a.equals("0")){
			response.sendRedirect("user/html/t1.html");
		}
		else{
			if(b!=null){
				Cookie c1=new Cookie("username",request.getParameter("username"));
				c1.setMaxAge(10000);
				response.addCookie(c1);
			}
			session.setAttribute("username",request.getParameter("username"));
			response.sendRedirect("user/jsp/index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
