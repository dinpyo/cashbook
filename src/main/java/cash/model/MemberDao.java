package cash.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cash.vo.Cashbook;
import cash.vo.Member;

public class MemberDao {
	// 1. 회원가입 메서드
	public int insertMember(Connection conn, Member member) {
		int row = 0;
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO member VALUES(?, PASSWORD(?), NOW(), NOW())";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			row = stmt.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return row;
	}
	
	// 2. 로그인 메서드
	public Member selectMemberById(Connection conn, Member paramMember) {
		Member returnMember = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT member_id memberId FROM member WHERE member_id=? AND member_pw = PASSWORD(?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, paramMember.getMemberId());
			stmt.setString(2, paramMember.getMemberPw());
			rs = stmt.executeQuery();
			if(rs.next()) {
				returnMember = new Member();
				returnMember.setMemberId(rs.getString("memberId"));
			}		
		} catch(Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}		
		return returnMember;
	}
	
	// 3. 회원 상세 정보
	public Member selectMemberOne(Connection conn, String memberId) {
		Member returnMemberOne = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT member_id memberId, member_pw memberPw, updatedate, createdate FROM member WHERE member_id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				returnMemberOne = new Member();
				returnMemberOne.setMemberId(rs.getString("memberId"));
				returnMemberOne.setMemberPw(rs.getString("memberPw"));
				returnMemberOne.setUpdatedate(rs.getString("updatedate"));
				returnMemberOne.setCreatedate(rs.getString("createdate"));	
			}		
		} catch(Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return returnMemberOne;
	}
	
	// 4. 회원 정보 수정
	public int updateMember(Connection conn, String memberId, String memberPw, String newPw1, String newPw2) {
		int row = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String selectSql = "SELECT COUNT(*) FROM member WHERE member_id=? AND member_pw= PASSWORD(?)";
			stmt = conn.prepareStatement(selectSql);
			stmt.setString(1, memberId);
			stmt.setString(2, memberPw);
			rs = stmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();		
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		// 조회가 되는 행이 있으면
		if(row>0 && newPw1.equals(newPw2)) {	
			try {
				String updateSql = "UPDATE member SET member_pw = PASSWORD(?), updatedate = NOW() WHERE member_id = ?";
				stmt = conn.prepareStatement(updateSql);
				stmt.setString(1, newPw1);
				stmt.setString(2, memberId);
				row = stmt.executeUpdate();
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				try {
					stmt.close();
				} catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return row;
	}
	
	// 5. 회원 탈퇴
	public int deleteMember(Connection conn, String memberId, String memberPw) {
		int row = 0;	
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE FROM member WHERE member_id =? AND member_pw = PASSWORD(?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			stmt.setString(2, memberPw);
			row = stmt.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return row;
	}
	
	// 5-1. 회원 탈퇴시 id에 해당하는 cashbook 데이터 조회
	public ArrayList<Cashbook> selectCashbookById(Connection conn, String memberId){
		ArrayList<Cashbook> cashbookList = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;	
		String sql = "SELECT cashbook_no"
					+ " FROM cashbook"
					+ " WHERE member_id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cashbook cashbook = new Cashbook();
				cashbook.setCashbookNo(rs.getInt("cashbook_no"));
				cashbookList.add(cashbook);
			}
			System.out.println(cashbookList.size());
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return cashbookList;	
	}
	
}