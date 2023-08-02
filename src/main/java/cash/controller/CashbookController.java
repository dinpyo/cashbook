package cash.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cash.service.CounterService;
import cash.vo.Member;

@WebServlet("/on/cashbook")
public class CashbookController extends HttpServlet {
	private CounterService counterService = null;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		
		// 접속자 수 카운터
		this.counterService = new CounterService();
		
		int counter = counterService.getCounter();
		int totalConter = counterService.getCounterAll();
		
		request.setAttribute("counter", counter);
		request.setAttribute("totalCounter", totalConter);

		// view에 넘겨줄 달력정보(모델값)
		Calendar firstDay = Calendar.getInstance(); // 오늘날짜
				
		int targetYear = firstDay.get(Calendar.YEAR);
		int targetMonth = firstDay.get(Calendar.MONTH);		
		int targetDate = firstDay.get(Calendar.DATE);		
		
		request.setAttribute("targetYear", targetYear);
		request.setAttribute("targetMonth", targetMonth);		
		request.setAttribute("targetDate", targetDate);	
		
		request.setAttribute("memberId", memberId);	
		
		request.getRequestDispatcher("/WEB-INF/view/cashbook.jsp").forward(request, response);
	}

}