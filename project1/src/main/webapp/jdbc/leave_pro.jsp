<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	MemberDAO dao = new MemberDAO();
	int deleteRow = dao.delete(request.getParameter("userid"), request.getParameter("password"));

	if(deleteRow == 1){
		session.invalidate();
		response.sendRedirect("main.jsp");
	} else {
		response.sendRedirect("leave.jsp");
	}

%>