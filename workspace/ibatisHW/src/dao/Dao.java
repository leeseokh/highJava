package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.vo.BoardVO;
import util.JDBCUtil;

public class Dao {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	

	public int insertVo(Connection conn, BoardVO vo) throws SQLException {
		
		int cnt = 0;
		
		String sql = " insert into jdbc_board (board_no,board_writer,board_title,board_content,board_date) values (?, ?, ?, ?, SYSDATE) ";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getBoard_no());
		pstmt.setString(2, vo.getBoard_writer());
		pstmt.setString(3, vo.getBoard_title());
		pstmt.setString(4, vo.getBoard_content());
		
		cnt = pstmt.executeUpdate();
		JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		
		return cnt;
	}
	public int deleteVo(Connection conn, String board_no) throws SQLException {
		int cnt = 0;
		String sql = "delete from jdbc_board where board_no = ? ";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board_no);
		cnt = pstmt.executeUpdate();
		JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		return cnt;
	}
	
	public int updateVo(Connection conn, BoardVO vo) throws SQLException {
		
		int cnt = 0;
		
		String sql = "UPDATE jdbc_board " + 
				" SET board_writer = ?, board_title= ?, board_content= ?, board_date = sysdate " + 
				" WHERE board_no = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getBoard_writer());
		pstmt.setString(2, vo.getBoard_title());
		pstmt.setString(3, vo.getBoard_content());
		pstmt.setString(4, vo.getBoard_no());
		
		cnt = pstmt.executeUpdate();
		JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		return cnt;
	}
	
	public List<BoardVO> displayVoAll(Connection conn) throws SQLException {
		List<BoardVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM jdbc_board";
		
		stmt = conn.createStatement();
		
		 rs = stmt.executeQuery(sql);
		 
		 while(rs.next()) {
			 BoardVO vo = new BoardVO();
			 vo.setBoard_no(rs.getString("board_no"));
			 vo.setBoard_writer(rs.getString("board_writer"));
			 vo.setBoard_title(rs.getString("board_title"));
			 vo.setBoard_content(rs.getString("board_content"));
			 vo.setBoard_date(rs.getString("board_date"));
			 list.add(vo);
		 }
		 JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		return list;
	}
	
	public List<BoardVO> searchVo(Connection conn, BoardVO vo) throws SQLException {
		
		List<BoardVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM jdbc_board WHERE 1 = 1 ";
		
		if(vo.getBoard_no() != null && !vo.getBoard_no().equals("")) {
			sql += " and board_no = ? " ;
		}
		if(vo.getBoard_writer() != null && !vo.getBoard_writer().equals("")) {
			sql += " and board_writer = ? " ;
		}
		if(vo.getBoard_title() != null && !vo.getBoard_title().equals("")) {
			sql += " and board_title = ? " ;
		}
//		if(vo.getBoard_date() != null && !vo.getBoard_date().equals("")) {
//			sql += " and board_date like '%' || ? || '%' " ;
//		}
		if(vo.getBoard_content() != null && !vo.getBoard_content().equals("")) {
			sql += " and board_content like '%' || ? || '%' " ;
		}
		
		pstmt = conn.prepareStatement(sql);
		
		int index = 1;
		
		if(vo.getBoard_no() != null && !vo.getBoard_no().equals("")) {
			pstmt.setString(index++, vo.getBoard_no());
		}
		if(vo.getBoard_writer() != null && !vo.getBoard_writer().equals("")) {
			pstmt.setString(index++, vo.getBoard_writer());
		}
		if(vo.getBoard_title() != null && !vo.getBoard_title().equals("")) {
			pstmt.setString(index++, vo.getBoard_title());
		}
//		if(vo.getBoard_date() != null && !vo.getBoard_date().equals("")) {
//			pstmt.setString(index++, vo.getBoard_date());
//		}
		
		
		rs = pstmt.executeQuery();
		 
		 while(rs.next()) {
			 BoardVO vo2 = new BoardVO();
			 vo2.setBoard_no(rs.getString("board_no"));
			 vo2.setBoard_writer(rs.getString("board_writer"));
			 vo2.setBoard_title(rs.getString("board_title"));
			 vo2.setBoard_content(rs.getString("board_content"));
			 vo2.setBoard_date(rs.getString("board_date"));
			 list.add(vo2);
		 }
		 JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		return list;
	}
	public String nextVo(Connection conn) throws SQLException {
		
		String nextVal = "";
		
		String sql = "select board_seq.nextVal from dual";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			nextVal = rs.getString("nextVal");
		}
		JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		return nextVal;
	}
	
	public boolean checkVo(Connection conn, String board_no) throws SQLException {
		boolean check = false;
		String sql = "select count(*) cnt from jdbc_board " + "where board_no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board_no);

		rs = pstmt.executeQuery();

		int count = 0;

		if (rs.next()) {
			count = rs.getInt("cnt");
		}
		if (count > 0) {
			check = true;
		}
		JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		return check;
	}
	
}
