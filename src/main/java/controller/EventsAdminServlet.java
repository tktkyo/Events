package controller; 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 

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
 
 //jspをフォワード
   request.getRequestDispatcher("/WEB-INF/view/eventsadmins.jsp") 
   .forward(request, response);
   
   // セッションを破棄 
   HttpSession session = request.getSession(); 
   session.invalidate(); 
   //ログアウトページにリダイレクトする
   response.sendRedirect(request.getContextPath() + "/logout");
   }
}
