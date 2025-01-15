package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Events;

/** 
 * * お客様が観る画面*/
@WebServlet("/events")
public class EventsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	* @see HttpServlet#doPost(HttpServletRequest request,
	HttpServletResponse response)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッションに登録内容が未保存の時登録画面へリダイレクト
		HttpSession session = request.getSession();
		if(session.getAttribute("events") == null) {
			response.sendRedirect("eventsadmin");
			return;
		}
		//画面の表示
		request.getRequestDispatcher("/WEB-INF/view/events.jsp")
		.forward(request, response);
	}
		/**
		* @see HttpServlet#doPost(HttpServletRequest request,
		HttpServletResponse response)
		*/
		protected void doPost(HttpServletRequest request, HttpServletResponse
				response) throws ServletException, IOException {
			
			//セッションから登録内容を取り出す
			HttpSession session =request.getSession();
			Events events = (Events) session.getAttribute("events");
			
			
		
		//セッションの内容が不要になったので破棄する
		session.invalidate();
		
				
		//forward　
		request.getRequestDispatcher("/WEB-INF/view/events.jsp").forward(request, response);

		
		
	
	}
}
