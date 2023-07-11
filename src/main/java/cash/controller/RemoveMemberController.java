package cash.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cash.model.MemberDao;
import cash.vo.Member;

@WebServlet("/removeMember")
public class RemoveMemberController extends HttpServlet {
	

	// 비밀번호 입력 폼
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/removeMember.jsp").forward(request, response);
	}

	// 탈퇴
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		String memberPw = request.getParameter("memberPw");
		
		MemberDao memberDao = new MemberDao();
		int row = memberDao.deleteMember(loginMember.getMemberId(), memberPw);
		if(row==0) { // 회원탈퇴 실패시
			System.out.println("회원탈퇴 실패");
			response.sendRedirect(request.getContextPath()+"/removeMember");
			
		} else if(row==1) { // 회원탈퇴 성공시
			session.invalidate(); // 세션 무효화
			
			System.out.println("회원탈퇴 성공");
			response.sendRedirect(request.getContextPath()+"/login");
		} 	
	}

}
