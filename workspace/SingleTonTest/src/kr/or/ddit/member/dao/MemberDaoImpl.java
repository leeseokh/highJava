package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbcutil.JDBCUtil;
import kr.or.ddit.member.vo.MemberVo;

public class MemberDaoImpl implements IMemberDao {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static IMemberDao memDao;	//변수선언은 인터페이스 기반 위주.

	private MemberDaoImpl() {
		
	}
	
	public static IMemberDao getInstance() {
		if(memDao == null) {
			memDao = new MemberDaoImpl();
		}
		
		return memDao;
	}
	@Override
	public int insertMember(Connection conn, MemberVo mv) throws SQLException {

		String sql = "insert into mymember " + " (mem_id, mem_name, mem_tel, mem_addr) "
											 + " values (?, ?, ?, ?) ";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mv.getMemId());
		pstmt.setString(2, mv.getMemName());
		pstmt.setString(3, mv.getMemTel());
		pstmt.setString(4, mv.getMemAddr());

		int cnt = pstmt.executeUpdate();
		
		JDBCUtil.disConnect(null, stmt, pstmt, rs);
		return cnt;

	}

	@Override
	public boolean getMember(Connection conn, String memId) throws SQLException {

		boolean check = false;

			String sql = " select count(*) cnt from mymember " + " where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId); // 첫번째 물음표 위치

			rs = pstmt.executeQuery();

			int count = 0;

			if (rs.next()) {
				count = rs.getInt("cnt");
			}

			if (count > 0) {
				check = true;
			}
		return check;
	}

	@Override
	public List<MemberVo> getAllMemberList(Connection conn) throws SQLException {
		
		List<MemberVo> memList = new ArrayList<>();

		String sql = " select * from mymember ";

		stmt = conn.createStatement();

		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			MemberVo mv = new MemberVo();
			
			mv.setMemId(rs.getString("mem_id"));
			mv.setMemName(rs.getString("mem_name"));
			mv.setMemTel(rs.getString("mem_tel"));
			mv.setMemAddr(rs.getString("mem_addr"));
			
			memList.add(mv);
		}
		return memList;
	}

	@Override
	public int updateMember(Connection conn, MemberVo mv) throws SQLException {

		String sql = "update mymember " + " set mem_name = ? " + "    ,mem_tel = ? " + "    ,mem_addr = ? "
				+ " where mem_id = ? ";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mv.getMemName());
		pstmt.setString(2, mv.getMemTel());
		pstmt.setString(3, mv.getMemAddr());
		pstmt.setString(4, mv.getMemId());

		int cnt = pstmt.executeUpdate();
		return cnt;

	}

	@Override
	public int deleteMember(Connection conn, String memId) throws SQLException {

		String sql = "delete from mymember where mem_id = ? ";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memId);

		int cnt = pstmt.executeUpdate();
		return cnt;
	}

	@Override
	public List<MemberVo> getSearchMember(Connection conn, MemberVo mv) throws SQLException {
		List<MemberVo> memList = new ArrayList<>();
		
		String sql = "select * from mymember where 1=1";
		
		if(mv.getMemId() !=null && !mv.getMemId().equals("")) {	//id가 존재 할 때만
			sql += " and mem_id = ? ";
		}
		if(mv.getMemName() !=null && !mv.getMemName().equals("")) {	
			sql += " and mem_name = ? ";
		}
		if(mv.getMemTel() !=null && !mv.getMemTel().equals("")) {
			sql += " and mem_tel like '%' || ? || '%' ";
		}
		if(mv.getMemAddr() !=null && !mv.getMemAddr().equals("")) {
			sql += " and mem_addr like '%' || ? || '%' ";
		}
		
		pstmt = conn.prepareStatement(sql);
		
		int index = 1;
		
		if(mv.getMemId() !=null && !mv.getMemId().equals("")) {	
			pstmt.setString(index++, mv.getMemId());
		}
		if(mv.getMemName() !=null && !mv.getMemName().equals("")) {	
			pstmt.setString(index++, mv.getMemName());
		}
		if(mv.getMemTel() !=null && !mv.getMemTel().equals("")) {
			pstmt.setString(index++, mv.getMemTel());
		}
		if(mv.getMemAddr() !=null && !mv.getMemAddr().equals("")) {
			pstmt.setString(index++, mv.getMemAddr());
		}
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			MemberVo mv2 = new MemberVo();
			
			mv2.setMemId(rs.getString("mem_id"));
			mv2.setMemName(rs.getString("mem_name"));
			mv2.setMemTel(rs.getString("mem_tel"));
			mv2.setMemAddr(rs.getString("mem_addr"));
			
			memList.add(mv2);
		}
		
		return memList;
}
	
	
	
	
	
	
	
	
	
	
}