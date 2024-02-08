package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import vo.board.BoardVO;


@WebServlet("/boardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IBoardService service = BoardServiceImpl.getInstance();
		List<BoardVO> bodList = service.getAllBoard();

		request.setAttribute("boardList", bodList);
		
		request.getRequestDispatcher("/WEB-INF/view/board/boardList.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
