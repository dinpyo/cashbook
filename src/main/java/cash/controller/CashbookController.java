package cash.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cash.service.CounterService;

@WebServlet("/on/cashbook")
public class CashbookController extends HttpServlet {
	private CounterService counterService = null;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 접속자 수 카운터
		this.counterService = new CounterService();
		
		int counter = counterService.getCounter();
		int totalConter = counterService.getCounterAll();
		
		request.setAttribute("counter", counter);
		request.setAttribute("totalCounter", totalConter);

		
		
		request.getRequestDispatcher("/WEB-INF/view/cashbook.jsp").forward(request, response);
	}

}