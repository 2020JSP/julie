package ch8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                         throws ServletException, IOException {
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out = response.getWriter();
      // 1. sendredirect 
      // response.sendRedirect("second");
      // 2. resoponse : like 8.1 forward through the web browser. 
      // addheader 
      // response.addHeader("Refresh","1;url=second");
      // 3. location (java script)
      out.print("<script type='text/javascript'>");
      out.print("location.href='second';");
      out.print("</script>");
   }
}