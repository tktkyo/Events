package controller; 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Events; 

 @WebServlet("/eventsadmin") 
 public class EventsAdminServlet extends HttpServlet 
 { private static final long serialVersionUID = 1L; 
 /**
 * @see HttpServlet#doGet(HttpServletRequest request,
 HttpServletResponse response)
 */ 
 
 protected void doGet(HttpServletRequest request, 
		 HttpServletResponse response) throws 
 ServletException, IOException 
 { request.setCharacterEncoding("UTF-8"); 
 
//入力値の取得
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String treatment = request.getParameter("treatment");
		String gift = request.getParameter("gift");

		//Eventsオブジェクトにまとめる
		Events events =new Events(name,date,treatment,gift);
		
		//セッションに格納
		HttpSession session =request.getSession();
		session.setAttribute("Events",events);
		
		//EventsページにRedirect 
		response.sendRedirect(request.getContextPath() + "/events");
			  
 
 //jspをフォワード
   request.getRequestDispatcher("/WEB-INF/view/eventsadmins.jsp") 
   .forward(request, response);
   
  
    //ログアウトページにリダイレクトする
   response.sendRedirect(request.getContextPath() + "/logout");
   }
}
