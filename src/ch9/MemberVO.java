package ch9;

import java.sql.Date;

public class MemberVO {
	private String USER_ID;
	private String USER_PWD;
	private String USER_NAME;
	private String USER_EMAIL;
	private String DEL_FLG;
	private Date REG_DATE;
	
	public MemberVO() {
		System.out.println("MemberVO Created");
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_PWD() {
		return USER_PWD;
	}

	public void setUSER_PWD(String uSER_PWD) {
		USER_PWD = uSER_PWD;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}

	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}

	public String getDEL_FLG() {
		return DEL_FLG;
	}

	public void setDEL_FLG(String dEL_FLG) {
		DEL_FLG = dEL_FLG;
	}

	public Date getREG_DATE() {
		return REG_DATE;
	}

	public void setREG_DATE(Date rEG_DATE) {
		REG_DATE = rEG_DATE;
	}

	

	
}