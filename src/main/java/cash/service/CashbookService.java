package cash.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cash.model.CashbookDao;
import cash.model.HashtagDao;
import cash.vo.Cashbook;

public class CashbookService {
	private CashbookDao cashbookDao;
	private HashtagDao hashtagDao;
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
	
	// 3. 수입/지출 내역 추가
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
	
	// 3-1. 수입/지출 내역과 해시태그 동시에 삭제
	public int deleteCashbook(int cashbookNo) {
		this.cashbookDao = new CashbookDao();
		this.hashtagDao = new HashtagDao();
		int cashRow = 0;
		int hashtagRow = 0;
		int totalRow = 0;
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/cash","root","java1234");
			
			// 트랜잭션 처리를 위해 오토 커밋을 종료
			conn.setAutoCommit(false);
			
			hashtagRow = hashtagDao.deleteHashtag(conn, cashbookNo);
			System.out.println(hashtagRow);
			
			if(hashtagRow >= 0) {
				cashRow = cashbookDao.deleteCashbook(conn, cashbookNo);
				System.out.println(cashRow);
				
				// 트랜잭션 처리 후 커밋한다.
				conn.commit();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}  finally {
			try {
				conn.close();
			} catch (SQLException e3) {
				e3.printStackTrace();
			}
		}
		totalRow = cashRow + hashtagRow;
		return totalRow;
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
