package board.service;

import java.util.List;

import board.dao.BoardDaoImpl;
import board.dao.IBoardDao;
import vo.board.BoardVO;
import vo.board.Board_ImgVO;
import vo.board.Board_ReplyVO;
import vo.board.Board_ReportVO;

public class BoardServiceImpl implements IBoardService{
	
	private static BoardServiceImpl service;
	
	private IBoardDao dao;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(service==null) service = new BoardServiceImpl();
		
		return service;
	}
	
	@Override
	public List<BoardVO> getAllBoard() {
		
		return dao.getAllBoard();
	}



	@Override
	public int insertBoard(BoardVO boardVo) {
		return dao.insertBoard(boardVo);
	}

	@Override
	public int deleteBoard(int board_no) {
		return dao.deleteBoard(board_no);
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		return dao.updateBoard(boardVo);
	}

	@Override
	public int updateHit(int board_no) {
		return dao.updateHit(board_no);
	}

	@Override
	public int insertReply(Board_ReplyVO board_ReplyVo) {
		return dao.insertReply(board_ReplyVo);
	}

	@Override
	public int updateReply(Board_ReplyVO board_ReplyVo) {
		return dao.updateReply(board_ReplyVo);
	}

	@Override
	public int deleteReply(int board_re_no) {
		return dao.deleteReply(board_re_no);
	}

	@Override
	public int insertImage(Board_ImgVO board_ImgVo) {
		return dao.insertImage(board_ImgVo);
	}

	@Override
	public int boardReport(Board_ReportVO board_reportvo) {
		return dao.boardReport(board_reportvo);
				
	}

	@Override
	public List<Board_ImgVO> getImageBoard(String board_no) {
		
		return dao.getImageBoard(board_no);
	}

	

}
