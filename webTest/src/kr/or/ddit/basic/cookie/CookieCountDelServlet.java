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
 * Servlet implementation class CookieCountDelServlet
 */
@WebServlet("/cookieCountDelServlet.do")
public class CookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//전체 쿠키 정보 가져오기
		Cookie[] cookieArr = request.getCookies();
		
		//'count'라는 쿠키 이름을 갖는 쿠키 정보를 찾는다.
		if(cookieArr!=null) {
			for(Cookie cookie : cookieArr) {
				if("cnt".equals(cookie.getName())) {
					//찾은 쿠키의 유지 시간을 0으로 변경한 후 다시 저장한다.
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					break;
				}
			}
		}
		
		out.println("</html>");
		out.println("<head><meta charset='utf-8'>"
				+ "<title>Cookie 삭제 연습</title></head>");
		out.println("<body>");
		
		out.println("<h2>cnt가 초기화 되었습니다...</h2>");
		out.println("<br><br><br><br>");
		
		out.println("<a href='"+request.getContextPath()
		+"/basic/cookie/cookieTest02.jsp'>시작 문서로 이동하기</a>");
		out.println("</body></html");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
