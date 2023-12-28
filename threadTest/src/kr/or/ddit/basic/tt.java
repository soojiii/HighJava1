package kr.or.ddit.basic;

public class tt {
	public static void main(String[] args) {
		for(int i=1; i<=50; i++) {
			for(int j=1; j<=50; j++) {
			if(i==j) {
				System.out.print(">");
			}
			else System.out.print("-");
			}
			System.out.println();
		}
	}
}
