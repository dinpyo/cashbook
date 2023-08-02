package cash.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cash.vo.Hashtag;

public class HashtagDao {
	// 1. 해시태그 추가
	public int insertHashtag(Connection conn, Hashtag hashtag) {
		PreparedStatement stmt = null;
		int row = 0;
		String sql = "INSERT INTO hashtag(cashbook_no, word, updatedate, createdate)"
				+ " VALUES(?, ?, NOW(), NOW())";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, hashtag.getCashbookNo());
			stmt.setString(2, hashtag.getWord());
			System.out.println(stmt);
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
	
	// 1-1. 해시태그 삭제
	public int deleteHashtag(Connection conn, int cashbookNo) {
		PreparedStatement stmt = null;
		int row = 0;
		String sql = "DELETE FROM hashtag"
				+ " WHERE cashbook_no = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cashbookNo);
			System.out.println(stmt);
			row = stmt.executeUpdate();			
		} catch(Exception e1) {
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
	
	
	// 2. 해시태그(개수) 조회
	public List<Map<String, Object>> selectWordCountByMonth(Connection conn, String memberId, int targetYear, int targetMonth){
		List<Map<String, Object>> list = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT word, COUNT(*) cnt"
				+ " FROM hashtag h INNER JOIN cashbook c"
				+ " ON h.cashbook_no = c.cashbook_no"
				+ " WHERE c.member_id = ?"
				+ " AND YEAR(c.cashbook_date) = ?"
				+ " AND MONTH(c.cashbook_date) = ?"
				+ " GROUP BY word"
				+ " ORDER BY COUNT(*) DESC";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			stmt.setInt(2, targetYear);
			stmt.setInt(3, targetMonth);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<>();
				m.put("word", rs.getString("word"));
				m.put("cnt", rs.getInt("cnt"));
				list.add(m);
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
		return list;
	}

	// 3. 월 별 해시태그 리스트 상세보기 
	public List<Map<String, Object>> selectWordByMonthList(Connection conn,String memberId, int targetYear, int targetMonth, String word){
		List<Map<String, Object>> list = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT h.cashbook_no cashbookNo, c.category category, c.cashbook_date cashbookDate, c.price price, c.memo memo, c.updatedate updatedate, c.createdate createdate, SUBSTRING(c.cashbook_date, 9 ,10) targetDate"
				+ " FROM hashtag h INNER JOIN cashbook c"
				+ " ON h.cashbook_no = c.cashbook_no"
				+ " WHERE c.member_id= ? AND YEAR(c.cashbook_date) = ? AND MONTH(c.cashbook_date) = ? AND h.word = ?"
				+ " ORDER BY c.cashbook_date DESC";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			stmt.setInt(2, targetYear);
			stmt.setInt(3, targetMonth);
			stmt.setString(4, word);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<>();
				m.put("cashbookNo", rs.getInt("cashbookNo"));
				m.put("category", rs.getString("category"));
				m.put("cashbookDate", rs.getString("cashbookDate"));
				m.put("price", rs.getString("price"));
				m.put("memo", rs.getString("memo"));
				m.put("updatedate", rs.getString("updatedate"));
				m.put("createdate", rs.getString("createdate"));
				m.put("targetDate", rs.getString("targetDate"));
				list.add(m);
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
		return list;
	}		
}
