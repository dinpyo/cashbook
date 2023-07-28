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

@WebServlet("/on/modifyMember")
public class ModifyMemberController extends HttpServlet {
	
	// 회원정보 수정 폼
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/modifyMember.jsp").forward(request, response);
	}
	
	// 회원정보 수정
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		String memberPw = request.getParameter("memberPw");
		String newPw1 = request.getParameter("newPw1");
		String newPw2 = request.getParameter("newPw2");
		
		// Dao 호출
		MemberService memberService = new MemberService();
		int row = memberService.updateMember(loginMember.getMemberId(), memberPw, newPw1, newPw2);
		
		if(row==0) { // 회원정보 수정 실패시
			System.out.println("회원정보 수정 실패");
			response.sendRedirect(request.getContextPath()+"/on/modifyMember");
		} else if(row==1) { // 회원정보 수정 성공시
			System.out.println("회원정보 수정 성공");
			response.sendRedirect(request.getContextPath()+"/logout");
		}
	}

}
