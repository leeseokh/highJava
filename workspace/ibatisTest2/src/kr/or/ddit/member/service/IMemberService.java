package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

/**
 * Service객체는 Dao에 설정된 메서드를 원하는 작업에 맞게 호출하여
 * 결과를 받아오고, 받아온 자료를 Controller에게 보내주는 역할을 수행한다.
 * 보통 Dao의 메서드와 같은 구조를 갖는다.
 * @author SEM
 *
 */
public interface IMemberService {
	
	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메서드
	 * @param mv DB에 insert할 자료가 저장된 MemberVO객체
	 * @return 등록작업이 성공하면 1이상의 값이 반환되고 실패하면 0이 반환됨. 
	 */
	public int insertMember(MemberVO mv);
	
	
	/**
	 * 회원 ID를 매개변수로 받아서 그 회원정보를 삭제하는 메서드
	 * @param memId 삭제할 회원ID
	 * @return 작업성공: 1, 작업실패: 0
	 */
	public int deleteMember(String memId);
	
	/**
	 * 회원정보를 수정하기 위한 메서드
	 * @param mv 수정할 회원정보
	 * @return 작업성공 : 1 , 작업실패:0
	 */
	public int updateMember(MemberVO mv);
	
	/**
	 * 전체 회원 목록을 조회하기 위한 메서드
	 * @return 전체 회원목록
	 */
	public List<MemberVO> getAllMemberList();
	
	/**
	 * 주어진 회원아이드를 이용하여 회원존재여부 체크
	 * @param memId
	 * @return 회원존재시 true, 존재하지 않으면 false
	 */
	public boolean checkMember(String memId);
	
	/**
	 * 회원정보를 검색하기 위한 메서드
	 * @param mv 검색할 데이터를 담은 VO객체
	 * @return 검색된 결과를 담은 List 객체
	 */
	public List<MemberVO> getSearchMember(MemberVO mv);
}
