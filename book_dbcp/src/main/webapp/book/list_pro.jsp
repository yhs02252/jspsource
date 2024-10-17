<%@page import="dto.BookDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
BookDAO dao = new BookDAO();
List<BookDTO> list = dao.getList();

// 어떤 특정 값(객체)을 다른 페이지(jsp,servlet)들과 공유
// 방법 1. session  session.setAttribute() + 페이지 이동 (이동 방식 제한 조건없음)
//		2. request  request.setAttribute() + 페이지 이동 (이동 방식 제한 됨 => 무조건 .forward() => 사용할 수 있는 페이지도 제한)

request.setAttribute("list", list);

// 이동방식
// response.sendRedirect()
//		   .forward()	

pageContext.forward("list.jsp");
%>