package ch8;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberList")
public class MemberServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
                                                    throws ServletException, IOException {
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out=response.getWriter();	
      MemberDAO dao=new MemberDAO();
      List<MemberVO> list=dao.listMembers();
      request.setAttribute("memberList", list);
      RequestDispatcher dispatch = request.getRequestDispatcher("viewmembber");
      dispatch.forward(request, response);
   }
	
}