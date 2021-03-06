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

@WebServlet("/member/read")
public class MemberServlet_R extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	protected void doHandle(HttpServletRequest request,HttpServletResponse response)
                                                    throws ServletException, IOException {
	  request.setCharacterEncoding("utf-8");
	  response.setContentType("text/html;charset=utf-8");
      PrintWriter out=response.getWriter();	
      MemberDAO dao=new MemberDAO();
      String id = request.getParameter("id");
      System.out.println("id" + id);
      MemberVO memberVO = dao.getMembers(id);
	
      out.print("<html><body>");
      out.print("<table  border=1><tr align='center' bgcolor='lightgreen'>");
      out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
     
		String USER_ID=memberVO.getUSER_ID();
		String USER_PWD = memberVO.getUSER_PWD();
		String USER_NAME=memberVO.getUSER_NAME();
		String USER_EMAIL=memberVO.getUSER_EMAIL();
		String DEL_FLG=memberVO.getDEL_FLG();
		Date REG_DATE = memberVO.getREG_DATE();
		out.print("<tr><td>"+USER_ID+"</td><td>"+
							USER_PWD	+"</td><td>"+
							USER_NAME+"</td><td>"+
							USER_EMAIL+"</td><td>"+
							REG_DATE+"</td></tr>");		
      
      out.print("</table></body></html>");
   }
	
}