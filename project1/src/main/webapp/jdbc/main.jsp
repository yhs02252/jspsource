<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%
	// 세션에 담긴 값 가져오기
	MemberDTO loginDto = (MemberDTO)session.getAttribute("loginDto");
%>
<h3 class="mt-3">회원가입</h3>
<%if(loginDto != null){ %>
<div>
	<!-- 로그인 한 경우 -->
	<%=loginDto.getName() %> 님 반갑습니다.
	<a href="session_remove.jsp" class="btn btn-primary">로그아웃</a>
	<a href="" class="btn btn-success">비밀번호수정</a>
	<a href="" class="btn btn-danger">탈퇴</a>
</div>
<% } %>
<table class="table mt-4">
  <thead>
    <tr>
      <th scope="col">userid</th>
      <th scope="col">name</th>
      <th scope="col">age</th>
      <th scope="col">email</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row"></th>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <th scope="row"></th>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <th scope="row"></th>
      <td></td>
      <td></td>
    </tr>
  </tbody>
</table>
<%@ include file="footer.jsp"%>