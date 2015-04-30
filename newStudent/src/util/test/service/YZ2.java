package util.test.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.test.bean.user;
import util.test.factory.DAOFactory;

public class YZ2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public YZ2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		user YZ = new user();
		YZ.setUsername1(request.getParameter("username1"));
		YZ.setPassword1(request.getParameter("password1"));
		YZ.setPassword2(request.getParameter("password2"));
		YZ.setMail(request.getParameter("mail"));
		YZ.setMma(request.getParameter("mma"));
		YZ.setMmq(request.getParameter("mmq"));
		YZ.setA(DAOFactory.getMessageDAOInstance().yz2(YZ));
		String p1 = YZ.getPassword1();
		String p2 = YZ.getPassword2();
		if(YZ.getA()==1){
			response.sendRedirect("user/jsp/register.jsp?a="+YZ.getA()+"#toregister");
		}
		else if(!p1.equals(p2)){
			response.sendRedirect("user/jsp/register.jsp?b=1#toregister");
		}
		else{response.sendRedirect("user/html/t2.html");}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
