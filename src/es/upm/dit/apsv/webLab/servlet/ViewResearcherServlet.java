package es.upm.dit.apsv.webLab.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.upm.dit.apsv.webLab.dao.ResearcherDAOImpl;
import es.upm.dit.apsv.webLab.dao.ResearcherDAO;
import es.upm.dit.apsv.webLab.dao.model.Researcher;;
/**
 * Servlet implementation class ViewResearcherServlet
 */
@WebServlet("/ViewResearcherServlet")
public class ViewResearcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewResearcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rsID = (String) request.getParameter("rsi");
		ResearcherDAO dao = ResearcherDAOImpl.getInstance();
		Researcher rs = dao.read(new Researcher(rsID, null, null, null, null));
		request.getSession().setAttribute("researcher", rs);
		response.sendRedirect("ViewResearcher.jsp");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
