package sec.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/delete")
public class MemberServlet_D extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//empty
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("delete start");
		doHandle(req, resp);
	}

	protected void doHandle(HttpServletRequest request,HttpServletResponse response)
                                                    throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");
		  response.setContentType("text/html;charset=utf-8");
	      MemberDAO dao=new MemberDAO();
	      String id = request.getParameter("id");
		  int num = dao.delete(id);
		     
		     PrintWriter out=response.getWriter();	
		      out.print("<html><body>");
		     if(num>0) {
			      out.print("success to update ");
		     } else if (num==0) {
		    	 out.print("noting to updated ");
		     } else {
		    	 out.print("there was problem. ");
		     }
		     out.print("</body></html>");
	}
	
}