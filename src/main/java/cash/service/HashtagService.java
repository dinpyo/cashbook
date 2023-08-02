package cash.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cash.model.HashtagDao;
import cash.vo.Hashtag;

public class HashtagService {
	private HashtagDao hashtagDao;
	Connection conn = null;
	
	// 1. 해시태그 추가
	public int insertHashtag(Hashtag hashtag) {
		this.hashtagDao = new HashtagDao();
		int row = 0;
		try {
			// conn.getAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://3.34.33.114:3306/cash","root","java1234");
			row = hashtagDao.insertHashtag(conn, hashtag);
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
	
	// 2. 해시태그(개수) 조회 
	public List<Map<String, Object>> selectWordCountByMonth(String memberId, int targetYear, int targetMonth){
		this.hashtagDao = new HashtagDao();
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			// conn.getAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://3.34.33.114:3306/cash","root","java1234");
			list = hashtagDao.selectWordCountByMonth(conn, memberId, targetYear, targetMonth);
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
		return list;
	}
	
	// 3. 월 별 해시태그 리스트 상세보기
	public List<Map<String, Object>> selectWordByMonthList(String memberId, int targetYear, int targetMonth, String word){
		this.hashtagDao = new HashtagDao();
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			// conn.getAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://3.34.33.114:3306/cash","root","java1234");
			list = hashtagDao.selectWordByMonthList(conn, memberId, targetYear, targetMonth, word);
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
		return list;
	}
}
