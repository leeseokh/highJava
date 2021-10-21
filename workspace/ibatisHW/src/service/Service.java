package service;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.vo.BoardVO;
import dao.Dao;
import util.JDBCUtil;

public class Service {
	
	private Dao dao = new Dao();
	
	public int insertVo(BoardVO vo) {
		
		Connection conn = JDBCUtil.getConnection();
		int cnt = 0;
		
		try {
			cnt = dao.insertVo(conn, vo);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	public int deleteVo(String board_no) {
		Connection conn = JDBCUtil.getConnection();
		int cnt = 0;
		try {
			cnt = dao.deleteVo(conn, board_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	
	public int updateVo(BoardVO vo) {
		Connection conn = JDBCUtil.getConnection();
		int cnt = 0;
		try {
			cnt = dao.updateVo(conn, vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	public List<BoardVO> searchVo(BoardVO vo){
		Connection conn = JDBCUtil.getConnection();
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			list = dao.searchVo(conn, vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<BoardVO> displayVoAll(){
		Connection conn = JDBCUtil.getConnection();
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			list = dao.displayVoAll(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public String nextVo() {
		Connection conn = JDBCUtil.getConnection();
		String next = "";
		try {
			next = dao.nextVo(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return next;
	}
	
	public boolean checkVo(String board_no) {
		Connection conn = JDBCUtil.getConnection();
		boolean chk = false;
		try {
			chk = dao.checkVo(conn, board_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chk;
	}
	
}
