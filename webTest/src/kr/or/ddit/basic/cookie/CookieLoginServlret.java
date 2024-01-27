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
@WebServlet("/cookieLoginServlret.do")
public class CookieLoginServlret extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String box = request.getParameter("cbox");
		
		
		
		
		
	
		if("id기억하기".equals(box)) {
			Cookie cookie = new Cookie("id",id); // 체크박스가 체크되어있으면 쿠키를 만든다
			response.addCookie(cookie);
		}else {
			Cookie[] cookieArr = request.getCookies(); // 체크박스가 체크 안되어있으면 쿠키를 삭제한다
			for(Cookie ck : cookieArr) {
				String name = ck.getName();
				if("id".equals(name)) {
					ck.setMaxAge(0);
					response.addCookie(ck);
				}
			}
		}
		
		
		
		if("test".equals(id)&&"1234".equals(pass)) {
			response.sendRedirect(request.getContextPath()+"/basic/cookie/cookieMain.jsp");
		}else {
			response.sendRedirect(request.getContextPath()+"/basic/cookie/cookieLogin.jsp");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
