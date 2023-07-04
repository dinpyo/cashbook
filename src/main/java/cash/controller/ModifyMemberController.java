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


@WebServlet("/modifyMember")
public class ModifyMemberController extends HttpServlet {
	
	// 회원정보 수정 폼
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 검사
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/modifyMember.jsp").forward(request, response);
	}
	
	// 회원정보 수정
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 검사
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			response.sendRedirect(request.getContextPath()+"/cashbook");
			return;
		}
		
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		String memberPw = request.getParameter("memberPw");
		String newPw1 = request.getParameter("newPw1");
		String newPw2 = request.getParameter("newPw2");
		
		MemberDao memberDao = new MemberDao();
		int row = memberDao.updateMember(loginMember.getMemberId(), memberPw, newPw1, newPw2);
		if(row==0) { // 회원정보 수정 실패시
			System.out.println("회원정보 수정 실패");
			response.sendRedirect(request.getContextPath()+"/modifyMember");
		} else if(row==1) { // 회원정보 수정 성공시
			System.out.println("회원정보 수정 성공");
			response.sendRedirect(request.getContextPath()+"/login");
		}
	}

}
