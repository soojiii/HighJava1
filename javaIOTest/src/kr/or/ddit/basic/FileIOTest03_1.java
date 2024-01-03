package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileIOTest03_1 {
	public static void main(String[] args) {
		// 사용자로부터 출력할 단을 입력 받아 구구단을 파일로 출력하는 프로그램 작성하기
		// (출력할 파일명 : "f:/d_other/gugudan.txt')
		Scanner scan = new Scanner(System.in);

		FileOutputStream fout = null;
		try {

			fout = new FileOutputStream("f:/d_other/gugudan.txt");

			System.out.println("출력할 단 입력>> ");
			int dan = scan.nextInt();

			for (int i = 1; i <= 9; i++) {
				String result = dan + " * " + i + " = " + (dan * i) + "\n";
				fout.write(result.getBytes("utf-8"));
			}
			System.out.println("작업 완료!!!");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if(fout!=null) try { fout.close();}catch(IOException e) {}
		}

	}
}
