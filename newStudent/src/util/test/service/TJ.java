package util.test.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.test.bean.buycar;
import util.test.bean.user;
import util.test.factory.DAOFactory;

public class TJ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TJ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
			String a[] = request.getParameterValues("buytime");
			buycar b = new buycar();
			String c = "reciver:"+request.getParameter("e1") + " adress:" + request.getParameter("e2") + " phone:" + request.getParameter("e3");
			b.setUsername(request.getParameter("username"));
			b.setAddress(c);
			b.setRemark(request.getParameter("remark"));
			for(int i=0;i<a.length;i++){
				b.setBuycar_time(a[i]);
				DAOFactory.getBuycarDAOImpl().jz(b);
				DAOFactory.getBuycarDAOImpl().del(b);
			}
			response.sendRedirect("html/buycar.jsp");}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
