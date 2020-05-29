package ch8;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1, member설정 후 get으로 받을 예정 
@WebServlet("/cset")
public class SetServletContext extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();

		List member = new ArrayList();
		member.add("julie");
		member.add(30);
		context.setAttribute("member", member);

		out.print("<html><body>");
		out.print("i am julie and 30 years old");
		out.print("</body></html>");
	}
}
