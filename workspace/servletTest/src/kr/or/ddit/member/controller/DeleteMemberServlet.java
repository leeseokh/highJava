package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

public class DeleteMemberServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.요청 파라미터 정보 가져오기
		String memId = req.getParameter("memId");
		
		//2.서비스 객체 생성하기
		IMemberService memberService = MemberServiceImpl.getInstance();
		
		//3.회원정보 삭제하기
		int cnt = memberService.deleteMember(memId);
		
		String msg ="";
		
		if(cnt>0) {
			msg="성공";
		}else {
			msg="실패";
		}
		
		//4.목록 조회 화면으로 이동.
		String redirectUrl = req.getContextPath() + "/member/list?";
		
		resp.sendRedirect(redirectUrl);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}
