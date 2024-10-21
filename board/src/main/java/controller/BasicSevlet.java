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
import action.BoardListAction;
import action.BoardReadAction;
import action.BoardUpdateAction;


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
			
		// http://localhost:8080/
		
		Action action = null;
		
		if (cmd.equals("/list.do")) {
			action = new BoardListAction("/board/list.jsp");
		} else if(cmd.equals("/read.do")){
			action = new BoardReadAction("/board/read.jsp");
		} else if(cmd.equals("/modify.do")){
			action = new BoardReadAction("/board/modify.jsp");
		} else if(cmd.equals("/update.do")){
			action = new BoardUpdateAction("/read.do");
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
