package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest06 {
	public static void main(String[] args) {
		// 한글이 저장된 파일 읽어오기
		try {
//			FileReader fr = new FileReader("f:/d_other/test_utf8/txt");
//			FileReader fr = new FileReader("f:/d_other/test_ansi.txt");
			
			FileInputStream fin = 
//					new FileInputStream("f:/d_other/test_utf8.txt");
					new FileInputStream("f:/d_other/test_ansi.txt");
			
			// 기본 인코딩 방식으로 읽어온다.
//			InputStreamReader isr = new InputStreamReader(fin);
			
			// 인코딩 방식을 지정해서 읽어오기
			// 인코딩 방식 예시
			// - MS949 ==> 원도우의 한글 기본 인코딩 방식(ANSI방식과 같다.)
			// - UTF-8 ==> 유니코드 UTF-8 인코딩 방식
			// - US-ASCII ==> 영문 전용 인코딩 방식
			
			InputStreamReader isr = 
//					new InputStreamReader(fin, "utf-8");
					new InputStreamReader(fin, "ms949");
			
			int c;
			
			while((c=isr.read()) !=-1) {
				System.out.print((char)c);
			}
			
			isr.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}
}
