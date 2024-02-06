package kr.or.ddit.pj.vo;

public class GoodsVo {
	 private String goods_no;
	 private String goods_name;
	 private int goods_price;
	 private String goods_image;
	 private String goods_del;
	 
	 
	public GoodsVo(String goods_no, String goods_name, int goods_price, String goods_image, String goods_del) {
		super();
		this.goods_no = goods_no;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
		this.goods_image = goods_image;
		this.goods_del = goods_del;
	}


	public String getGoods_no() {
		return goods_no;
	}


	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}


	public String getGoods_name() {
		return goods_name;
	}


	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}


	public int getGoods_price() {
		return goods_price;
	}


	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}


	public String getGoods_image() {
		return goods_image;
	}


	public void setGoods_image(String goods_image) {
		this.goods_image = goods_image;
	}


	public String getGoods_del() {
		return goods_del;
	}


	public void setGoods_del(String goods_del) {
		this.goods_del = goods_del;
	}
	 
	 
	
}
