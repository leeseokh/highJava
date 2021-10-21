package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.member.vo.MemberVo;

/*
 	실제 DB와 연결해서 SQL문을 수행한 결과를 작성하여 
 	Service에 전달하는 DAO의 Interface
 */

public interface IMemberDao {
	/*
	 	MemberVo에 담겨진 자료를 DB에 insert하는 메서드
	 	smc SqlMapClient 객체
	 	mv: DB에 insert할 자료가 저장된 회원정보
	 	DB작업이 성공하면 1 이상의 값이 반환되고, 실패하면 0이 반환된다.
	 	SQLException JDBC관련 예외 객체
	 */
	public int insertMember(SqlMapClient smc, MemberVo mv) throws SQLException;
	
	/**
	 * 주어진 회원 ID가 존재하는지 여부를 알아내는 메서드
	 * @param smc SqlMapClient 
	 * @param memId 검색할 회원ID
	 * @return 해당 회원ID가 있으면 true, 없으면 false
	 * @throws SQLException JDBC관련 예외 객체
	 */
	public boolean getMember(SqlMapClient smc, String memId) throws SQLException;
	
	/**
	 * DB의 mymember 테이블 전체 레코드를 가져와서 List에 담아 반환하는 메서드
	 * @param smc SqlMapClient 
	 * @return MemberVO객체를 담고 있는 List 객체
	 * @throws SQLException JDBC관련 예외 객체
	 */
	public List<MemberVo> getAllMemberList(SqlMapClient smc) throws SQLException;
	
	/**
	 * 하나의 회원 자료를 DB에 update하는 메서드
	 * @param smc SqlMapClient 
	 * @param mv update할 회원 정보가 들어있는 MemberVO객체
	 * @return 작업성공: 1, 작업실패: 0
	 * @throws SQLException JDBC 관련 예외객체
	 */
	public int updateMember(SqlMapClient smc, MemberVo mv) throws SQLException;

	/**
	 * 회원ID를 매개변수로 받아서 그 회원정보를 삭제하는 메서드
	 * @param smc SqlMapClient 
	 * @param memId 삭제할 회원ID
	 * @return 작업성공: 1, 작업 실패: 0
	 * @throws SQLException JDBC관련 예외 객체
	 */
	public int deleteMember(SqlMapClient smc, String memId) throws SQLException;
	
	public List<MemberVo> getSearchMember(SqlMapClient smc, MemberVo mv) throws SQLException;
	
	/**
	 *	회원 정보를 검색하기 위한 메서드
	 *	smc SqlMapClient 
	 *	mv 검색할 회원 정보
	 *	검색된 회원정보를 담은 List 객체
	 *	SQLException JDBC 관련 예외 객체
	 */
	
	
	
	
	
	
}
