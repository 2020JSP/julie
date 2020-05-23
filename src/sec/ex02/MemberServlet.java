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

@WebServlet("/memberList")
public class MemberServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
                                                    throws ServletException, IOException {
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out=response.getWriter();	
      MemberDAO dao=new MemberDAO();
      List<MemberVO> list=dao.listMembers();
	
      out.print("<html><body>");
      out.print("<table  border=1><tr align='center' bgcolor='lightgreen'>");
      out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>수정</td>"
      		+ "<td> 삭제 </td></tr>");
     
     for (int i=0; i<list.size();i++){
		MemberVO memberVO=(MemberVO) list.get(i);
		String USER_ID=memberVO.getUSER_ID();
		String USER_PWD = memberVO.getUSER_PWD();
		String USER_NAME=memberVO.getUSER_NAME();
		String USER_EMAIL=memberVO.getUSER_EMAIL();
		String DEL_FLG=memberVO.getDEL_FLG();
		Date REG_DATE = memberVO.getREG_DATE();
		out.print("<tr><td>" +
				"<a href='/pro07/member/read?id=" + USER_ID + "'>"+ USER_ID +"</a>" +
				"</td><td>"+
				USER_PWD+"</td><td>"+
				USER_NAME+"</td><td>"+
				USER_EMAIL	+"</td><td>"+
				REG_DATE+"</td>"+
				"<td><a href='/pro07/member/update?id=" + USER_ID + "'> 수정 </a></td>");
		out.print("<td><a href='/pro07/member/delete?id=" + USER_ID + "'> 삭제 </a></td>" + " </tr>");
      }
     
      out.print("</table></body></html>");
   }
	
}