package kr.or.ddit.pj.goods.vo;

public class GoodsImgVo {
	 private int goods_img_no;
	 private String goods_no;
	 private String goods_img_path;
	 
	 
	public GoodsImgVo() {
	
	}


	public int getGoods_img_no() {
		return goods_img_no;
	}


	public void setGoods_img_no(int goods_img_no) {
		this.goods_img_no = goods_img_no;
	}


	public String getGoods_no() {
		return goods_no;
	}


	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}


	public String getGoods_img_path() {
		return goods_img_path;
	}


	public void setGoods_img_path(String goods_img_path) {
		this.goods_img_path = goods_img_path;
	}


	@Override
	public String toString() {
		return "GoodsImgVO [goods_img_no=" + goods_img_no + ", goods_no=" + goods_no + ", goods_img_path="
				+ goods_img_path + "]";
	}
	 
	 
	
	
}
