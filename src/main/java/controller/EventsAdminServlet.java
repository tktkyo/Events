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

@WebServlet("/eventsadmin")
public class EventsAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//セッションにログイン済みかを確認
		HttpSession session = request.getSession();
		if (session.getAttribute("login") == null) {
			// ログイン済みでない
			response.sendRedirect("login");
			return;
		}

		// DB接続設定
		String url = "jdbc:mysql://127.0.0.1:3306"
				+ "/events"
				+ "?useUnicode=true"
				+ "&characterEncoding=utf8"
				+ "&serverTimezone=Asia/Tokyo";
		String user = "root";
		String pass = "";

		try (Connection con = DriverManager.getConnection(url, user, pass)) {
			// DBからデータを取得

			// 取得したデータをリクエストスコープに格納

			// フォワード
			request.getRequestDispatcher("/WEB-INF/view/eventsadmins.jsp")
					.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字化け防止
		request.setCharacterEncoding("UTF-8");

		//入力値の取得
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String treatment = request.getParameter("treatment");
		String gift = request.getParameter("gift");

		//Eventsオブジェクトにまとめる
		Events events = new Events(name, date, treatment, gift);

		// DB接続設定
		String url = "jdbc:mysql://127.0.0.1:3306"
				+ "/events"
				+ "?useUnicode=true"
				+ "&characterEncoding=utf8"
				+ "&serverTimezone=Asia/Tokyo";
		String user = "root";
		String pass = "";

		try (Connection con = DriverManager.getConnection(url, user, pass)) {
			// DBにデータを保存

			// フォームを再表示（⇒ リダイレクトして、doGetを呼び出す）
			response.sendRedirect(request.getContextPath() + "/eventsadmin");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
