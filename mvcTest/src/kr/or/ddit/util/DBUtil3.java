package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

// JDBC드라이버를 로딩하고 DB에 접속하여 Connection객체를 
// 반환하는 메서드로 구성된 class 만들기
// (ResourceBundle객체 이용하기)
public class DBUtil3 {
	static Logger logger = Logger.getLogger(DBUtil3.class);
	
	private static ResourceBundle bundle;
	//정적(static) 초기화 블럭
	static {
		bundle = ResourceBundle.getBundle(
				"kr.or.ddit.config.dbinfo");
		logger.info("ResouceBundle객체 생성 - dbinfo.properties파일 읽기");
		try {
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(bundle.getString("driver"));
			logger.info("DB 드라이버 로딩 성공!!!");
		} catch (Exception e) {
//			System.out.println("드라이버 로딩 실패~~");
//			e.printStackTrace();
			logger.error("드라이버 로딩 실패~~~", e);
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
				   bundle.getString("url"),
				   bundle.getString("user"),
				   bundle.getString("pass"));
			logger.debug("DB 연결 성공 - Connection객체 성공");
		} catch (SQLException e) {
//			System.out.println("DB 연결 실패~~");
//			e.printStackTrace();
			logger.error("DB 연결 실패~~~", e);
		}
		return conn;
	}
	
	
}
