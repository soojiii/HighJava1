package kr.or.ddit.basic;
/**
 * 
 * @author PC-12
 * @version 1.0
 * 
 * <p>
 * 파일명 : JavaDocTest.java <br>
 * 설 명 : JavaDoc문서 작성을 위한 연습용 interface<br><br>
 * 
 * 변경 이력<br>
 * ---------------------------------------------<br>
 * 변경 날짜 : 2024-01-16<br>
 * 변경 인    : 홍길동<br>
 * 변경 내용 : 최초 생성<br>
 * ---------------------------------------------<br>
 * </p>
 */
public interface JavaDocTest {
   /**
    * 메서드명 : methodTest<br>
    * 설 명 : 반환값이 없는 메서드<br>
    * 
    * @param a 첫번째 매개변수 (정수형)
    * @param b 두번째 매개변수 (정수형)
    * 
    */
   public void methodTest(int a, int b);
   
   /**
    * 
    * 
    * 메서드명 : methodAdd<br>
    * 설 명 : 반환값이 있는 메서드<br><br>
    * @param x 정수형 첫번째 데이터
    * @param y 정수형 두번째 데이터
    * @return 처리된 결과를 정수형으로 반환한다.
    */
   public int methodAdd(int x , int y);
   
   /**
    * 메서드명 : methodInput<br>
    * 설 명   : 매개변수가 없는 메서드 <br><br>
    * @return 정수형으로 번환한다.
    */
   public int methodInput();

}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   