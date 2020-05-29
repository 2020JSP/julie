package ch8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet(
		urlPatterns = { 
				"/sInit", 
				"/sInit2"
		}, 
		initParams = { 
				@WebInitParam(name = "name", value = "julie"), 
				@WebInitParam(name = "fullname", value = "Juliea")
		})
public class InitParamServlet extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	      request.setCharacterEncoding("utf-8");
	      response.setContentType("text/html;charset=utf-8");
	      PrintWriter out = response.getWriter();
	      String name = getInitParameter("name");
	      String fullName = getInitParameter("fullname");

	      out.print("<html><body>");
	      out.print("이름 :" + name );
	      out.print("<br> 진짜이름 :" + fullName );
	      out.print("</body></html>");	
	}

}
