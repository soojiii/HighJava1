package kr.or.ddit.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileIOTest03 {
	public static void main(String[] args) {
		// 사용자로부터 출력할 단을 입력 받아 구구단을 파일로 출력하는 프로그램 작성하기
		// (출력할 파일명 : "f:/d_other/gugudan.txt')
		
		try {
			File file = new File("f:/d_other/gugudan.txt");
			
			FileOutputStream gugu = new FileOutputStream(file);
			
			String a = JOptionPane.showInputDialog("출력할 단을 입력하세요.");
			
			int dan = Integer.parseInt(a);
			
			String gugudan ="";
			for(int i=1; i<=9; i++) {
				gugudan += dan+"*"+i+"="+(dan*i)+"\n";
			}
			
			byte[] gugudanArr = gugudan.getBytes("utf-8");
			gugu.write(gugudanArr);
									
			System.out.println("작업 완료!!");
			gugu.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	
}
