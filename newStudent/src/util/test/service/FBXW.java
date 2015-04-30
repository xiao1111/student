package util.test.service;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.test.bean.news;
import util.test.factory.DAOFactory;

public class FBXW extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public FBXW() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
			news a = new news();
			a.setTitle(request.getParameter("title"));
			a.setContent(request.getParameter("content"));
			DAOFactory.getAdminDAOImpl().fbxw(a);
			response.sendRedirect("admin/jsp/admin.jsp");}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
