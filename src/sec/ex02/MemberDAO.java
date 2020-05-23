package sec.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {
	//생성자에서 톰캣실행시 톰캣에서 미리 생성한 datasource를 받아
		try {
			Context ctx = new InitialContext();
			Context envcontext = (Context) ctx.lookup("java:comp/env");
			dataFactory = (DataSource) envcontext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public MemberVO getMembers(String id) {
		
		MemberVO vo = new MemberVO();
		try {
			con = dataFactory.getConnection();
			String query = "select * from TB_MEMBER where USER_ID=?";
			System.out.println("prepareStatememt:" + query);
			System.out.println("id" + id);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			System.out.println("id" + id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String USER_ID = rs.getString("USER_ID");
				String USER_PWD = rs.getString("USER_PWD");
				String USER_NAME = rs.getString("USER_NAME");
				String USER_EMAIL = rs.getString("USER_EMAIL");
				String DEL_FLG = rs.getString("DEL_FLG");
				Date REG_DATE = rs.getDate("REG_DATE");

				vo.setUSER_ID(USER_ID);
				vo.setUSER_PWD(USER_PWD);
				vo.setUSER_NAME(USER_NAME);
				vo.setUSER_EMAIL(USER_EMAIL);
				vo.setREG_DATE(REG_DATE);
				vo.setDEL_FLG(DEL_FLG);
			}
			rs.close();
			pstmt.close();
			// con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	public List<MemberVO> listMembers() {
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			// connDB();
			con = dataFactory.getConnection();
			String query = "select * from TB_MEMBER";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
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
			pstmt.close();
			//con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void addMember(MemberVO memberVO) {
		try {
 			con = dataFactory.getConnection();
			String id = memberVO.getUSER_ID();
			String pwd = memberVO.getUSER_PWD();
			String name = memberVO.getUSER_NAME();
			String email = memberVO.getUSER_EMAIL();
			String query = "insert into TB_MEMBER";
			query += " (USER_ID,USER_PWD,USER_NAME,USER_EMAIL,DEL_FLG)";
			query += " values(?,?,?,?,?)";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setString(5, "F");
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void delMember(String id) {
		try {
			con = dataFactory.getConnection();
			String query = "delete from TB_MEMBER" + " where USER_ID=?";
			System.out.println("prepareStatememt:" + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end delMember
	
	public int update(MemberVO memberVO) {
		int num = 0;
		try {
			con = dataFactory.getConnection();
			String id = memberVO.getUSER_ID();
			String pwd = memberVO.getUSER_PWD();
			String name = memberVO.getUSER_NAME();
			String email = memberVO.getUSER_EMAIL();
			String query = "update TB_MEMBER set";
			query += " USER_PWD = ?, USER_NAME = ?, USER_EMAIL = ? WHERE USER_ID = ?";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, pwd);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			num = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	} // end update
	
	public int delete(String id) {
		int num = 0;
		try {
			con = dataFactory.getConnection();
			String query = "update TB_MEMBER set DEL_FLG='T' WHERE USER_ID = ?";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			num = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	} // end update
	

}