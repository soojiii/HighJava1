package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Scanner;

// 문제) lprod_id값을 2개 입력 받아서 
//		두 값 중 작은 값부터 큰 값 사이의 자료들을 출력하시오.


public class JdbcTest03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("찾을 값 중 작은값 입력");
		int num1 = scan.nextInt();
		System.out.println("찾을 값 중 큰값 입력");
		int num2 = scan.nextInt();
		
//		if(num1>num2) {
//			int box = num1;
//			num1 = num2;
//			num2 = box;
//		}
		
//		int min = num1;
//		int max = num2;
//		if(num1>num2) {
//			max = num1;
//			min = num2;
//		}
		
		int min = Math.min(num1, num2);
		int max = Math.max(num1, num2);
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "HSJ91", "java");
			
			String sql = " select LPROD_ID, LPROD_GU, LPROD_NM nm \r\n" + 
						 "    from lprod \r\n" + 
						 " where LPROD_ID BETWEEN "+min+" and "+max;			
			
//			System.out.println(sql);
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			boolean chk = false;
			System.out.println("== 검색 결과 ==");
			
			while(rs.next()) {
				chk = true;
				System.out.println("LPROD_ID : " +rs.getInt("LPROD_ID"));
				System.out.println("LPROD_GU : " +rs.getString(2));
				System.out.println("LPROD_NM : " +rs.getString("nm"));
				System.out.println("----------------------");
			}
			if(!chk) {
				System.out.println("검색 결과가 하나도 없습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		
		
		
	}
}
