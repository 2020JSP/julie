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

@WebServlet("/member/update")
public class MemberServlet_U extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");
		  response.setContentType("text/html;charset=utf-8");
	      PrintWriter out=response.getWriter();	
	      
	      MemberDAO dao=new MemberDAO();
	      String id = request.getParameter("id");
	      System.out.println("id" + id);
	      MemberVO memberVO = dao.getMembers(id);
		
	      out.print("<html><body><form name='update' method='post' action='update'>");
	      out.print("<table  border=1><tr align='center' bgcolor='lightgreen'>");
	      out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
	     
			String USER_ID=memberVO.getUSER_ID();
			String USER_PWD = memberVO.getUSER_PWD();
			String USER_NAME=memberVO.getUSER_NAME();
			String USER_EMAIL=memberVO.getUSER_EMAIL();	
			String DEL_FLG=memberVO.getDEL_FLG();
			
			Date REG_DATE = memberVO.getREG_DATE();
			out.print("<tr><td><input type='text' name='USER_ID' value = '" +USER_ID+ "' readonly> </td> "
					+"<td><input type='password' name='USER_PWD' value = '" +USER_PWD+ "'> </td> "
					+"<td><input type='text' name='USER_NAME' value = '" +USER_NAME+ "'> </td> "
					+"<td><input type='text' name='USER_EMAIL' value = '" +USER_EMAIL+ "'> </td> "
					+"<td>"+REG_DATE+"</td></tr>");		
			out.print("</table>" 
	    		    +"<input type='submit' value='submit'/>"
	    		  	+ "</form></body></html>");
	  
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("update start");
		doHandle(req, resp);
	}

	protected void doHandle(HttpServletRequest request,HttpServletResponse response)
                                                    throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");
		  response.setContentType("text/html;charset=utf-8");
	      MemberDAO dao=new MemberDAO();
			 String _id=request.getParameter("USER_ID");
			 String _pwd=request.getParameter("USER_PWD");
			 String _name=request.getParameter("USER_NAME");
			 String _email=request.getParameter("USER_EMAIL");
			 MemberVO vo=new MemberVO();
			 vo.setUSER_ID(_id);
			 vo.setUSER_PWD(_pwd);
			 vo.setUSER_NAME(_name);
			 vo.setUSER_EMAIL(_email);
		     int num = dao.update(vo);
		     
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