package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import jdbcutil.JDBCUtil;
import jdbcutil.JDBCUtil3;
import jdbcutil.SqlMapClientFactory;
import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVo;

public class MemberServiceImpl implements IMemberService {

	private IMemberDao memDao;

	private static IMemberService memService; // private로 변경

	private SqlMapClient smc;

	private MemberServiceImpl() { // 생성
		memDao = MemberDaoImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}

	public static IMemberService getInstacne() {
		if (memService == null) {
			memService = new MemberServiceImpl();
		}
		return memService;
	}

	@Override
	public int insertMember(MemberVo mv) {
		int cnt = 0;

		try {
			cnt = memDao.insertMember(smc, mv);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public int deleteMember(String memId) {

		int cnt = 0;

		try {
			cnt = memDao.deleteMember(smc, memId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public int updateMember(MemberVo mv) {
		int cnt = 0;

		try {
			cnt = memDao.updateMember(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public List<MemberVo> getAllMemberList() {
		List<MemberVo> memList = new ArrayList<MemberVo>();

		try {
			memList = memDao.getAllMemberList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public boolean checkMember(String memId) {

		boolean chk = false;

		try {
			chk = memDao.getMember(smc, memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public List<MemberVo> getSearchMember(MemberVo mv) {

		List<MemberVo> memList = new ArrayList<>();

		try {
			memList = memDao.getSearchMember(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return memList;
	}

}
