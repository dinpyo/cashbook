package cash.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cash.service.MemberService;
import cash.vo.Member;

@WebServlet("/on/removeMember")
public class RemoveMemberController extends HttpServlet {
	
	// 비밀번호 입력 폼
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/removeMember.jsp").forward(request, response);
	}

	// 탈퇴
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		String memberPw = request.getParameter("memberPw");
		
		MemberService memberService = new MemberService();
		int row = memberService.deleteMember(loginMember.getMemberId(), memberPw);
		if(row==0) { // 회원탈퇴 실패시
			System.out.println("회원탈퇴 실패");
			response.sendRedirect(request.getContextPath()+"/on/removeMember");
			
		} else if(row==1) { // 회원탈퇴 성공시
			session.invalidate(); // 세션 무효화
			
			System.out.println("회원탈퇴 성공");
			response.sendRedirect(request.getContextPath()+"/off/login");
		} 	
	}

}
