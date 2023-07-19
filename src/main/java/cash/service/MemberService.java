package cash.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cash.model.MemberDao;
import cash.vo.Member;

public class MemberService {
	private MemberDao memberDao;
	Connection conn = null;
	
	// 1. 회원가입 메서드
	public int insertMember(Member member) {
		this.memberDao = new MemberDao();
		int row = 0;
		try {
			// conn.getAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/cash","root","java1234");
			row = memberDao.insertMember(conn, member);
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
	
	// 2. 로그인 메서드
	public Member selectMemberById(Member paramMember) {
		this.memberDao = new MemberDao();
		Member returnMember = null;
		try {
			// conn.getAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/cash","root","java1234");
			returnMember = memberDao.selectMemberById(conn, paramMember);
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
		return returnMember;	
	}
	
	// 3. 회원 상세 정보
	public Member selectMemberOne(String memberId) {
		this.memberDao = new MemberDao();
		Member returnMemberOne = null;
		try {
			// conn.getAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/cash","root","java1234");
			returnMemberOne = memberDao.selectMemberOne(conn, memberId);
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
		return returnMemberOne;
	}
	
	// 4. 회원 정보 수정
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
	
	// 5. 회원 탈퇴
	public int deleteMember(String memberId, String memberPw) {
		this.memberDao = new MemberDao();
		int row = 0;
		try {
			// conn.getAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/cash","root","java1234");
			row = memberDao.deleteMember(conn, memberId, memberPw);
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
