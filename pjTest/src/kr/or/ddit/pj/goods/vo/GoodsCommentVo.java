package kr.or.ddit.pj.goods.vo;

public class GoodsCommentVo {
	 private int goods_comment_no;
	 private String goods_no;
	 private int order_no;
	 private String goods_comment_date;
	 private String goods_title;
	 private String goods_content;
	 private String goods_writer;
	 private int goods_star;
	 private String goods_comment_del;
	 
	 
	public GoodsCommentVo() {

	}

	
	public int getGoods_comment_no() {
		return goods_comment_no;
	}

	public void setGoods_comment_no(int goods_comment_no) {
		this.goods_comment_no = goods_comment_no;
	}

	public String getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public String getGoods_comment_date() {
		return goods_comment_date;
	}

	public void setGoods_comment_date(String goods_comment_date) {
		this.goods_comment_date = goods_comment_date;
	}

	public String getGoods_title() {
		return goods_title;
	}

	public void setGoods_title(String goods_title) {
		this.goods_title = goods_title;
	}

	public String getGoods_content() {
		return goods_content;
	}

	public void setGoods_content(String goods_content) {
		this.goods_content = goods_content;
	}

	public String getGoods_writer() {
		return goods_writer;
	}

	public void setGoods_writer(String goods_writer) {
		this.goods_writer = goods_writer;
	}

	public int getGoods_star() {
		return goods_star;
	}

	public void setGoods_star(int goods_star) {
		this.goods_star = goods_star;
	}

	public String getGoods_comment_del() {
		return goods_comment_del;
	}

	public void setGoods_comment_del(String goods_comment_del) {
		this.goods_comment_del = goods_comment_del;
	}


	@Override
	public String toString() {
		return "GoodsCommentVO [goods_comment_no=" + goods_comment_no + ", goods_no=" + goods_no + ", order_no="
				+ order_no + ", goods_comment_date=" + goods_comment_date + ", goods_title=" + goods_title
				+ ", goods_content=" + goods_content + ", goods_writer=" + goods_writer + ", goods_star=" + goods_star
				+ ", goods_comment_del=" + goods_comment_del + "]";
	}
	
	
	
	
}
