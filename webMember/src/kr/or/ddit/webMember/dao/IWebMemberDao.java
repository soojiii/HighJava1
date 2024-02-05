package kr.or.ddit.webMember.dao;

import java.util.List;

import kr.or.ddit.webMember.vo.MemberVO;

public interface IWebMemberDao {
	
	public List<MemberVO> getAllMember();
	
	public MemberVO getMember(String id);
	
	public int insertMember(MemberVO mVo);
	
	public int deleteMember(String id);
	
	public int updateMember(MemberVO mVo);
	
	public int getMemberId(String id);
	
	
}
