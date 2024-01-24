package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.MybatisUtil;

public class MemberDaoImpl implements IMemberDao{
	// 1번
	private static MemberDaoImpl dao;
	
	// 2번
	private MemberDaoImpl() { }
	
	// 3번
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	

	@Override
	public int insertMember(MemberVO memVo) {
		int cnt = 0;  //반환값이 저장될 변수
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			 cnt = session.insert("member.insertMember", memVo);
		if(cnt>0) {
			session.commit();
		}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.delete("member.deleteMember", memId);

		if(cnt>0) {
			session.commit();
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		int cnt = 0;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("member.updateMember", memVo);
		if(cnt>0) {
			session.commit();
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> memList = null;  //반환값이 저장될 변수 선언
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			memList =  session.selectList("member.getAllMember");
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		int count = 0;   //반환값이 저장될 변수 선언
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			count = session.selectOne("member.getMemberCount", memId);
		if(count>0) {
			session.commit();
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		//key 정보 ==> 회원ID(memberID), 수정할 컬럼명(fieldName), 수정할 데이터(data)
		int cnt = 0;  //반환값이 저장될 변수
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("member.updateMember2", paramMap);
		if(cnt>0) {
			session.commit();
		}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}
	
}
