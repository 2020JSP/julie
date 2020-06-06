package ch9;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginCh9Test")
public class LoginServlet extends HttpServlet {
	public void init() {
		System.out.println("called init");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");

		String data = "login<br><br>";
		data += "<html><body>";
		data += "id : " + user_id;
		data += "<br>";
		data += "password : " + user_pw;
		data += "<br>";
		data += "address : " + user_address;
		data += "<br>";
		data += "email : " + user_email;
		data += "<br>";
		data += "phone : " + user_hp;
		data += "<br>";
		
		//URL Rewriting
		user_address = URLEncoder.encode(user_address, "utf-8");
		out.print("<a href='/pro07/secondCh9?user_id=" + user_id 
				             + "&user_pw=" + user_pw 
				             + "&user_address=" + user_address
				             + "'>두 번째 서블릿으로 보내기</a>");
		data = "</body></html>"; 
		//URL Rewriting
		out.print(data);
		
	}

	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}