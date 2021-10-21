package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import jdbcutil.JDBCUtil;
import kr.or.ddit.member.vo.MemberVo;

public class MemberDaoImpl implements IMemberDao {

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
	public int insertMember(SqlMapClient smc, MemberVo mv) throws SQLException {
		
		int cnt = 0;
		
		Object obj = smc.insert("member.insertMember", mv);
		
		if(obj == null) {
			cnt = 1;
		}
		return cnt;

	}

	@Override
	public boolean getMember(SqlMapClient smc, String memId) throws SQLException {

		boolean check = false;
		
		int count  = (int) smc.queryForObject("member.getMember", memId);
		
			if (count > 0) {
				check = true;
			}
		return check;
	}

	//전체 출력
	@Override
	public List<MemberVo> getAllMemberList(SqlMapClient smc) throws SQLException {
		
		List<MemberVo> memList = smc.queryForList("member.getMemberAll");
		return memList;
	}

	// 수정
	@Override
	public int updateMember(SqlMapClient smc, MemberVo mv) throws SQLException {

		int cnt = smc.update("member.updateMember", mv);

		return cnt;
	}
	
	//삭제
	@Override
	public int deleteMember(SqlMapClient smc, String memId) throws SQLException {

		int cnt = smc.delete("member.deleteMember", memId);
		
		return cnt;
	}

	// 찾기
	@Override
	public List<MemberVo> getSearchMember(SqlMapClient smc, MemberVo mv) throws SQLException {
		
		List<MemberVo> memList = smc.queryForList("member.getSearchMember", mv);
		
		return memList;
	}
}