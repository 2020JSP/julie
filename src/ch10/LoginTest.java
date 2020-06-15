package ch10;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginTest
 */
@WebServlet("/ch10/login")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//세션 호츌 
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		// 리스너 API 호츌 
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		if (session.isNew()) {
			session.setAttribute("loginUser", loginUser);
		}

		out.println("<head>");
		out.println("<script  type='text/javascript'>");
		//자바스크립트 setTimeout 함수로 오초마다 서블릿에 재 요청 
		out.println("setTimeout('history.go(0);', 5000)");
		out.println("</script>");
		out.println("</head>");
		out.println("<html><body>");
		out.println( " ID " + loginUser.user_id + "<br>");
		out.println("Total User" + LoginImpl.total_user + "<br>");
		out.println("</body></html>");

	}

}
