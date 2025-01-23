package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
			response.sendRedirect("events");
			return;
		}

		// DB接続設定
				String url = "jdbc:mysql://127.0.0.1:3306/events?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Tokyo";
				String user = "root";
				String pass = "";

				try (Connection con = DriverManager.getConnection(url, user, pass)) {
					// DBからデータを取得
					
					// 取得したデータをリクエストスコープに格納

					// フォワード
					request.getRequestDispatcher("/WEB-INF/view/events.jsp")
							.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		// DBから取得
		
					// 取得したものをリクエストスコープに格納
		
		
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
