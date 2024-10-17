<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	MemberDTO dto = new MemberDTO();
	dto.setUserid(request.getParameter("userid"));
	dto.setName(request.getParameter("name"));
	dto.setPassword(request.getParameter("password"));
	
	MemberDAO dao = new MemberDAO();
	int regDto = dao.insert(dto);
	
	if(regDto==0){
		response.sendRedirect("register.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}

%>