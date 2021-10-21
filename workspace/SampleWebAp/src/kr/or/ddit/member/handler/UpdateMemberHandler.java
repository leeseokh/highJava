package kr.or.ddit.member.handler;

import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.cmm.handler.CommandHandler;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

public class UpdateMemberHandler implements CommandHandler {
	
	private static final String VIEW_PAGE 
				= "/WEB-INF/views/member/updateForm.jsp";
	
	private IMemberService memService = MemberServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return false; // forward
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return true; // redirect
		}
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			
			String memId = req.getParameter("memId");
			
			// 2. 회원정보 조회
			MemberVO memVO = memService.getMember(memId);
			
			// 3. request객체에 회원정보 저장
			req.setAttribute("memVO", memVO);
			
			return VIEW_PAGE;
			
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			
			// 1. 요청파라미터 정보 가져오기
			String memId = req.getParameter("memId");
			String memName = req.getParameter("memName");
			String memTel = req.getParameter("memTel");
			String memAddr = req.getParameter("memAddr");
			
			MemberVO mv = new MemberVO();
			mv.setMemId(memId);
			mv.setMemName(memName);
			mv.setMemTel(memTel);
			mv.setMemAddr(memAddr);
			
			// 3. 회원정보 수정하기
			int cnt = memService.updateMember(mv);
			
			String msg = "";
			if( cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			
			String redirecURL = req.getContextPath() 
					+ "/member/list.do?msg=" + URLEncoder.encode(msg, "utf-8");
			
			return redirecURL;
		}
		
		return null;
	}

}
