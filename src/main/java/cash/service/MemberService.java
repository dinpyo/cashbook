package cash.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cash.model.MemberDao;

public class MemberService {
	private MemberDao memberDao;
	Connection conn = null;
	
	
	// 회원정보 수정
	public int updateMember(String memberId, String memberPw, String newPw1, String newPw2) {
		this.memberDao = new MemberDao();
		int row = 0;
		
		try {
			// conn.getAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/cash","root","java1234");
			row = memberDao.updateMember(conn, memberId, memberPw, newPw1, newPw2);
		} catch(Exception e) {
			// conn.rollback();
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return row;
	}
	
		
	

	
}
