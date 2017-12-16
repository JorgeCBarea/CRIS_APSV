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
 * Servlet implementation class CreateResearcherServlet
 */
@WebServlet("/CreateResearcherServlet")
public class CreateResearcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateResearcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("En el método get de create");
		ResearcherDAO dao =  ResearcherDAOImpl.getInstance();
		Researcher newReseacher = new Researcher((String)request.getParameter("id"),
												 (String)request.getParameter("name"),
												 (String)request.getParameter("email"),
												 (String)request.getParameter("affiliation"),
												 (String)request.getParameter("password"));
		request.getSession().setAttribute("isCreated", true);
		dao.create(newReseacher);
		response.sendRedirect("RootView.jsp");
		
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
