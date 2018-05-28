package nl.project.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.project.Slot;
import nl.project.Werknemer;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static List<Werknemer> werknemerList = new ArrayList<>();
	public static List<Slot> slotList = new ArrayList<>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher(
			    "/index.jsp"
	    ).forward(request, response);
		
	}

	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		LocalDateTime beginDateTime = LocalDateTime.parse((String) request.getParameter("begindatum")+ "T" + request.getParameter("begintijd"));
		LocalDateTime eindDateTime = LocalDateTime.parse((String) request.getParameter("einddatum")+ "T" + request.getParameter("eindtijd"));

		slotList.add(new Slot (beginDateTime, eindDateTime));
		
		response.sendRedirect("/Project/index.html");
		
	}

}
