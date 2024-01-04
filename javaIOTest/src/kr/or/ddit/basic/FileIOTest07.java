package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIOTest07 {
	public static void main(String[] args) {
		// 사용자로부터 출력할 단을 입력 받아 구구단을 파일로 출력하는 프로그램 작성하기
		// (출력할 파일명 : "f:/d_other/gugudan.txt')
		// 문자 기반 스트림을 이용해서 작성하시오.
		Scanner scan = new Scanner(System.in);
		
		FileWriter fw = null;
		try {

			fw = new FileWriter("f:/d_other/gugudan2.txt");

			System.out.print("출력할 단 입력>> ");
			int dan = scan.nextInt();

			for (int i = 1; i <= 9; i++) {
				String result = dan + " * " + i + " = " + (dan * i) + "\n";
				fw.write(result);
			}
			System.out.println("작업 완료!!!");
			
			fw.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}
}
