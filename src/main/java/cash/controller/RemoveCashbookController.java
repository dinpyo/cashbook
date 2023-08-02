package cash.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cash.service.CashbookService;

@WebServlet("/on/removeCashbook")
public class RemoveCashbookController extends HttpServlet {
	private CashbookService cashbookService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 유효성검사는 on Filter에서 처리
		int targetYear = Integer.parseInt(request.getParameter("targetYear")); 
		int targetMonth = Integer.parseInt(request.getParameter("targetMonth")); 
		int targetDate = Integer.parseInt(request.getParameter("targetDate"));
		int cashbookNo = Integer.parseInt(request.getParameter("cashbookNo"));
		
		System.out.println(cashbookNo);
		System.out.println(targetYear);
		System.out.println(targetMonth);
		System.out.println(targetDate);
		
		this.cashbookService = new CashbookService();
		
		int row = cashbookService.deleteCashbook(cashbookNo);
		System.out.println(row + "행의 개수");
		
		if(row > 0) {
			System.out.println("삭제 성공");
			response.sendRedirect(request.getContextPath()+"/on/cashbookOne?targetYear="+targetYear+"&targetMonth="+targetMonth+"&targetDate="+targetDate);
		}
	}

}
