package cash.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cash.service.MemberService;
import cash.vo.Member;

@WebServlet("/off/login")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 유효성검사 LogOffFilter에서 처리
		
		// 쿠키에 저장된 로그인성공된 아이디가 있다면 request속성에 저장해서 view에서 value로 출력 
		Cookie[] cookies = request.getCookies(); // getCookies메서드를 통하여 모든 쿠키값을 배열에 저장
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("cookieLoginId") == true) {
					// request.setAttribute에 찾은 쿠키값 저장
					request.setAttribute("cookieId", c.getValue());
					System.out.println(request.getAttribute("cookieId") + ": 저장한 cookieId");
				}
			}
		}
		
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		Member member = new Member(memberId, memberPw, null, null);
		
		MemberService memberService = new MemberService();
		
		Member loginMember = memberService.selectMemberById(member);
		if(loginMember == null) { // null 로그인실패
			System.out.println("로그인 실패");
			response.sendRedirect(request.getContextPath()+"/off/login");
			return;
		}
		
		String loginId = loginMember.getMemberId();
		
		// 로그인 성공시 : session 사용
		HttpSession session = request.getSession();
		session.setAttribute("loginMember", loginMember);
		
		// idSave 체크박스 값이 넘어왔다면 쿠키에 아이디값저장
		if(request.getParameter("idSave") != null) {
			Cookie loginIdCookie = new Cookie("cookieLoginId",loginId);
			response.addCookie(loginIdCookie);
		}
		
		System.out.println("로그인 성공");
		response.sendRedirect(request.getContextPath()+"/on/cashbook");
	}

}