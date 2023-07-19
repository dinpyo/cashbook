package cash.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cash.model.HashtagDao;
import cash.service.HashtagService;
import cash.vo.Member;


@WebServlet("/on/hashtagOne")
public class HashtagOneController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 인증 검사
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginMember");
		String memberId = member.getMemberId();	
		
		int targetYear = Integer.parseInt(request.getParameter("targetYear"));
		int targetMonth = Integer.parseInt(request.getParameter("targetMonth"));
		String word = request.getParameter("word");
		
		// 모델을 호출(월별 해시태그들 리스트)
		List<Map<String, Object>> list = new HashtagService().selectWordByMonthList(memberId, targetYear, targetMonth+1, word);
		
		request.setAttribute("list", list);
		request.setAttribute("word", word);
		
		request.setAttribute("targetYear", targetYear);
		request.setAttribute("targetMonth", targetMonth);
	
		// 출력하는 뷰
		request.getRequestDispatcher("/WEB-INF/view/hashtagOne.jsp").forward(request, response);
		
	}

}
