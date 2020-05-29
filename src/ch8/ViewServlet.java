package ch8;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
		                                            throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");		
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();
		List membersList = (List) request.getAttribute("membersList");
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td >삭제</td></tr>");
		for (int i = 0; i < membersList.size(); i++) {
			MemberVO memberVO = (MemberVO) membersList.get(i);
			String USER_ID=memberVO.getUSER_ID();
			String USER_PWD = memberVO.getUSER_PWD();
			String USER_NAME=memberVO.getUSER_NAME();
			String USER_EMAIL=memberVO.getUSER_EMAIL();
			String DEL_FLG=memberVO.getDEL_FLG();
			Date REG_DATE = memberVO.getREG_DATE();
			out.print("<tr><td>" + USER_ID + "</td><td>" + USER_PWD + "</td><td>" + USER_NAME + "</td><td>" + USER_EMAIL + "</td><td>"
					+ REG_DATE + "</td><td>" + "<a href='/pro07/member3?command=delMember&id=" + USER_ID
					+ "'>삭제 </a></td></tr>");

		}
		out.print("</table></body></html>");
		out.print("<a href='/pro07/memberForm.html'>새 회원 등록하기</a");
	}
}
