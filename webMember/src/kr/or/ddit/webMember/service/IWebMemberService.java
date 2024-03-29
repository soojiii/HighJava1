package kr.or.ddit.webMember.service;

import java.util.List;

import kr.or.ddit.webMember.vo.MemberVO;

public interface IWebMemberService {
	
	public List<MemberVO> getAllMember();
	
	public MemberVO getMember(String id);
	
	public int insertMember(MemberVO mVo);
	
	public int deleteMember(String id);
	
	public int updateMember(MemberVO mVo);
	
	public int getMemberId(String id);
	
}
