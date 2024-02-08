package kr.or.ddit.pj.goods.service;

import java.util.List;

import kr.or.ddit.pj.goods.dao.GoodsDaoImpl;
import kr.or.ddit.pj.goods.dao.IGoodsDao;
import kr.or.ddit.pj.goods.vo.GoodsImgVo;
import kr.or.ddit.pj.goods.vo.GoodsVo;

public class GoodsServiceImpl implements IGoodsService {
	
	private static GoodsServiceImpl service;
	
	private IGoodsDao dao;
	
	private GoodsServiceImpl() {
		dao = GoodsDaoImpl.getInstance();
	}
	
	public static GoodsServiceImpl getInstance() {
		if(service==null) service = new GoodsServiceImpl();
		return service;
	}
	
	
	
	@Override
	public List<GoodsVo> getAllGoods() {
		return dao.getAllGoods();
	}

	@Override
	public GoodsVo getGoods(String goods_no) {
		return dao.getGoods(goods_no);
	}

	@Override
	public List<GoodsImgVo> getGoodsImg(String goods_no) {
		return dao.getGoodsImg(goods_no);
	}

}
