package kr.or.ddit.mvchw.controller;

import java.util.Scanner;

import kr.or.ddit.mvchw.vo.JdbcBoardVO;

public class JdbcBoardController {
	
	private Scanner scan;
	
	public JdbcBoardController() {
		scan = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		new JdbcBoardController().startJdbcBoard();
	}
	
	public void startJdbcBoard() {
		while(true) {
			int choice = displayMenu();
			
			switch(choice) {
			case 1 :	//추가
				insertJdbcBoard();
				break;
			case 2 :
				break;
			case 3 :
				break;
			case 0 :
				System.out.println("작업을 마칩니다...");
				return;
			default : 
				System.out.println("작업 번호를 잘못 입력했습니다...");
				System.out.println("다시 입력하세요...");
			}
			
		}
	}

	private void insertJdbcBoard() {
		System.out.println("새글 작성하기");
		System.out.println("------------------------");
		System.out.println("- 제   목 : ");
		String bTitle = scan.next();
		System.out.println("- 작성자 : ");
		String bWriter = scan.next();
		scan.nextLine();
		System.out.println("- 내   용 : ");
		String bContent = scan.nextLine();
		
		JdbcBoardVO jbVo = new JdbcBoardVO();
		jbVo.setBoard_title(bTitle);
		
	}

	private int displayMenu() {
		System.out.println();
		System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
		System.out.println("------------------------------------------");
		System.out.println("작업선택 >> ");
		
		return scan.nextInt();
	}
	
	
	
}
