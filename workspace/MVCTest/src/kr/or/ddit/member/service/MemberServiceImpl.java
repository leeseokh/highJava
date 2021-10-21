package kr.or.ddit.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbcutil.JDBCUtil;
import jdbcutil.JDBCUtil3;
import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVo;

public class MemberServiceImpl implements IMemberService {
	
	private IMemberDao memDao;
	
	public MemberServiceImpl() {
		memDao = new MemberDaoImpl();
	}

	@Override
	public int insertMember(MemberVo mv) {
		Connection conn = JDBCUtil3.getConnection();
		int cnt = 0;
		
		try {
			cnt= memDao.insertMember(conn, mv);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCUtil.disConnect(conn,null, null, null);
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		
		int cnt = 0; 
	    Connection conn = JDBCUtil3.getConnection();
	    
	    try {
	    	cnt = memDao.deleteMember(conn, memId);
	    	
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }finally {
	    	JDBCUtil.disConnect(conn,null, null, null);
	    }
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVo mv) {
		int cnt = 0;
		
		Connection conn = JDBCUtil3.getConnection();
		
		try {
			cnt = memDao.updateMember(conn, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.disConnect(conn,null, null, null);
		}
		
		return cnt;
	}

	@Override
	public List<MemberVo> getAllMemberList() {
		List<MemberVo> memList = new ArrayList<MemberVo>();
		
		Connection conn = JDBCUtil.getConnection();
		
		try {
			memList = memDao.getAllMemberList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.disConnect(conn,null, null, null);
		}
		return memList;
	}

	@Override
	public boolean checkMember(String memId) {
		
		boolean chk = false;
		
		Connection conn = JDBCUtil.getConnection();
		try {
			chk  = memDao.getMember(conn, memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.disConnect(conn,null, null, null);
		}
		return chk;
	}

	@Override
	public List<MemberVo> getSearchMember(MemberVo mv) {
		
		List<MemberVo> memList = new ArrayList<>();
		
		Connection conn = JDBCUtil.getConnection();
		
			try {
				memList = memDao.getSearchMember(conn, mv);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
			JDBCUtil.disConnect(conn,null, null, null);
			}
		
		return memList;
	}
		
}

