package controller; 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
/** 
 * * Servlet implementation class EventViewingServlet */
@WebServlet("/events") 
public class EventsServlet extends HttpServlet 
{ private static final long serialVersionUID = 1L; 
protected void doPost(HttpServletRequest 
		request, HttpServletResponse response) throws ServletException, IOException { request.setCharacterEncoding("UTF-8"); // Retrieve form data 
		String eventName = request.getParameter("eventName"); 
		String eventDate = request.getParameter("eventDate"); 
		String treatmentDetails = request.getParameter("treatmentDetails"); 
		String giftDetails = request.getParameter("giftDetails"); 
		// Process the data (e.g., save to database, perform business logic, etc.) 
		// Redirect to the events page 
		response.sendRedirect(request.getContextPath() + "/events"); 
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
		{ request.setCharacterEncoding("UTF-8"); 
		request.getRequestDispatcher("/WEB-INF/view/events.jsp") 
		.forward(request, response); }
		}

