package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/login.jsp")
				.forward(request, response);

	}

	/**
	* @see HttpServlet#doPost1(HttpServletRequest request,
	HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("user_id");
		// ユーザーID の確認
		String errorMessage = null;
		boolean isCorrectId = true;
		if (userId.isBlank()) {
			isCorrectId = false;
			errorMessage = "ログインID が未入力です";
		} else if (!userId.equals("takahashi")) {
			isCorrectId = false;
			errorMessage = "ログインID が違います";
		}
		if (!isCorrectId) {
			// ユーザーID が不正な場合
			request.setAttribute("message", errorMessage);
			request.getRequestDispatcher("/WEB-INF/view/login.jsp")
					.forward(request, response);
		} else {
			// ユーザーID が正しい場合
			HttpSession session = request.getSession();
			session.setAttribute("login", true);
			response.sendRedirect("events/admin");
			return;
		}

		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/WEB-INF/view/login.jsp")
				.forward(request, response);

	}

}
