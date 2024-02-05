package kr.or.ddit.webMember.service;

import java.util.List;

import kr.or.ddit.webMember.dao.IWebMemberDao;
import kr.or.ddit.webMember.dao.WebMemberDaoImpl;
import kr.or.ddit.webMember.vo.MemberVO;

public class WebMemberServiceImpl implements IWebMemberService {

	private IWebMemberDao dao;
	
	private static WebMemberServiceImpl service;
	
	private WebMemberServiceImpl() {
		dao = WebMemberDaoImpl.getInstance();
	}
	
	public static WebMemberServiceImpl getInstance() {
		if(service==null) service = new WebMemberServiceImpl();
		return service;
	}
	
	
	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public MemberVO getMember(String id) {
		return dao.getMember(id);
	}

	@Override
	public int insertMember(MemberVO mVo) {
		return dao.insertMember(mVo);
	}


	@Override
	public int deleteMember(String id) {
		return dao.deleteMember(id);
	}

	@Override
	public int updateMember(MemberVO mVo) {
		return dao.updateMember(mVo);
	}

	@Override
	public int getMemberId(String id) {
		return dao.getMemberId(id);
	}

}
