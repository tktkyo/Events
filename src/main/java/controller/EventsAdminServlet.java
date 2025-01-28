package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			// conを使ってSQLを実行　　DBからデータを取得
			String sql = "SELECT * FROM events";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			
			Events events = null;
			if (rs.next()) {
				Integer id = (Integer) rs.getObject("id");
				String title = (String) rs.getObject("title");
				String date = (String) rs.getObject("date");
				String treatment = (String) rs.getObject("treatment");
				String gift = (String) rs.getObject("gift");
				
				events = new Events(id, title, date, treatment, gift);
			}
			// 取得したデータをリクエストスコープに格納

			request.setAttribute("events", events);

			// フォワード
			request.getRequestDispatcher("/WEB-INF/view/eventsadmins.jsp")
					.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("未接続");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字化け防止
		request.setCharacterEncoding("UTF-8");

		//入力値の取得
		Integer id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String treatment = request.getParameter("treatment");
		String gift = request.getParameter("gift");
		

		//Eventsオブジェクトにまとめる
		Events events = new Events(id, title, date, treatment, gift);

		// DB接続設定
		String url = "jdbc:mysql://127.0.0.1:3306/events?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Tokyo";
		String user = "root";
		String pass = "";

		try (Connection con = DriverManager.getConnection(url, user, pass)) {
			// データベースにデータを保存するSQL文
	        String sql = "INSERT INTO events (id, title, date, treatment, gift) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setInt(1, events.getId());
	        stmt.setString(2, events.getTitle());
	        stmt.setString(3, events.getDate());
	        stmt.setString(4, events.getTreatment());
	        stmt.setString(5, events.getGift());

	        // SQL文の実行
	        int result = stmt.executeUpdate();
	        if (result > 0) {
	            // データが正常に挿入された場合
	            System.out.println("データが挿入されました");
	        } else {
	            // データが挿入されなかった場合
	            System.out.println("データの挿入に失敗しました");
	        }

			// フォームを再表示（⇒ リダイレクトして、doGetを呼び出す）
			response.sendRedirect(request.getContextPath() + "eventsadmin.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("未接続");
		}
	}
}

//InitialContext ctx = new InitialContext();DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/events");try(Connection con1 = ds.getConnection()) {Integer id = null;String title ="イベント名";
//String date ="イベント日程";
//String treatment ="トリートメント内容";
//String gift = "ギフト内容";
