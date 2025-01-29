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

import dto.Events;

/** 
 * * お客様が観る画面*/
@WebServlet("/events")
public class EventsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
			request.getRequestDispatcher("/WEB-INF/view/events.jsp")
					.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("未接続");
		}
	}
}
