package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO.BoardVO;

public class BoardServiceImpl implements IBoardService{

	private IBoardDao bDao;
	
	public BoardServiceImpl() {
		bDao = BoardDaoImpl.getInstance();
	}
	
	@Override
	public int insertBoard(BoardVO bv) {
		return bDao.insertBoard(bv);
	}
	
	@Override
	public List<BoardVO> DisplayBoardAll() {
		return bDao.DisplayBoardAll();
	}
	@Override
	public int updateBoard(BoardVO bv) {
		return bDao.updateBoard(bv);
	}
	@Override
	public boolean getBoard(int boardNo) {
		return bDao.getBoard(boardNo);
	}
	@Override
	public int DeleteBoard(int boardNo) {
		return bDao.DeleteBoard(boardNo);
	}
	@Override
	public List<BoardVO> SearchBoard(BoardVO bv) {
		return bDao.SearchBoard(bv);
	}	
}