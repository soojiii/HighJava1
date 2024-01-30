package kr.or.ddit.sessionlogin.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.sessionlogin.vo.MemberVO;
import kr.or.ddit.util.MybatisUtil;

public class MemberDaoImpl implements IMemberDao{
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() {
	}
	
	public static MemberDaoImpl getInstace() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public MemberVO getLoginMember(MemberVO memVo) {
		MemberVO loginMemVo = null; //반환값이 저장될 변수
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			
			loginMemVo = session.selectOne("mymember.getLoginMember", memVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session==null) session.close();
		}
		
		return loginMemVo;
	}
	
}
