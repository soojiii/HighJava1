package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제1) 사용자로부터 Lprod_id값을 입력 받아 입력한 값보다
//        Lprod_id가 큰 자료들을 출력하시오.
public class JdbcTest02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("입력한 값보다 큰 Lprod_id 찾기 >>");
		int num = scan.nextInt();
		
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "HSJ91", "java");
			
			String sql = " select LPROD_ID, LPROD_GU, LPROD_NM nm \r\n" + 
						 "    from lprod \r\n" + 
						 " where LPROD_ID >"+num;		
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			
			int cnt = 0;
			boolean chk = false;
			System.out.println("== 검색 결과 ==");
			
			while(rs.next()) {
				cnt++;
				System.out.println("LPROD_ID : " +rs.getInt("LPROD_ID"));
				System.out.println("LPROD_GU : " +rs.getString(2));
				System.out.println("LPROD_NM : " +rs.getString("nm"));
				System.out.println("----------------------");
			}
//			if(cnt==0) {
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
