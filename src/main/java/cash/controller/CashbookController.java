package cash.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cash.service.CounterService;

@WebServlet("/cashbook")
public class CashbookController extends HttpServlet {
	private CounterService counterService = null;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 인증 검사 코드
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		// 접속자 수 
		this.counterService = new CounterService();
		
		int counter = counterService.getCounter();
		int totalConter = counterService.getCounterAll();
		
		request.setAttribute("counter", counter);
		request.setAttribute("totalCounter", totalConter);

		
		
		request.getRequestDispatcher("/WEB-INF/view/cashbook.jsp").forward(request, response);
	}

}