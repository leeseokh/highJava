package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.member.vo.MemberVo;

public class MemberDaoImpl implements IMemberDao {

	private static IMemberDao memDao;
	
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
	public boolean checkMember(SqlMapClient smc, String memId) throws SQLException {

		boolean check = false;
	
		int count = (int) smc.queryForObject("member.checkMember", memId);
		
		
		if (count > 0) {
			check = true;
		}

		return check;
	}

	@Override
	public List<MemberVo> getAllMemberList(SqlMapClient smc) throws SQLException {

		List<MemberVo> memList = smc.queryForList("member.getMemberAll");
	
		return memList;
	}

	@Override
	public int updateMember(SqlMapClient smc, MemberVo mv) throws SQLException {
		int cnt = smc.update("member.updateMember", mv);

		return cnt;

	}
	@Override
	public int deleteMember(SqlMapClient smc, String memId) throws SQLException {

		int cnt = smc.delete("member.deleteMember", memId);
		return cnt;
	}

	@Override
	public List<MemberVo> getSearchMember(SqlMapClient smc, MemberVo mv) throws SQLException {
		List<MemberVo> memList = smc.queryForList("member.getSearchMember", mv);
		
		return memList;
	}
	
	@Override
	public MemberVo getMember(SqlMapClient smc, String memId) throws SQLException {
		
		MemberVo mv = (MemberVo) smc.queryForObject("member.getMember",memId);
		
		return mv;
	}

	

}