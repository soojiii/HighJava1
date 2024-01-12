package kr.or.ddit.basic;

public class test {
	int a = 10;
	
	{
		a=30*999%4;
	}
	test(){
		a=1;
	}
	
	public static void main(String[] args) {
		test x = new test();
		System.out.println(x.a);
	}
}
