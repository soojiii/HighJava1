package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *  'f:/d_dother' 폴더에 있는 '펭귄.jpg' 파일을
 *  'f:/d_dother/연습용' 폴더에 '복사본_펭귄.jpg' 파일로
 *  복사하는 프로그램을 작성하시오.
 */
public class FileCopyTest {
	public static void main(String[] args) {
		
		File file = new File("f:/d_other/펭귄.jpg");
		
		if(!file.exists()) {
			System.out.println(file.getPath()+"파일이 없습니다.");
			System.out.println("복사 작업을 중지합니다...");
			return;
		}
		
		try {
			// 원본 파일을 읽어 올 스트림 객체 생성
			FileInputStream fin = new FileInputStream(file);
			BufferedInputStream bin = new BufferedInputStream(fin);
			
			// 대상 파일에 저장할 스트림 객체 생성
			FileOutputStream fout = 
					new FileOutputStream("f:/d_other/연습용/복사본_펭귄.jpg");
			BufferedOutputStream bout = 
					new BufferedOutputStream(fout);
			
			System.out.println("복사 작업 시작...");
			
			int data;
			
//			while( (data=fin.read())!=-1) {
//				fout.write(data);
//			}
//			
//			fout.close();
//			fin.close();
			
			while( (data=bin.read())!=-1) {
				bout.write(data);
			}
			
			bout.close();
			
			bin.close();
			fin.close();
			System.out.println("복사 완료");
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
