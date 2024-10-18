<%@page import="dto.BookDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%
// 	List<BookDTO> list = (List<BookDTO>)request.getAttribute("list");
%>
<h3>Book List</h3>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Code</th>
      <th scope="col">Title</th>
      <th scope="col">Writer</th>
      <th scope="col">Price</th>
    </tr>
  </thead>
  <tbody>
  <!-- 로그인 할 때 헤더에서 실행하는 코드중 DTO로 받아오는 변수와 겹치지 않게 주의 -->

  <c:forEach var="dto" items="${list}">
    <tr>
      <td>${dto.code}</td>
      <td><a href="/read.do?code=${dto.code}&keyword=${keyword}" class="text-decoration-none text-reset">${dto.title}</a></td>
	  <td>${dto.writer}</td>
	  <td>${dto.price}</td>
    </tr>
    </c:forEach>

  </tbody>
</table>
<%@include file="../include/footer.jsp"%>