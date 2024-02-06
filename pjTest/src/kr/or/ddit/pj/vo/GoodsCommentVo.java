package kr.or.ddit.pj.vo;

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
	 
	public GoodsCommentVo(int goods_comment_no, String goods_no, int order_no, String goods_comment_date,
			String goods_title, String goods_content, String goods_writer, int goods_star, String goods_comment_del) {
		super();
		this.goods_comment_no = goods_comment_no;
		this.goods_no = goods_no;
		this.order_no = order_no;
		this.goods_comment_date = goods_comment_date;
		this.goods_title = goods_title;
		this.goods_content = goods_content;
		this.goods_writer = goods_writer;
		this.goods_star = goods_star;
		this.goods_comment_del = goods_comment_del;
	}
	
	
	
	
}
