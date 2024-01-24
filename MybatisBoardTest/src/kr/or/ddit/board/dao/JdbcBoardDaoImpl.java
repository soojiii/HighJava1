package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.MybatisUtil;

public class JdbcBoardDaoImpl implements IJdbcBoardDao{
	//1번
	private static JdbcBoardDaoImpl dao;
	//2번
	private JdbcBoardDaoImpl() { }
	//3번
	public static JdbcBoardDaoImpl getInstance() {
		if(dao==null) dao = new JdbcBoardDaoImpl();
		return dao;
	}
	
	
	@Override
	public int insertBoard(BoardVO boardVo) {
		int cnt = 0;	//반환값이 저장될 변수
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("board.insertBoard", boardVo);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			 if(session!=null) session.close();
		}

		return cnt;
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		int cnt = 0;	//반환값이 저장될 변수
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("board.updateBoard", boardVo);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			 if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		int cnt = 0;	//반환값이 저장될 변수
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.delete("board.deleteBoard", boardNo);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			 if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoardlist() {
		List<BoardVO> boardList = null;  //반환값이 저장될 변수
	
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			boardList = session.selectList("board.getAllBoardlist");
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			 if(session!=null) session.close();
		}
		
		return boardList;
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		BoardVO boardVo =null;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			boardVo = session.selectOne("board.getBoard", boardNo);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			 if(session!=null) session.close();
		}
		
		return boardVo;
	}

	@Override
	public List<BoardVO> getSearchBoardList(String title) {
		List<BoardVO> boardList = null;  //반환값이 저장될 변수
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			boardList = session.selectList("board.getSearchBoardList", title);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			 if(session!=null) session.close();
		}
		
		return boardList;
	}

	@Override
	public int updateBoardCount(int boardNo) {
		int cnt = 0;	//반환값이 저장될 변수
		
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("board.updateBoardCount", boardNo);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			 if(session!=null) session.close();
		}
		
		return cnt;
	}
	
}
