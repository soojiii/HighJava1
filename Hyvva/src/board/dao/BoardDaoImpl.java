package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.mybatisUtil;
import vo.board.BoardVO;
import vo.board.Board_ImgVO;
import vo.board.Board_ReplyVO;
import vo.board.Board_ReportVO;

public class BoardDaoImpl implements IBoardDao {

	private static BoardDaoImpl dao;
	
	private BoardDaoImpl() {}
	
	public static BoardDaoImpl getInstance() {
		if(dao==null) dao = new BoardDaoImpl();
		return dao;
	}
	
	@Override
	public List<BoardVO> getAllBoard() {
		SqlSession session = null;
		
		List<BoardVO> allboard = null;
		
		try {
			session = mybatisUtil.getSqlSession();// MyBatis 처리용 객체 생성
			allboard = session.selectList("board.getAllBoard");			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return allboard;
	}

	@Override
	public List <Board_ImgVO> getImageBoard(String board_no) {
		SqlSession session = null;
		
		List<Board_ImgVO> getImage = null;
		try {
			session = mybatisUtil.getSqlSession();// MyBatis 처리용 객체 생성
			getImage = session.selectList("board.getImageBoard");			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return getImage;
	}

	@Override
	public int insertBoard(BoardVO boardVo) {
		
		SqlSession session = null;
		
		int cnt = 0;  // 반환값이 저장될 변수 선언
		
		try {
			session = mybatisUtil.getSqlSession();  // MyBatis 처리용 객체 생성
			cnt = session.insert("board.insertBoard", boardVo);
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int board_no) {
		SqlSession session = null;
		
		int cnt = 0;
		
		try {
			session = mybatisUtil.getSqlSession();
			cnt = session.delete("board.deleteBoard", board_no);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
		
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		SqlSession session = null;
		
		int cnt = 0;
		
		try {
			session = mybatisUtil.getSqlSession();
			cnt = session.update("board.updateBoard", boardVo);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
		
		return cnt;
	}

	@Override
	public int updateHit(int board_no) {
		SqlSession session = mybatisUtil.getSqlSession();
		int res = 0;
		
		
		return res;
	}

	@Override
	public int insertReply(Board_ReplyVO board_ReplyVo) {
		SqlSession session = null;
		
		int cnt = 0;  // 반환값이 저장될 변수 선언
		
		try {
			session = mybatisUtil.getSqlSession();  // MyBatis 처리용 객체 생성
			cnt = session.insert("board.Board_ReplyVO", board_ReplyVo);
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateReply(Board_ReplyVO board_ReplyVo) {
		SqlSession session = null;
		
		int cnt = 0;
		
		try {
			session = mybatisUtil.getSqlSession();
			cnt = session.update("board.updateReply", board_ReplyVo);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
		
		return cnt;
	}

	@Override
	public int deleteReply(int board_re_no) {
		SqlSession session = null;
		
		int cnt = 0;
		
		try {
			session = mybatisUtil.getSqlSession();
			cnt = session.delete("board.deleteReply", board_re_no);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
		
		return cnt;
	}

	@Override
	public int insertImage(Board_ImgVO board_ImgVo) {
		SqlSession session = null;
		
		int cnt = 0;  // 반환값이 저장될 변수 선언
		
		try {
			session = mybatisUtil.getSqlSession();  // MyBatis 처리용 객체 생성
			cnt = session.insert("board.Board_ImgVO", board_ImgVo);
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int boardReport(Board_ReportVO board_reportvo) {
SqlSession session = null;
		
		int cnt = 0;  // 반환값이 저장될 변수 선언
		
		try {
			session = mybatisUtil.getSqlSession();  // MyBatis 처리용 객체 생성
			cnt = session.insert("board.boardReport", board_reportvo);
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

}
