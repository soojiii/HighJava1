package vo.goods;

public class WayVo {
	 private int way_no;
	 private String way_name;
	 private String way_code;
	 private String way_del;
	 
	 
	 
	 public WayVo() {
		 
	 }

	 
	 
	public int getWay_no() {
		return way_no;
	}

	public void setWay_no(int way_no) {
		this.way_no = way_no;
	}

	public String getWay_name() {
		return way_name;
	}

	public void setWay_name(String way_name) {
		this.way_name = way_name;
	}

	public String getWay_code() {
		return way_code;
	}

	public void setWay_code(String way_code) {
		this.way_code = way_code;
	}

	public String getWay_del() {
		return way_del;
	}

	public void setWay_del(String way_del) {
		this.way_del = way_del;
	}



	@Override
	public String toString() {
		return "WayVO [way_no=" + way_no + ", way_name=" + way_name + ", way_code=" + way_code + ", way_del=" + way_del
				+ "]";
	}
	 
	
	 
	 
}
