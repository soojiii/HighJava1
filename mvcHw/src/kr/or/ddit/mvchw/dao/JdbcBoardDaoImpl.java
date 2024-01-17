package kr.or.ddit.mvchw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.mvchw.vo.JdbcBoardVO;
import kr.or.ddit.util.DBUtil3;

public class JdbcBoardDaoImpl implements IJdbcBoardDao{
	private static JdbcBoardDaoImpl dao;
	
	private JdbcBoardDaoImpl() { }
	
	public static JdbcBoardDaoImpl getInstance() {
		if(dao==null) dao = new JdbcBoardDaoImpl();
		return dao;
	}

	@Override
	public int insertJdbcBoard(JdbcBoardVO jbVo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil3.getConnection();
			String sql = " insert into JDBC_BOARD\r\n" + 
						 " (BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CNT, BOARD_CONTENT)\r\n" + 
						 " values\r\n" + 
						 " (board_seq.NEXTVAL, ?, ?, sysdate, 0, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jbVo.getBoard_title());
			pstmt.setString(2, jbVo.getBoard_writer());
			pstmt.setString(3, jbVo.getBoard_content());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return cnt;
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
