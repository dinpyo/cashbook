package cash.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cash.model.CashbookDao;
import cash.vo.Cashbook;

public class CashbookService {
	private CashbookDao cashbookDao;
	Connection conn = null;
	
	// 1. 달력에 수입/지출 표시
	public List<Cashbook> selectCashbookListByMonth(String memberId, int targetYear, int targetMonth) {
		this.cashbookDao = new CashbookDao();
		List<Cashbook> list = new ArrayList<Cashbook>();
		try {
			// conn.getAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/cash","root","java1234");
			list = cashbookDao.selectCashbookListByMonth(conn, memberId, targetYear, targetMonth);
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
	
	// 2. 수입과 지출 상세보기
	public List<Cashbook> selectCashbookOne(String memberId, int targetYear, int targetMonth, int targetDate){
		this.cashbookDao = new CashbookDao();
		List<Cashbook> list = new ArrayList<Cashbook>();
		try {
			// conn.getAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/cash","root","java1234");
			list = cashbookDao.selectCashbookOne(conn, memberId, targetYear, targetMonth, targetDate);
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
	
	// 3. 수입/지출 등록
	public int insertCashbook(Cashbook cashbook) {
		this.cashbookDao = new CashbookDao();
		int row = 0;
		try {
			// conn.getAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/cash","root","java1234");
			row = cashbookDao.insertCashbook(conn, cashbook);
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
	
	// 4. 해쉬태그 별 전체 리스트
	public List<Cashbook> selectCashbookListByTag(String memberId, String word, int beginRow, int rowPerPage) {
		this.cashbookDao = new CashbookDao();
		List<Cashbook> list = new ArrayList<Cashbook>();
		try {
			// conn.getAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/cash","root","java1234");
			list = cashbookDao.selectCashbookListByTag(conn, memberId, word, beginRow, rowPerPage);
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
	
	// 5. 해쉬태그 별 전체 개수
	public int selectCashbookListByTagCnt(String memberId, String word) {
		this.cashbookDao = new CashbookDao();
		int row = 0;
		try {
			// conn.getAutoCommit(false);
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/cash","root","java1234");
			row = cashbookDao.selectCashbookListByTagCnt(conn, memberId, word);
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
