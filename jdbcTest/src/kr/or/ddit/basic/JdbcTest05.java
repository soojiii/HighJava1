package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

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

public class JdbcTest05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", "HSJ91", "java");
			
			conn = DBUtil.getConnection();
			
			//Lprod_id는 현재의 Lprod_id들 중에서 제일 큰 값보다 1 크게 한다.
			String sql = "select max(lprod_id) maxnum from lprod";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			int maxNum = 0;
			if(rs.next()) {
				//maxNum = rs.getInt("maxnum");
				maxNum = rs.getInt(1);
			}
			maxNum++;
			
			if(pstmt!=null) pstmt.close();  //노란색 경고문 없애고 싶을때 사용
			//-------------------------------
			
			//입력받은 Lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
			String gu;  //입력한 Lprod_gu값이 저장될 변수
			int count = 0;   //입력한 Lprod_Gu의 갯수가 저장될 변수
			
			String sql2 = "select count(*) cnt from lprod "
						+" where lprod_gu = ? ";
			pstmt = conn.prepareStatement(sql2);
			
			do {
				System.out.println("상품 분류 코드 입력 >> ");
				gu = scan.next();
				
				pstmt.setString(1, gu);  //물음표(?)에 들어갈 데이터 설정
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
				
				if(count>0) {
					System.out.println(gu + "는 이미 등록된 상품 분류 코드 입니다.");
					System.out.println("다시 입력 하세요...");
					System.out.println();
				}
			} while (count>0);
			//------------------------------------------
			
			if(pstmt!=null) pstmt.close(); 
			System.out.println("상품 분류명 입력 >>");
			String nm = scan.next();
			
			String sql3 = "insert into lprod(lprod_id, lprod_gu, lprod_nm) "
					+ " values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, maxNum);
			pstmt.setString(2, gu);
			pstmt.setString(3, nm);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println("등록 성공!!");
			}else {
				System.out.println("등록 실패~~");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		
	}
}
