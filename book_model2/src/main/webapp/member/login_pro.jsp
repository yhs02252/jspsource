<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	MemberDTO dto = new MemberDTO();
	dto.setUserid(request.getParameter("userid"));
	dto.setPassword(request.getParameter("password"));

	MemberDAO dao = new MemberDAO();
	MemberDTO loginDto = dao.islogin(dto);
	
	if(loginDto!=null){
		session.setAttribute("loginDto", loginDto);
		response.sendRedirect("/book/list_pro.jsp");
	}else{
		response.sendRedirect("login.jsp");
	}
%>