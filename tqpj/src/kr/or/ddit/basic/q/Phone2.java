package kr.or.ddit.basic.q;

import java.io.Serializable;

public class Phone2 implements Serializable{
	private String name;
	private String add;
	private String tel;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public Phone2(String name, String add, String tel) {
		this.name = name;
		this.add = add;
		this.tel = tel;
	}
}