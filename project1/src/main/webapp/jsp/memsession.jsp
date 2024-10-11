<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("ID");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	
	session.setAttribute("ID", id);
	session.setAttribute("password", password);
	session.setAttribute("name", name);
	session.setAttribute("phone", phone);

%>
<h3><>회원정보 열람하기</h3>
<h4><a href="memsession2.jsp">이동하기</a></h4>