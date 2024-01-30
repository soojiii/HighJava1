package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieLoginServlret
 */
@WebServlet("/cookieLoginServlret2.do")
public class CookieLoginServlret2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//ID, 비밀번호, CheckBox값 구하기
		
		String userId = request.getParameter("userid");
		String userPass = request.getParameter("userpass");
		String chkId = request.getParameter("chkid");
		
		//ID를 쿠키값으로 갖는 Cookie객체 생성
		Cookie idCookie = new Cookie("USERID", userId);
		
		//CheckBox의 체크 여부를 확인하여 체크된 상태이면 쿠키 저장
		//체크되지 않은 상태이면 유지시간을 0으로 설정한 후 쿠키 저장
		if(chkId==null) {  //체크되지 않았을 때 ...
			idCookie.setMaxAge(0);
		}
		response.addCookie(idCookie);
		
		//로그인 성공 여부 확인
		if("test".equals(userId) && "1234".equals(userPass)){
			//로그인 성공
			response.sendRedirect(request.getContextPath()
					+"/basic/cookie/cookieMain2.jsp");
		}else {
			//로그인 실패시
			response.sendRedirect(request.getContextPath()
					+"/basic/cookie/cookieLogin2.jsp");
			
			
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
