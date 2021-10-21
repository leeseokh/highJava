package board.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import vo.BoardVO;

public class UpdateBoardServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String boardNo = req.getParameter("boardNo");
		
		// 1.서비스 객체 생성
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		// 2. 회원정보 조회
		BoardVO boardVO = boardService.getBoard(boardNo);
		
		// 3. request객체에 회원정보 저장
		req.setAttribute("boardVO", boardVO);
		
		// 4. view 화면으로 이동
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/board/updateForm.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 요청파라미터 정보 가져오기
		String boardNo = req.getParameter("boardNo");
		String boardTitle = req.getParameter("boardTitle");
		String boardWriter = req.getParameter("boardWriter");
		String boardDate = req.getParameter("boardDate");
		String boardContent = req.getParameter("boardContent");
		
		BoardVO bv = new BoardVO();
		bv.setBoardNo(boardNo);
		bv.setBoardTitle(boardTitle);
		bv.setBoardWriter(boardWriter);
		bv.setBoardDate(boardDate);
		bv.setBoardContent(boardContent);
		
		// 2. 서비스 객체 생성하기
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		// 3. 회원정보 수정하기
		int cnt = boardService.updateBoard(bv);
		
		String msg = "";
		if( cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		// 4. 목록 조회화면으로 이동
		//req.getRequestDispatcher("/member/list").forward(req, resp);
		resp.sendRedirect(req.getContextPath() 
				+ "/board/list?msg=" + URLEncoder.encode(msg, "utf-8"));
		
		
		
		
		
		
		
		
		
	}
}
