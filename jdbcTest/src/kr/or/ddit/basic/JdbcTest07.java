package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 * 회원을 관리하는 프로그램을 작성하시오. (MYMEMBER테이블 이용)
 * 
 * 아래 메뉴의 기능을 모두 구현하시오. (CRUD 기능 구현 연습)
 * 메뉴 예시)
 * 1. 자료추가 		  ==> insert (C)
 * 2. 자료 삭제		  ==> delete (D)
 * 3. 자료 수정		  ==> update (U)
 * 4. 전체 자료 출력	  ==> select (R)
 * 0. 작업끝
 * -----------------
 * 조건)
 * 1) 자료 추가에서 '회원ID'는 중복되지 않는다. (중복되면 다시 입력 받는다.)
 * 2) 자료 삭제는 '회원ID'를 입력 받아서 처리한다.
 * 3) 자료 수정에서 '회원ID'는 변경되지 않는다.
 * 
 * - 싱글톤패턴과 MVC패턴에 대하여 발표할 수 있도록 공부해 올 것
 * 
 */
public class JdbcTest07 {
	Scanner scan = new Scanner(System.in);
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	String memId;
	String memPass; 
	String memName;
	String memTel;
	String memAddr;
	
	public static void main(String[] args) {
		JdbcTest07 jdbc = new JdbcTest07();
		jdbc.start();
		
	}
		
	public void start() {
		conn = DBUtil.getConnection();
		
		
		while(true) {
			System.out.println("1. 자료 추가 ");
			System.out.println("2. 자료 삭제 ");
			System.out.println("3. 자료 수정 ");
			System.out.println("4. 전체 자료 출력 ");
			System.out.println("0. 작업 끝");
			System.out.print("메뉴 선택>>");
			int uch = scan.nextInt();
			
			switch (uch) {
			case 1: //추가
				insertMember();
				break;
			case 2: //삭제
				deleteMember();
				break;
			case 3:  //수정
				updateMember();
				break;
			case 4: //전체출력
				selectMember();
				break;
			case 0: //종료
				System.out.println("종료");
				if(conn!=null) try {conn.close();} catch(SQLException e) {}
				return;
			default:
				System.out.println("잘못 입력!! 다시 입력 하세요~~");
			}
		}
		
	}
	
	
	private void selectMember() {
		
		try {
			String sql = "select * from mymember ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("==전제 자료 조회==");
			System.out.println("아이디\t 비밀번호\t 이름\t 전화번호\t 주소");
			System.out.println("=================================");
			
			while(rs.next()) {
				String memI = rs.getString("mem_id");
				String memP = rs.getString("mem_pass");
				String memN = rs.getString("mem_name");
				String memT = rs.getString("mem_tel");
				String memA = rs.getString("mem_addr");
				System.out.println(memI+"\t"+memP+"\t"+memN+"\t"+memT+"\t"+memA);
			}
			System.out.println("--------------------------------");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {rs.close();} catch(SQLException e) {}
		}
		
	}


	private void updateMember() {
		try {
			String sql = "select count(*) cnt from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			
			int count=0;
			
			do {
				System.out.println("==자료 수정==");
				System.out.print("아이디 입력 >> ");
				memId = scan.next();
				
				pstmt.setString(1, memId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
				if(count<=0) {
					System.out.println(memId+"는 없는 아이디 입니다.");
					System.out.println("다시 입력 하세요...");
					System.out.println();
				}
			}while(count<=0);
			
			if(pstmt!=null) pstmt.close();
			
			System.out.print("비밀번호 입럭>> ");
			memPass = scan.next();
			System.out.print("이름 입럭>> ");
			memName = scan.next();
			System.out.print("전화번호 입럭>> ");
			memTel = scan.next();
			System.out.print("주소 입럭>> ");
			memAddr = scan.next();
			
			String sqlU = "update mymember "
						+ " set mem_pass = ?, mem_name=?, mem_tel=?, mem_addr =? "
						+ " where mem_id = ?";
			
			pstmt = conn.prepareStatement(sqlU);
			pstmt.setString(1, memPass);
			pstmt.setString(2, memName);
			pstmt.setString(3, memTel);
			pstmt.setString(4, memAddr);
			pstmt.setString(5, memId);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0){
				System.out.println("수정 성공!!");
			}else {
				System.out.println("수정 실패~~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {rs.close();} catch(SQLException e) {}
		}
	}


	private void deleteMember() {
		try {
			String sql = "select count(*) cnt from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			
			int count=0;
			
			do {
				System.out.println("==자료 삭제==");
				System.out.print("아이디 입력 >> ");
				memId = scan.next();
				
				pstmt.setString(1, memId);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
				if(count<=0) {
					System.out.println(memId+"는 없는 아이디 입니다.");
					System.out.println("다시 입력 하세요...");
					System.out.println();
				}
			}while(count<=0);
			
			if(pstmt!=null) pstmt.close();
			
			String sqlD = "delete from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sqlD);
			pstmt.setString(1, memId);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0){
				System.out.println("삭제 성공!!");
			}else {
				System.out.println("삭제 실패~~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {rs.close();} catch(SQLException e) {}
		}
	}


	public void insertMember () {

		try {
			String sql = "select count(*) cnt from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			
			int count =0;
			
			do {
				System.out.println("==자료 추가==");
				System.out.print("아이디 입력 >> ");
				memId = scan.next();
				
				pstmt.setString(1, memId);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
				if(count>0) {
					System.out.println(memId+"는 이미 있는 아이디 입니다.");
					System.out.println("다시 입력 하세요...");
					System.out.println();
				}
			}while(count>0);
			
			if(pstmt!=null) pstmt.close();
			
			System.out.print("비밀번호 입럭>> ");
			memPass = scan.next();
			System.out.print("이름 입럭>> ");
			memName = scan.next();
			System.out.print("전화번호 입럭>> ");
			memTel = scan.next();
			System.out.print("주소 입럭>> ");
			memAddr = scan.next();
			
			String sqlI = "insert into mymember(mem_id, mem_pass, mem_name, mem_tel, mem_addr) " 
					   +" values(?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sqlI);
			pstmt.setString(1, memId);
			pstmt.setString(2, memPass);
			pstmt.setString(3, memName);
			pstmt.setString(4, memTel);
			pstmt.setString(5, memAddr);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0){
				System.out.println("등록 성공!!");
			}else {
				System.out.println("등록 실패~~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
	}
	
	
}




