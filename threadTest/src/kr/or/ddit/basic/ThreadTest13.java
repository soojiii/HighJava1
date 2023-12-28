package kr.or.ddit.basic;

import java.util.ArrayList;

public class ThreadTest13 {
	public static void main(String[] args) {
		Horse[] charArr = new Horse[] {
			new Horse("1번말"),
			new Horse("2번말"),
			new Horse("3번말"),
			new Horse("4번말"),
			new Horse("5번말"),
			new Horse("6번말"),
			new Horse("7번말"),
			new Horse("8번말"),
			new Horse("9번말"),
			new Horse("10번말"),
		};
		for(Horse h1 : charArr) {
			h1.start();
		}
		
		for(Horse h1 : charArr) {
			try {
				h1.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}

class Horse extends Thread{
	public static String strRank="";
	private String hname;
	private int position;
	private int rank;
	
	
	public Horse(String hname) {
		this.hname = hname;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=50; i++) {
			try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			position=i;
	}
	
}





