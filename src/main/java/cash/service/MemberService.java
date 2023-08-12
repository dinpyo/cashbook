package cash.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import cash.model.CashbookDao;
import cash.model.HashtagDao;
import cash.model.MemberDao;
import cash.vo.Cashbook;
import cash.vo.Member;

public class MemberService {
	private MemberDao memberDao;
	Connection conn = null;
	
	// 1. 회원가입 메서드
	public int insertMember(Member member) {
		this.memberDao = new MemberDao();
		int row = 0;
		try {
			// conn.setAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://3.34.33.114:3306/cash","root","java1234");
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
			// conn.setAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://3.34.33.114:3306/cash","root","java1234");
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
			// conn.setAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://3.34.33.114:3306/cash","root","java1234");
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
			// conn.setAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://3.34.33.114:3306/cash","root","java1234");
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
	
	// 5. 회원 탈퇴시 그 회원의 cashbook과 hashtag 전부 삭제
	public int deleteMember(String memberId, String memberPw) {
		this.memberDao = new MemberDao();
		HashtagDao hashtagDao = new HashtagDao();
		CashbookDao cashbookDao = new CashbookDao();
		
		int row = 0;
		int hashtagRow = 0;
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://3.34.33.114:3306/cash","root","java1234");
			conn.setAutoCommit(false);
			
			// ArrayList에다가 cashbookNo를 아이디로 조회해서 담는다.
			ArrayList<Cashbook> cashbookNoList = memberDao.selectCashbookById(conn, memberId);
			
			// 그 후 지워야할 데이터가 있거나 없어도 hashtag를 cashbookNo키값으로 지운다
			if(cashbookNoList.size() >= 0 ) {
				for(Cashbook c : cashbookNoList) {
					hashtagRow = hashtagDao.deleteHashtag(conn, c.getCashbookNo());
					
					// 지워진 해시태그가 있다면 cashbook을 지운다.
					if(hashtagRow > 0) {
						cashbookDao.deleteCashbook(conn, c.getCashbookNo());
					}
				}
				// 그 후 회원 삭제
				row = memberDao.deleteMember(conn, memberId, memberPw);
			}
			conn.commit();
			
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
