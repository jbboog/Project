package nl.project.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.project.Slot;

import static nl.project.web.IndexServlet.slotList;

/**
 * Servlet implementation class SlotFormulierServlet
 */
@WebServlet("/slotformulier.html")
public class SlotFormulierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher(
			    "/slotformulier.jsp"
	    ).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LocalDateTime beginDateTime = LocalDateTime.parse((String) request.getParameter("begindatum") + "T" + request.getParameter("begintijd"));
			LocalDateTime eindDateTime = LocalDateTime.parse((String) request.getParameter("einddatum") + "T" + request.getParameter("eindtijd"));
			
			slotList.add(new Slot (beginDateTime, eindDateTime));
			
			response.sendRedirect("/Project/index.html");
		} 
		catch (DateTimeParseException e) {
			
			// TODO: zorg dat de gebruiker een foutmelding te zien krijgt
			
			response.sendRedirect("/Project/slotformulier.html");
		}
	}

}
