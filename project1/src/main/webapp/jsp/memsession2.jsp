<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String)session.getAttribute("ID");
String password = (String)session.getAttribute("password");
String name = (String)session.getAttribute("name");
String phone = (String)session.getAttribute("phone");

%>
<h3><%=id %></h3>
<h3><%=password %></h3>
<h3><%=name %></h3>
<h3><%=phone %></h3>
