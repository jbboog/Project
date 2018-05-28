package nl.project.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.project.Werknemer;
import static nl.project.web.IndexServlet.werknemerList;

/**
 * Servlet implementation class WerknemerFormulierServlet
 */
@WebServlet("/werknemerformulier.html")
public class WerknemerFormulierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher(
			    "/werknemerformulier.jsp"
	    ).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String voornaam = (String) request.getParameter("voornaam");
		String achternaam = (String) request.getParameter("achternaam");
		
		werknemerList.add(new Werknemer(voornaam, achternaam));
		
		response.sendRedirect("/Project/index.html");
	}

}
