package kr.or.ddit.pj.goods.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.pj.goods.vo.GoodsImgVo;
import kr.or.ddit.pj.goods.vo.GoodsVo;
import kr.or.ddit.pj.util.MybatisUtil;

public class GoodsDaoImpl implements IGoodsDao {

	private static GoodsDaoImpl dao;
	
	private GoodsDaoImpl() {}
	
	public static GoodsDaoImpl getInstance() {
		if(dao==null) dao = new GoodsDaoImpl();
		return dao;
	}
	
	
	@Override
	public List<GoodsVo> getAllGoods() {
		SqlSession session = null;
		
		List<GoodsVo> goodsList = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			goodsList = session.selectList("goods.getAllGoods");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return goodsList;
	}

	@Override
	public GoodsVo getGoods(String goods_no) {
		SqlSession session = null;
		
		GoodsVo goods = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			goods = session.selectOne("goods.getGoods", goods_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return goods;
	}

	@Override
	public List<GoodsImgVo> getGoodsImg(String goods_no) {
		SqlSession session = null;
		
		List<GoodsImgVo> goodsImgList = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			goodsImgList = session.selectList("goods.getGoodsImg");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return goodsImgList;
	}
	
}
