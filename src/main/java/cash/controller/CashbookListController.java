package cash.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cash.service.CashbookService;
import cash.vo.Cashbook;
import cash.vo.Member;

@WebServlet("/on/cashbookListByTag")
public class CashbookListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		
		String word = request.getParameter("word");
		
		// 현재페이지
		int currentPage = 1;
		if(request.getParameter("currentPage") != null ){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		// 페이지당 출력할 행의 수
		int rowPerPage = 5;
		
		// 페이지당 시작 행번호
		int beginRow = (currentPage-1)*rowPerPage;
		
		CashbookService cashbookService = new CashbookService();
		
		// 총 행의 개수
		int totalRow = cashbookService.selectCashbookListByTagCnt(memberId, word);
		
		// 마지막 행의 페이지
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage++;
		}
		
		List<Cashbook> list = cashbookService.selectCashbookListByTag(memberId, word, beginRow, rowPerPage);
		
		request.setAttribute("list", list);
		request.setAttribute("word", word);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("memberId", memberId);
		
		
		request.getRequestDispatcher("/WEB-INF/view/cashbookListByTag.jsp").forward(request, response);
	}

}
