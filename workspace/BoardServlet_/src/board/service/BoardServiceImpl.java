package board.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import JDBCUtil.SqlMapClientFactory;
import board.dao.BoardDaoImpl;
import board.dao.IBoardDao;
import vo.BoardVO;

public class BoardServiceImpl implements IBoardService{

	private static IBoardDao boardDao;
	
	private static IBoardService boardService;
	public static IBoardService getInstance() {
		if(boardService == null) {
			boardService = new BoardServiceImpl();
		}
		return boardService;
	}
	
	private SqlMapClient smc; 
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	@Override
	public int insertBoard(BoardVO bv) {

		int cnt = 0;
		try {
			cnt =  boardDao.insertBoard(smc, bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt; 
	}
	@Override
	public int deleteBoard(String boardNo) {

		int cnt = 0;
		
		try {
			boardDao.deleteBoard(smc,boardNo);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	@Override
	public int updateBoard(BoardVO bv) {

		int cnt = 0;
		
		try {
			cnt = boardDao.updateBoard(smc, bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	@Override
	public List<BoardVO> getBoardAll() {
	
		List<BoardVO> boardList = new ArrayList<BoardVO>();

		try {
			boardList = boardDao.getBoardAll(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}
	@Override
	public boolean checkBoard(String boardNo) {
	
		boolean chk = false;
		try {
			chk = boardDao.checkBoard(smc, boardNo);
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
		}
		
		return chk;
	}
	@Override
	public List<BoardVO> getSearchBoard(BoardVO bv) {

		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			boardList = boardDao.getSearchBoard(smc, bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return boardList;
	}
	@Override
	public BoardVO getBoard(String boardNo) {
	
		BoardVO bv = null;
		try {
			bv = boardDao.getBoard(smc, boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bv;
	}
}




















