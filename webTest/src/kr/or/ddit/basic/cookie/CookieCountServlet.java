package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCountServlet
 */
@WebServlet("/cookieCountServlet.do")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//사용할 쿠키이름 : "cnt"
		
		int cnt=0;   //쿠키값이 저장될 변수 선언
		
		Cookie[] cookieArr = request.getCookies();
		
		if(cookieArr!=null) {
			//배열에 있는 쿠키 중에서 'cnt'라는 이름의 쿠키 찾기
			for (Cookie cookie : cookieArr) {
				if(cookie.getName().equals("cnt")) {
					//"cnt".equals(cookie.getName())
					
					//'cnt'쿠키의 쿠키값을 구한다.
					cnt = Integer.parseInt(cookie.getValue());
					break;
				}
			}
		}
		cnt++; //cnt 증가
		
		//쿠키이름은 'cnt'이고, 증가된 cnt를 쿠키값으로 갖는 Cookie객체 생성
		Cookie countCookie = new Cookie("cnt", cnt+"");
										      //String.valueOf(cnt)
		
		response.addCookie(countCookie); //쿠키저장
		
		out.println("</html>");
		out.println("<head><meta charset='utf-8'>"
				+ "<title>Cookie 카운트 연습</title></head>");
		out.println("<body>");
		out.println("<h2>어서오세요. 당신은 "+cnt+"번째 방문입니다.</h2>");
		
		out.println("<a href='"+request.getContextPath()
		+"/cookieCountServlet.do'>카운트 증가</a>    ");
		out.println("<a href='"+request.getContextPath()
		+"/basic/cookie/cookieTest02.jsp'>시작 문서로 이동하기</a>");
		out.println("</body></html");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
