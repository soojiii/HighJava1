package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * Lprod테이블에 새로운 데이터 추가하기
 * 
 * Lprod_gu와  Lprod_nm은 직접 입력 받아서 처리하고,
 * Lprod_id는 현재의 Lprod_id들 중에서 제일 큰 값보다 1 크게 한다.
 * 
 * 입력받은 Lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
 * 
 * 
 */

public class JdbcTest05_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		String lGu;
		String lName;
		
		int rsTrue=0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "HSJ91", "java");
			
				
			while(true) {
			System.out.println("Lprod_gu 입력>> ");
			lGu = scan.next();
			String sqlgu = "select count(*) from lprod where lprod_gu= ?";
			pstmt = conn.prepareStatement(sqlgu);
			pstmt.setString(1, lGu);
			
			rs = pstmt.executeQuery();
			rs.next();
			rsTrue = rs.getInt(1);
				if(rsTrue==0) break;
				System.out.println("이미 등록되어 있습니다. 다시 입력하세요");
			}
					
			System.out.println("Lprod_nm 입력>> ");
			lName = scan.next();
			
			String sql = " insert into LPROD (LPROD_ID, LPROD_GU, LPROD_NM)" + 
					     " values ((select max(lprod_id) from lprod)+1, ?, ?)"; 
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, lGu);
			pstmt.setString(2, lName);
			
			int cnt = pstmt.executeUpdate();
			
			System.out.println("등록 완료!");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		
	}
}
