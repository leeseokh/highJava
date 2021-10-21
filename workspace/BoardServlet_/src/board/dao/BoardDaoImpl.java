package board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import vo.BoardVO;

public class BoardDaoImpl implements IBoardDao {

	private static IBoardDao boardDao;
	
	private BoardDaoImpl() {
		
	}
	
	public static IBoardDao getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}
	
	@Override
	public int insertBoard(SqlMapClient smc, BoardVO bv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("board.insertBoard", bv);
		
		if(obj == null) {
			cnt = 1;
		}
		return cnt;

	}

	@Override
	public boolean checkBoard(SqlMapClient smc, String boardNo) throws SQLException {

		boolean check = false;
	
		int count = (int) smc.queryForObject("board.checkBoard", boardNo);
		
		
		if (count > 0) {
			check = true;
		}

		return check;
	}

	@Override
	public List<BoardVO> getBoardAll(SqlMapClient smc) throws SQLException {

		List<BoardVO> boardList = smc.queryForList("board.getBoardAll");
	
		return boardList;
	}

	@Override
	   public int updateBoard(SqlMapClient smc, BoardVO bv) throws SQLException {
	      int cnt = smc.update("board.updateBoard", bv);
	      
	      return cnt;
	   }
	@Override
	public int deleteBoard(SqlMapClient smc, String boardNo) throws SQLException {

		int cnt = smc.delete("board.deleteBoard", boardNo);
		return cnt;
	}

	@Override
	public List<BoardVO> getSearchBoard(SqlMapClient smc, BoardVO bv) throws SQLException {
		List<BoardVO> boardList = smc.queryForList("board.getSearchBoard", bv);
		
		return boardList;
	}
	
	@Override
	public BoardVO getBoard(SqlMapClient smc, String boardNo) throws SQLException {
		
		BoardVO bv = (BoardVO) smc.queryForObject("board.getBoard", boardNo);
		
		return bv;
	}
}