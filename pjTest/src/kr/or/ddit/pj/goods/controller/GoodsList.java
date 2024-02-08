package kr.or.ddit.pj.goods.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.pj.goods.service.GoodsServiceImpl;
import kr.or.ddit.pj.goods.service.IGoodsService;
import kr.or.ddit.pj.goods.vo.GoodsImgVo;
import kr.or.ddit.pj.goods.vo.GoodsVo;


/**
 * Servlet implementation class GoodsList
 */
@WebServlet("/goods/goodsList.do")
public class GoodsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IGoodsService service = GoodsServiceImpl.getInstance();
		List<GoodsVo> goodsList = service.getAllGoods();
		
		request.setAttribute("goodsList", goodsList);
		
		
		request.getRequestDispatcher("/WEB_INF/view/goods/goodsList.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
