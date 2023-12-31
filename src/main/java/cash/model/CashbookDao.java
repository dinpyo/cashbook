package cash.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import cash.vo.Cashbook;

public class CashbookDao {
	// 1. 달력에 수입/지출 표시
	public List<Cashbook> selectCashbookListByMonth(Connection conn, String memberId, int targetYear, int targetMonth) {
		List<Cashbook> list = new ArrayList<Cashbook>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT cashbook_no cashbookNo, category, price, cashbook_date cashbookDate"
					+ " FROM cashbook"
					+ " WHERE member_id=? AND YEAR(cashbook_date)=? AND MONTH(cashbook_date)=?"
					+ " ORDER BY cashbook_date ASC";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			stmt.setInt(2, targetYear);
			stmt.setInt(3, targetMonth);
			System.out.println(stmt);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Cashbook c = new Cashbook();
				c.setCashbookNo(rs.getInt("cashbookNo"));
				c.setCategory(rs.getString("category"));
				c.setPrice(rs.getInt("price"));
				c.setCashbookDate(rs.getString("cashbookDate"));
				list.add(c);
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
		return list;
	}
	
	// 2. 수입과 지출 상세보기
	public List<Cashbook> selectCashbookOne(Connection conn, String memberId, int targetYear, int targetMonth, int targetDate){
		List<Cashbook> list = new ArrayList<Cashbook>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT cashbook_no cashbookNo, category, cashbook_date cashbookDate, price, memo, updatedate, createdate"
				+ " FROM cashbook"
				+ " WHERE member_id=? AND YEAR(cashbook_date)=? AND MONTH(cashbook_date)=? AND DAY(cashbook_date) = ?"
				+ " ORDER BY cashbook_date ASC";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			stmt.setInt(2, targetYear);
			stmt.setInt(3, targetMonth);
			stmt.setInt(4, targetDate);
			System.out.println(stmt);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Cashbook c = new Cashbook();
				c.setCashbookNo(rs.getInt("cashbookNo"));
				c.setCategory(rs.getString("category"));
				c.setCashbookDate(rs.getString("cashbookDate"));
				c.setPrice(rs.getInt("price"));
				c.setMemo(rs.getString("memo"));
				c.setUpdatedate(rs.getString("updatedate"));
				c.setCreatedate(rs.getString("createdate"));
				list.add(c);
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
		return list;
	}
	
	// 3. 수입/지출 내역 추가
	// 반환값 : cashbook_no 키값
	public int insertCashbook(Connection conn, Cashbook cashbook) {
		int cashbookNo = 0;	
		PreparedStatement stmt = null;
		ResultSet rs = null; // 입력후 생성된 키값 반환
		String sql = "INSERT INTO"
				+ " cashbook(member_id, category, cashbook_date, price, memo, updatedate, createdate)"
				+ " VALUES(?, ?, ?, ?, ?, NOW(), NOW())";
		try {			
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cashbook.getMemberId());
			stmt.setString(2, cashbook.getCategory());
			stmt.setString(3, cashbook.getCashbookDate());
			stmt.setInt(4, cashbook.getPrice());
			stmt.setString(5, cashbook.getMemo());
			System.out.println(stmt);
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				cashbookNo = rs.getInt(1);
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
		return cashbookNo;
	}
	// 3-1. 수입/지출 내역 삭제
	public int deleteCashbook(Connection conn, int cashbookNo) {
		int row = 0;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM cashbook"
				+ " WHERE cashbook_no = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cashbookNo);
			System.out.println(stmt);
			row = stmt.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return row;
	}
	
	// 4. 해쉬태그 별 전체 리스트
	public List<Cashbook> selectCashbookListByTag(Connection conn, String memberId, String word, int beginRow, int rowPerPage) {
		List<Cashbook> list = new ArrayList<Cashbook>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT h.cashbook_no cashbookNo, c.category category, c.cashbook_date cashbookDate, c.price price, c.memo memo, c.updatedate updatedate, c.createdate createdate "
					+ " FROM cashbook c INNER JOIN hashtag h"
					+ " ON c.cashbook_no = h.cashbook_no"
					+ " WHERE c.member_id =? AND h.word = ?"
					+ " ORDER BY c.cashbook_date DESC"
					+ " LIMIT ?, ?";
		try {	
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			stmt.setString(2, word);
			stmt.setInt(3, beginRow);
			stmt.setInt(4, rowPerPage);
			System.out.println(stmt);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Cashbook c = new Cashbook();
				c.setCashbookNo(rs.getInt("cashbookNo"));
				c.setCategory(rs.getString("category"));
				c.setCashbookDate(rs.getString("cashbookDate"));
				c.setPrice(rs.getInt("price"));
				c.setMemo(rs.getString("memo"));
				c.setUpdatedate(rs.getString("updatedate"));
				c.setCreatedate(rs.getString("createdate"));
				list.add(c);
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
		return list;
	}
	
	// 5. 해쉬태그 별 전체 개수
	public int selectCashbookListByTagCnt(Connection conn, String memberId, String word) {
		int row = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*)"
				+ " FROM cashbook c INNER JOIN hashtag h"
				+ " ON c.cashbook_no = h.cashbook_no"
				+ " WHERE c.member_id =? AND h.word = ?";
		try {	
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			stmt.setString(2, word);
			
			System.out.println(stmt);
			rs = stmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
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
		return row;
	}
	
	// 6-1. 이번년도 총 지출 금액
	public int selectYearTotalMinus(Connection conn, String memberId, int targetYear) {
		int row = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT SUM(price)"
				+ " FROM cashbook"
				+ " WHERE member_id = ? AND category = '지출' AND YEAR(cashbook_date) = ?";
		try {	
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			stmt.setInt(2, targetYear);
			System.out.println(stmt);
			rs = stmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
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
		return row;
	}
	
	// 6-2. 이번년도 총 수입 금액
	public int selectYearTotalPlus(Connection conn, String memberId, int targetYear) {
		int row = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT SUM(price)"
				+ " FROM cashbook"
				+ " WHERE member_id = ? AND category = '수입' AND YEAR(cashbook_date) = ?";
		try {	
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			stmt.setInt(2, targetYear);
			System.out.println(stmt);
			rs = stmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
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
		return row;
	}
	
	// 7-1. 이번달 총 지출 금액
	public int selectMonthTotalMinus(Connection conn, String memberId, int targetMonth) {
		int row = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT SUM(price)"
				+ " FROM cashbook"
				+ " WHERE member_id = ? AND category = '지출' AND MONTH(cashbook_date) = ?";
		try {	
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			stmt.setInt(2, targetMonth);
			System.out.println(stmt);
			rs = stmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
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
		return row;
	}
	
	// 7-2. 이번달 총 수입 금액
	public int selectMonthTotalPlus(Connection conn, String memberId, int targetMonth) {
		int row = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT SUM(price)"
				+ " FROM cashbook"
				+ " WHERE member_id = ? AND category = '수입' AND MONTH(cashbook_date) = ?";
		try {	
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			stmt.setInt(2, targetMonth);
			System.out.println(stmt);
			rs = stmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
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
		return row;
	}	
}