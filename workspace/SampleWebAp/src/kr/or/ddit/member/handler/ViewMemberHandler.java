package kr.or.ddit.member.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.cmm.handler.CommandHandler;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

public class ViewMemberHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/views/member/select.jsp";
	
	private IMemberService memService = MemberServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
			
		String memId = req.getParameter("memId");
		
		// 2. 회원정보 조회
		MemberVO memVO = memService.getMember(memId);
		
		// 3. 결과 정보 담기
		req.setAttribute("memVO", memVO);
		
		return VIEW_PAGE;
	}

}
