package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.CreateAction;
import action.LoginAction;
import action.RegisterAction;

/**
 * Servlet implementation class BasicSevlet
 */
@WebServlet("*.do")	// * : 모든것 + .do 를 붙여서
public class BasicSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		
		// 톰캣서버의 path 수정하지 않았다면
		// RequestURI() => /프로젝트명/경로명  =>  /model2/login.do
		// contextPath	=> /프로젝트명  	=>    /model2
		// "/model2/login.do".substring(7)   경로명만 추출 => /login.do
		
		String requestUri = request.getRequestURI(); // "/login.do"
		String contextPath = request.getContextPath(); // ""
		String cmd = requestUri.substring(contextPath.length()); // "/login.do"
		
		// syso
//		System.out.println("requestUri" + requestUri);
//		System.out.println("contextPath" + contextPath);
		System.out.println("cmd" + cmd);
		
		Action action = null;
		
		if (cmd.equals("/login.do")) {
			System.out.println("로그인 작업임");
			action = new LoginAction("index.jsp");
		} else if (cmd.equals("/register.do")) {
			System.out.println("회원가입 작업");
			action = new RegisterAction("/member/login.jsp");
		} else if (cmd.equals("/create.do")) {
			System.out.println("도서등록");
			action = new CreateAction("index.jsp");
		}
		
		ActionForward af = null;
		
		try {
			af = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(af.isRedirect()) {
			response.sendRedirect(af.getPath());
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
