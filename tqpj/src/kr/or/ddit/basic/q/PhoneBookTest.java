package kr.or.ddit.basic.q;

import static org.quartz.DateBuilder.dateOf;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;


	/*
	 * 추가 조건
	 * 
	 *  1) 6. 전화번호 저장  메뉴를 추가하고 구현한다.
	 *     (저장 파일명은 'Phone2Book.data'로 한다.)
	 *  2) 프로그램이 시작될 떄 저장된 파일이 있으면 그 데이터를 읽어와 Map에 저장한다.
	 *  3) 프로그램을 종료할 때 Map의 데이터가 변경(추가,수정,삭제)되었으면 파일로 저장 후 종료 되도록 한다.  
	 *  
	 *  조별과제
	 *  quartz를 이용해서 일정 시간마다 자동 저장이 될 수 있게 프로그래밍하기.
	 */

public class PhoneBookTest {
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, Phone2> list = new HashMap<>();
	
	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory factory = new StdSchedulerFactory(); 
		Scheduler scheduler = factory.getScheduler();
		PhoneBookTest p = new PhoneBookTest();
		p.load();
		
		//자동저장 quartz()메소드
		p.quartz();
		
		while(true) {
			p.menu();
			int sel = sc.nextInt();
			switch (sel) {
				case 1:
					Phone2 a = p.insert(list);
					list.put(a.getName(), a);
					System.out.println("추가가 완료되었습니다.");
					break;
				case 2:
					Phone2 a1 = p.update(list);
					list.put(a1.getName(), a1);
					System.out.println("수정이 완료되었습니다.");
					break;
				case 3:
					listPrint(list);
					System.out.print("삭제할 이름을 입력해주세요>>");
					String name = sc.next();
					list.remove(name);
					System.out.println("삭제가 완료되었습니다.");
					break;
				case 4:
					System.out.print("검색할 이름을 입력하세요: ");
					String name1 = sc.next();
					listPrintSh(name1, list);
					break;
				case 5:
					listPrint(list);
					break;
				case 6:
					listSave();
					break;
				case 0:
					break;
				default:
					break;
				}
			if(sel == 0) {
				scheduler.shutdown();
			System.out.println("종료되었습니다.");
			break;
			} 
		}
	}
	
	private void quartz() throws SchedulerException {
		
		//job 클래스로 list를 보내주는 과정
		JobDataMap map = new JobDataMap();
		map.put("list", list);
		
		JobDetail detail = newJob(Job01.class) //생성&받아올 클래스 호출 메소드
				.withIdentity("detail1")      //고유값 부여 메소드
				.usingJobData(map)
				.build();                     //빌드 마침 메소드
		
		Date startTime = dateOf(0, 0, 20);	
		
		Trigger trigger = newTrigger()
					.withIdentity("trigger1")
					.startAt(startTime)			//작업 시작시간
					.withSchedule(SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(10) // 반복할 초단위 지정
					.repeatForever())          // 무한 반복지정
					.build();                 //빌드 마침 메소드
		
		//쿼츠를 실행시킬 객체를 생성하기 위해 SchedulerFactory 클래스객체에서  
		//getScheduler()메소드를 통해서
		//Scheduler 객체 생성
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		
		//생성한 Scheduler의 scheduleJob 을 이용해 detail과 trigger값을 셋팅해주고
		//start() 메소드를 통해 실행 하면 execute가 실행된다.
		scheduler.scheduleJob(detail, trigger);
		scheduler.start();
	}

	private void load() {
		try {
			//해당 파일이 정해진 경로에 없을경우 파일 생성
			File file = new File("f:/d_other/Phone2Book.data");
            if (file.createNewFile()) {
                System.out.println(file.getName()+" 파일이 성공적으로 생성되었습니다.");
            } else {}
			
			//입력용 스트림 객체 생성
			ObjectInputStream oin = new ObjectInputStream(
				new BufferedInputStream(
					new FileInputStream("f:/d_other/Phone2Book.data")
				)
			);
			
			Object obj = null; //읽어온 객체가 저장될 변수
			
			// readObject()메소드가 데이터를 끝까지 다 읽어오면 EOFException이 발생한다.
			while((obj=oin.readObject()) != null) {
				//읽어온 데이터를 원래의 객체형으로 변환 후 사용한다.
				Phone2 mem = (Phone2)obj;
				list.put(mem.getName(), mem);
			}
			oin.close(); //스트림 닫기
			
		} catch (EOFException e) {
			System.out.println();
			System.out.println("EOFException=> 객체 읽기 작업 끝...");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private static void listSave() {
		try {
			ObjectOutputStream oout = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream("f:/d_other/Phone2Book.data")));

			for (String a : list.keySet()) {
				oout.writeObject(list.get(a));
			}
			
			oout.writeObject(null);
			System.out.println("저장이 완료되었습니다.");
			oout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	private static void listPrintSh(String name1, HashMap<String, Phone2> list) {
		System.out.println("--------------------------------------------");
		System.out.println("이름\t전화번호\t주소");
		System.out.println("--------------------------------------------");
			String name = list.get(name1).getName();
			String tel = list.get(name1).getTel();
			String add = list.get(name1).getAdd();
			System.out.println(name+"\t"+tel+"\t"+add);
		System.out.println("--------------------------------------------");
	}
	
	private Phone2 update(HashMap<String, Phone2> list) {
		System.out.print("수정할이름입력>>");
		String name = sc.next();
		System.out.print("전화번호입력>>");
		String tel = sc.next();
		sc.nextLine();
		System.out.print("지역입력>>");
		String arr = sc.nextLine();
		Phone2 a = new Phone2(name, arr, tel);
		return a;
	}
	
	private static void listPrint(HashMap<String, Phone2> list) {
		System.out.println("--------------------------------------------");
		System.out.println("이름\t전화번호\t주소");
		System.out.println("--------------------------------------------");
		for (Phone2 a : list.values()) {
			String name = a.getName();
			String tel = a.getTel(); 
			String add = a.getAdd();
			System.out.println(name+"\t"+tel+"\t"+add);
		}
		System.out.println("--------------------------------------------");
	}

	
	public Phone2 insert(HashMap<String, Phone2> list) {
		String name1;
		while (true) {
            System.out.print("이름입력>>");
            String name = sc.next();
            if (list.containsKey(name)) {
                System.out.println(name + "은(는) 이미 등록된 사람입니다.");
            } else {
                name1 = name;
                break;
            }
        }
		sc.nextLine();
		System.out.print("지역입력>>");
		String arr = sc.nextLine();
		System.out.print("전화번호입력>>");
		String tel = sc.next();
		Phone2 a = new Phone2(name1, arr, tel);
		return a;
	}
	
	public void menu(){
		System.out.println("-----메인메뉴-----");
		System.out.println("1.전화번호 등록");
		System.out.println("2.전화번호 수정");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.전화번호 검색");
		System.out.println("5.전화번호 전체 출력");
		System.out.println("6.전화번호 저장");
		System.out.println("0.프로그램 종료");
		System.out.println("---------------");
		System.out.print("번호입력>>");
	}
}