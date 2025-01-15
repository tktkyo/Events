package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		request.getRequestDispatcher("WEB=INF/view/registewConf.jsp")
		.forward(request, response);
		
		/**
		* @see HttpServlet#doPost(HttpServletRequest request,
		HttpServletResponse response)
		*/
		protected void doPost(HttpServletRequest requerequest, HttpServletResponse
				response) throws ServletException, IOException {
			
			//セッションから登録内容を取り出す
			HttpSession session =request.getSession();
			Events events = (Events) session.getAttribute("events");
			
			//データベースに登録内容を保存する
			System.out.println(evevts.neame);
			System.out.println(events.date);
			System.out.println(events.treatment);
			System.out.println(events.gift);
		}
		//セッションの内容が不要になったので破棄する
		session.invalidate();
		
				
		//forward　
		request.getRequestDispatcher("/WEB-INF/view/events.jsp").forward(request, response);

		

	
	}
}
