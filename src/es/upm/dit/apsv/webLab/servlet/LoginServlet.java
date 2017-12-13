package es.upm.dit.apsv.webLab.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.upm.dit.apsv.webLab.dao.ResearcherDAO;
import es.upm.dit.apsv.webLab.dao.ResearcherDAOImpl;
import es.upm.dit.apsv.webLab.dao.model.Researcher;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String admin = "admin";
		String adminPwd = "admin";
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		ResearcherDAOImpl dao = ResearcherDAOImpl.getInstance();
		Researcher researcher = dao.readName(new Researcher("0", user, "", "", pwd));
		
		if(admin.equals(user) && adminPwd.equals(pwd)) {
			request.getSession().setAttribute("user", new Researcher("0", "root", "","", ""));
			response.sendRedirect("RootView.jsp");
		} else if (researcher != null && user.equals(researcher.getName()) && pwd.equals(researcher.getPassword())) {
			request.getSession().setAttribute("user", researcher);
			request.getSession().setAttribute("researcher", researcher);
			response.sendRedirect("ViewProfile.jsp");
		} else {
			response.sendRedirect(request.getContextPath()+"/index.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
