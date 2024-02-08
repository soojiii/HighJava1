package kr.or.ddit.pj.goods.dao;

import java.util.List;

import kr.or.ddit.pj.goods.vo.GoodsImgVo;
import kr.or.ddit.pj.goods.vo.GoodsVo;

public interface IGoodsDao {
	public List<GoodsVo> getAllGoods();
	
	public GoodsVo getGoods(String goods_no);
	
	public List<GoodsImgVo> getGoodsImg(String goods_no);
	
}
