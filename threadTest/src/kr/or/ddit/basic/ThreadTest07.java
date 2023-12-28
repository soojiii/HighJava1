package kr.or.ddit.basic;
/*
 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 * 
 * 컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
 * 사용자의 입력은 showInputDialog()메서드를 이용해서 입력 받는다.
 * 
 * 입력 시간은 5초로 제한하고 카운트 다운을 한다.
 * 5초안에 입력이 없으면 게임에 진것으로 처리한다.
 * 5초안에 입력이 완료되면 승패를 구해서 출력한다.
 * 
 * 결과 예시)
 * 1) 5초 안에 입력을 못했을 때
 *        -- 결 과 --
 *    시간 초과로 당신이 졌습니다.
 *    
 * 2) 5초 안에 입력을 완료했을 때
 *       -- 결 과 --
 *       컴퓨터 : 가위
 *       사용자 : 바위
 *       결  과 : 당신이 이겼습니다.
 *    
 */

import javax.swing.JOptionPane;

public class ThreadTest07 {
	public static void main(String[] args) {
		Thread th1 = new DataInput1();
		Thread th2 = new DataCountDown1();
		
		th1.start();
		th2.start();
		
	}

}


class DataInput1 extends Thread{
	public static boolean inputCheck = false;
	
	@Override
	public void run() {
		String ran ="";
		int num = (int)(Math.random()*3);
		if(num==0) {
			ran="가위";
		}
		if(num==1) {
			ran="바위";
		}
		if(num==2) {
			ran="보";
		}
		String ustr = JOptionPane.showInputDialog("가위바위보~");
		inputCheck = true;
		if(ran.equals(ustr)) System.out.println("-- 결 과 --"+"\n"+"컴퓨터 : "+ran+"\n"+"사용자 : "+ustr+"\n"+"비겼습니다.");
		else if ((ran.equals("가위") && ustr.equals("바위")) || 
				(ran.equals("바위") && ustr.equals("보")) ||
		        (ran.equals("보") && ustr.equals("가위"))) {
			System.out.println("-- 결 과 --"+"\n"+"컴퓨터 : "+ran+"\n"+"사용자 : "+ustr+"\n"+"당신이 이겼습니다.");
		}else System.out.println("-- 결 과 --"+"\n"+"컴퓨터 : "+ran+"\n"+"사용자 : "+ustr+"\n"+"당신이 졌습니다.");
	}
		
}


class DataCountDown1 extends Thread{
	@Override
	public void run() {
		for(int i=5; i>=1; i--) {
			if(DataInput1.inputCheck==true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("시간 초과로 당신이 졌습니다.");
		System.exit(0);
	}
}


