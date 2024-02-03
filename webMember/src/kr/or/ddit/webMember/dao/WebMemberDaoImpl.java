package kr.or.ddit.webMember.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.webMember.util.MybatisUtil;
import kr.or.ddit.webMember.vo.MemberVO;

public class WebMemberDaoImpl implements IWebMemberDao{

	private static WebMemberDaoImpl dao;
	
	private WebMemberDaoImpl() { }
	
	public static WebMemberDaoImpl getInstance() {
		if(dao==null) dao = new WebMemberDaoImpl();
		return dao;
	}
	
	
	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> list = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("mymember.getAllMember");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return list;
	}

	@Override
	public MemberVO getMember(String id) {
		MemberVO member = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			member = session.selectOne("mymember.getMember", id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return member;
	}

	@Override
	public int insertMember(MemberVO mVo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("mymember.insertMember", mVo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public String getMemberId(String id) {
		String mid = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			mid = session.selectOne("mymember.getMemberId", id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return mid;
	}
	
}
