package board.service;

import java.util.List;

import vo.board.BoardVO;
import vo.board.Board_ImgVO;
import vo.board.Board_ReplyVO;
import vo.board.Board_ReportVO;

public interface IBoardService {

	public List<BoardVO> getAllBoard();
	
	public List<Board_ImgVO> getImageBoard(String board_no);
	
	public int insertBoard(BoardVO boardVo);
	
	public int deleteBoard(int board_no);
	
	public int updateBoard(BoardVO boardVo);
	
	public int updateHit(int board_no);
	
	public int insertReply(Board_ReplyVO board_ReplyVo);
	
	public int updateReply(Board_ReplyVO board_ReplyVo);
	
	public int deleteReply(int board_re_no);
	
	public int insertImage(Board_ImgVO board_ImgVo);
	
	public int boardReport(Board_ReportVO board_reportvo);
	
	
	
	
}
