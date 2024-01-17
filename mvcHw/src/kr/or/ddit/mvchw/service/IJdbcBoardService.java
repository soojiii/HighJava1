package kr.or.ddit.mvchw.service;

import java.util.List;

import kr.or.ddit.mvchw.vo.JdbcBoardVO;

public interface IJdbcBoardService {
	/**
	 * JdbcBoardVO객체에 담겨진 자료를 insert하는 메서드
	 * 
	 * @param jbVo DB에 insert할 자료가 저장된 JdbcBoardVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertJdbcBoard(JdbcBoardVO jbVo);
	
	/**
	 * DB의 전체 게시글 정보를 가져와서 List에 담아서 반환하는 메서드
	 * 
	 * @return JdbcBoardVO객체가 저장된 List객체
	 */
	public List<JdbcBoardVO> getAllJdbcBoard();
	
	/**
	 * 게시글NO를 매개변수로 받아서 해당 게시글 정보를 조회하는 메서드
	 * 
	 * @param board_no 조회할 게시글NO
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int getJdbcBoard(int board_no);
	
	/**
	 * 게시글 title을 매개변수로 받아서 해당 게시글을 검색하는 메서드
	 * 
	 * @param board_title
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int searchJdbcBoard(int board_title);
	
}
