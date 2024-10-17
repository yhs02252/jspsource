<%@page import="dao.MemberDAO"%>
<%@page import="dto.ChangeDTO"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	ChangeDTO dto = new ChangeDTO();
	dto.setCurrentPassword(request.getParameter("current_password"));
	dto.setUserid(request.getParameter("userid"));
	dto.setChangePassword(request.getParameter("change_password"));
	
	
	
	MemberDAO dao = new MemberDAO();
	int changeDto = dao.update(dto);
	
	if (changeDto > 0) {
		session.invalidate();
		response.sendRedirect("login.jsp");
	} else{
		response.sendRedirect("info.jsp");		
	}

%>