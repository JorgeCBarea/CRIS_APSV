package es.upm.dit.apsv.webLab.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.upm.dit.apsv.webLab.dao.*;
import es.upm.dit.apsv.webLab.dao.*;
import es.upm.dit.apsv.webLab.dao.model.*;

/**
 * Servlet implementation class CreatePublicationServlet
 */
@WebServlet("/CreatePublicationServlet")
public class CreatePublicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePublicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResearcherDAO rdao = ResearcherDAOImpl.getInstance();
		PublicationDAO pdao = PublicationDAOImpl.getInstance();
		//Creamos una nueva publicación con los datos que nos traemos del formulario
		Publication publication = new Publication(
										(String)request.getParameter("id"),
										(String)request.getParameter("title"),
										Integer.parseInt(request.getParameter("citeCount")));
					
		//Cogemos el usuario de la sesión (usuario logeado)
		Researcher researcher = (Researcher) request.getSession().getAttribute("user");
		//Leemos los datos del usuario de la base de datos
		if(publication.getAuthors() == null) {System.out.println("El user es null");}
		System.out.println("El atributo usuario es "+researcher.getName());
		researcher = rdao.read(researcher);
		//Obtenemos la lista de autores para una determinada publicación
		Collection<Researcher> authors = new ArrayList<Researcher>();
		//Añadmimos a la lista de autores de esa publicación el researcher (usuario logeado)
		authors.add(researcher);
		//Seteamos el atributo autores de esa publicación con la lista en la que
		//hemos añadido el nuevo autor
		publication.setAuthors(authors);
		//Añadimos esta a la base de datos
		pdao.create(publication);
		//Obtenemos la lista de publicaciones que tiene el usuario logeado
		Collection<Publication> publications = researcher.getPublications();
		//Añadimos a esa lista la nueva publicación
		publications.add(publication);
		//Seteamos el atributo publicaciones de ese autor (usuario logeado) con la lista
		//en la que hemos añadido la nueva publicación
		researcher.setPublications(publications);
		//Lo actualizamos en la base de datos
		rdao.update(researcher);
		request.getSession().setAttribute("pubs", publications);
		response.sendRedirect("ViewProfile.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
