package kr.or.ddit.pj.goods.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.pj.goods.dao.GoodsDaoImpl;
import kr.or.ddit.pj.goods.service.GoodsServiceImpl;
import kr.or.ddit.pj.goods.service.IGoodsService;
import kr.or.ddit.pj.goods.vo.GoodsImgVo;
import kr.or.ddit.pj.goods.vo.GoodsVo;

/**
 * Servlet implementation class ImageView
 */
@WebServlet("/images/imageView.do")
public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String goods_no = request.getParameter("goods_no");
		
		IGoodsService service = GoodsServiceImpl.getInstance();
		
		GoodsImgVo goodsImgVo = (GoodsImgVo) service.getGoodsImg(goods_no);
		
		String imageFile =  goodsImgVo.getGoods_img_path();
		if(imageFile==null) imageFile = "noImage.png";
		
		String filepath = "d:/d_other/uploadFiles";
		File file = new File(filepath, imageFile);
		
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		if(file.exists()) {
			try {
				bout = new BufferedOutputStream(response.getOutputStream());
				
				bin = new BufferedInputStream(new FileInputStream(file));
				
				byte[] temp = new byte[1024];
				int len = 0;
				
				while((len=bin.read(temp))>0) {
					bout.write(temp, 0, len);
				}
				bout.flush();
				
			} catch (Exception e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			}finally {
				if(bin!=null) try { bin.close(); }catch(IOException e) {}
				if(bout!=null) try { bout.close(); }catch(IOException e) {}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
