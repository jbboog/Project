package nl.project.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.project.Slot;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static List werknemerList;
	static List slotList;

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
		
		Slot s1 = new Slot (beginDateTime, eindDateTime);
		response.getWriter().append("<p>" + beginDateTime);
		response.getWriter().append("<p>" + eindDateTime);
		
	}

}
