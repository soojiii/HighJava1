package kr.or.ddit.pj.goods.vo;

public class DeliveryVo {
	 private int delivery_no;
	 private int order_no;
	 private String delivery_state;
	 
	 
	public DeliveryVo() {
		
	}

	
	public int getDelivery_no() {
		return delivery_no;
	}

	public void setDelivery_no(int delivery_no) {
		this.delivery_no = delivery_no;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public String getDelivery_state() {
		return delivery_state;
	}

	public void setDelivery_state(String delivery_state) {
		this.delivery_state = delivery_state;
	}


	@Override
	public String toString() {
		return "DeliveryVO [delivery_no=" + delivery_no + ", order_no=" + order_no + ", delivery_state="
				+ delivery_state + "]";
	}
	 
	
	 
	 
}
