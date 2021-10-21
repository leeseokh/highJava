package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import vo.BoardVO;

public class SelectAllBoardServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 서비스 객체 생성
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		// 2. 회원정보 조회
		List<BoardVO> boardList = boardService.getBoardAll();
		
		req.setAttribute("boardList", boardList);
		
		
		// 3. 뷰페이지로 전달
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/board/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
