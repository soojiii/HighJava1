package kr.or.ddit.pj.goods.vo;

public class OrdersVo {
	 private int order_no;
	 private String user_id;
	 private String order_date;
	 private String order_state;
	 private int order_all_price;
	 
	 
	public OrdersVo() {
		
	}

	
	public int getOrder_no() {
		return order_no;
	}


	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getOrder_date() {
		return order_date;
	}


	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}


	public String getOrder_state() {
		return order_state;
	}


	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}


	public int getOrder_all_price() {
		return order_all_price;
	}


	public void setOrder_all_price(int order_all_price) {
		this.order_all_price = order_all_price;
	}


	@Override
	public String toString() {
		return "OrdersVO [order_no=" + order_no + ", user_id=" + user_id + ", order_date=" + order_date
				+ ", order_state=" + order_state + ", order_all_price=" + order_all_price + "]";
	}
	
	
	 
	 
	 
}
