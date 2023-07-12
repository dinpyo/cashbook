package cash.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cash.model.HashtagDao;
import cash.model.CashbookDao;
import cash.vo.Hashtag;
import cash.vo.Member;
import cash.vo.Cashbook;


@WebServlet("/on/addCashbook")
public class AddCashbookController extends HttpServlet {
	// 입력 폼
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 매개값
		int targetYear = Integer.parseInt(request.getParameter("targetYear"));
		int targetMonth = Integer.parseInt(request.getParameter("targetMonth"));
		int targetDate = Integer.parseInt(request.getParameter("targetDate"));
		
		request.setAttribute("targetYear", targetYear);
		request.setAttribute("targetMonth", targetMonth);
		request.setAttribute("targetDate", targetDate);
				
		request.getRequestDispatcher("/WEB-INF/view/addCashbook.jsp").forward(request, response);
	}
	
	 
	// 입력 액션
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// session 검사
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		
		// request 매개값	
		String targetYear = request.getParameter("targetYear");
		String targetMonth = request.getParameter("targetMonth");
		String targetDate =request.getParameter("targetDate");		
 
		String category =  request.getParameter("category");
		String cashbookDate =  request.getParameter("cashbookDate");
		int price = Integer.parseInt(request.getParameter("price"));
		String memo =  request.getParameter("memo");

		Cashbook cashbook = new Cashbook();
		cashbook.setMemberId(memberId);
		cashbook.setCategory(category);
		cashbook.setCashbookDate(cashbookDate);
		cashbook.setPrice(price);
		cashbook.setMemo(memo);
		
		CashbookDao cashbookDao = new CashbookDao();
		int cashbookNo = cashbookDao.insertCashbook(cashbook); // 키값 반환
		
		// 입력 실패시
		if(cashbookNo == 0) {
			System.out.println("입력실패");
			response.sendRedirect(request.getContextPath()+"/on/addCashbook?targetYear="+targetYear+"&targetMonth="+targetMonth+"&targetDate="+targetDate);
			return;
		}
	
		// 입력성공시 -> 해시태그가 있다면 -> 해시태그 추출 -> 해시태그 입력(반복)
		// 해시태그 추출 알고리즘
		//  # #구디 #구디 #자바
		HashtagDao hashtagDao = new HashtagDao();
		String memo1 = cashbook.getMemo();
		String memo2 = memo1.replace("#", " #"); // "#구디#아카데미" -> " #구디 #아카데미"
		
		Set<String> set = new HashSet<String>(); // 중복된 해시태그방지를 위해 set자료구조를 사용
			
		// 해시태그가 여려개이면 반복해서 입력
		for(String ht : memo2.split(" ")) { // issue : split된 배열을 Set으로 변경하면 중복된 내용 제거 가능
			if (ht.startsWith("#")) {
                String ht2 = ht.replace("#", "");
			    if(ht2.length() > 0) {
                    set.add(ht2); // set은 중복된 값은 add되지 않는다
			    }
            }
		}
		
		for(String s : set) {
			Hashtag hashtag = new Hashtag();
			hashtag.setCashbookNo(cashbookNo);
			hashtag.setWord(s);
			hashtagDao.insertHashtag(hashtag);
		}
	
		// redirect -> cashbookOneController -> forward -> cashbookOne.jsp
		response.sendRedirect(request.getContextPath()+"/on/calendar");
	}
}
