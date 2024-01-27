package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String strNum1 = request.getParameter("num1");
		int num1 = Integer.parseInt(strNum1);
		
		String op = request.getParameter("op");
		
		String strNum2 = request.getParameter("num2");
		int num2 = Integer.parseInt(strNum2);
		
		double vop=0;
		boolean calcOk = true; //계산이 성공하면 true값으로 셋팅
//		if(op.equals("+")) {
//			vop= num1+num2;
//		}else if(op.equals("-")){
//			vop= num1-num2;
//		}else if(op.equals("*")){
//			vop= num1*num2;
//		}else if(op.equals("/")){
//			vop= num1/(double)num2;
//		}else if(op.equals("%")){
//			vop= num1%num2;
//		}
		
		switch(op) {
			case "+" : vop = num1+num2; break;
			case "-" : vop = num1-num2; break;
			case "*" : vop = num1*num2; break;
			case "/" : 
				if(num2!=0) {
				vop = num1/(double)num2;
				}else {
					calcOk=false;
				}
			case "%" : 
				if(num2!=0) {
				vop = num1%num2;
				}else {
					calcOk=false;
				}
		}
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>"
				+ "<title>계산기연습</title></head>");
		out.println("<body>");
		out.println("<h2>계산 결과</h2>");
		out.println("<hr>");
//		out.println(num1+op+num2+" = "+vop);
		out.print(num1+op+num2+" = ");
		if(calcOk==true) {
			out.println(vop);
		}else{
			out.println("계산 불능(0으로 나누기)");
		}
		out.println("</body></html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
