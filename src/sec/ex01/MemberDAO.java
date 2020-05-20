package sec.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "system";
	private static final String pwd = "oracle";
	private Connection con;
	private Statement stmt;

	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB();
			String query = "select * from TB_MEMBER ";
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String USER_ID = rs.getString("USER_ID");
				String USER_PWD = rs.getString("USER_PWD");
				String USER_NAME = rs.getString("USER_NAME");
				String USER_EMAIL = rs.getString("USER_EMAIL");
				String DEL_FLG = rs.getString("DEL_FLG");
				Date REG_DATE = rs.getDate("REG_DATE");
				
				MemberVO vo = new MemberVO();
				vo.setUSER_ID(USER_ID);
				vo.setUSER_PWD(USER_PWD);
				vo.setUSER_NAME(USER_NAME);
				vo.setUSER_EMAIL(USER_EMAIL);
				vo.setREG_DATE(REG_DATE);
				vo.setDEL_FLG(DEL_FLG);
				list.add(vo);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Loading Oracle driver");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection created");
			stmt = con.createStatement();
			System.out.println("Statement created");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}