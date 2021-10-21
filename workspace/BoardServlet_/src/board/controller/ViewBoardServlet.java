package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import vo.BoardVO;

public class ViewBoardServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String boardNo = req.getParameter("boardNo");
		
		// 1. 서비스 객체 생성하기
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		// 2. 회원정보 조회
		BoardVO boardList= boardService.getBoard(boardNo);
		
		// 3. 결과 정보 담기
		req.setAttribute("boardList", boardList);
		
		// 4. VIEW 화면으로 이동
		req.getRequestDispatcher("/board/select.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
}
