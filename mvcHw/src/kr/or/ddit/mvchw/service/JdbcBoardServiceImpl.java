package kr.or.ddit.mvchw.service;

import java.util.List;

import kr.or.ddit.mvchw.dao.IJdbcBoardDao;
import kr.or.ddit.mvchw.dao.JdbcBoardDaoImpl;
import kr.or.ddit.mvchw.vo.JdbcBoardVO;

public class JdbcBoardServiceImpl implements IJdbcBoardService {
	private static JdbcBoardServiceImpl service;
	
	private IJdbcBoardDao dao;
	
	private JdbcBoardServiceImpl() {
		dao = JdbcBoardDaoImpl.getInstance();
	}
	
	public static JdbcBoardServiceImpl getInstance() {
		if(service==null) service = new JdbcBoardServiceImpl();
		return service;
	}
	

	@Override
	public int insertJdbcBoard(JdbcBoardVO jbVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<JdbcBoardVO> getAllJdbcBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getJdbcBoard(int board_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int searchJdbcBoard(int board_title) {
		// TODO Auto-generated method stub
		return 0;
	}

}
