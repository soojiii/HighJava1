package kr.or.ddit.sessionlogin.service;

import kr.or.ddit.sessionlogin.dao.IMemberDao;
import kr.or.ddit.sessionlogin.dao.MemberDaoImpl;
import kr.or.ddit.sessionlogin.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;
	
	private static MemberServiceImpl service;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstace();
	}
	
	public static MemberServiceImpl getInstance() {
		if(service==null) service = new MemberServiceImpl();
		return service;
	}
	
	
	@Override
	public MemberVO getLoginMember(MemberVO memVo) {
		return dao.getLoginMember(memVo);
	}

}
