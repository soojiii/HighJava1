package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.LprodVO;

//jdbcTest프로젝트의 JdbcTest05.java의 기능을 MyBatis용으로
//변환하시오. (mapper파일명 : jdbc-mapper.xml)
//			(namespace속성값 : jdbc)
public class JdbcToMybatis {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		InputStream in = null;
//		SqlSessionFactory sqlSessionFactory = null;
//		try {
//			in = Resources.getResourceAsStream("kr/or/ddit/mybatis/config/mybatis-config.xml");
//			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
//		} catch (Exception e) {
//			System.out.println("MyBatis 초기화 실패!!");
//			e.printStackTrace();
//		}finally {
//			if(in!=null)try {in.close();} catch(IOException e) {}
//		}
//----------------------------------------------------------------------
		SqlSession session = null;
		try {
//			session = sqlSessionFactory.openSession();
			session = MybatisUtil.getSqlSession();
			
			int nextId = session.selectOne("jdbc.getNextId");
			
			String gu;
			int count=0;
			
			do {
				System.out.println("상품 분류 코드 입력 >> ");
				gu = scan.next();
				
				count = session.selectOne("jdbc.getlprodCount", gu);
				
				if(count>0) {
					System.out.println(gu +"는 이미 등록된 상품 분류 코드 입니다.");
					System.out.println("다시 입력 하세요...");
					System.out.println();
				}
			}while(count>0);
		    
			System.out.println("상품 분류명 입력 >> ");
			String nm = scan.next();
			
			//입력한 자료를 VO객체에 저장한다.
			LprodVO lvo = new LprodVO();
			lvo.setLprod_id(nextId);
			lvo.setLprod_gu(gu);
			lvo.setLprod_nm(nm);
			
			int cnt = session.insert("jdbc.insertLprod", lvo);
			
			if(cnt>0) {
				session.commit();
				System.out.println("등록 성공!!!");
			}else {
				System.out.println("등록 실패~~");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		
		
	}
}
