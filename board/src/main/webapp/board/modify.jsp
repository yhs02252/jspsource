<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<div class="container-fluid">
	<h1 class="h3 mb-4 text-gray-800">Read</h1>
	
<form id="readForm" method="post" action="/update.do">
  <div class="form-group">
    <label for="bno">글번호</label>
    <input type="text" class="form-control" id="bno" name="bno" value="${dto.bno}" readonly>
  </div>
  <div class="form-group">
    <label for="title">제목</label>
    <input type="text" class="form-control" id="title" name="title" value="${dto.title}">
  </div>
  <div class="form-group">
    <label for="content">내용</label>
    <textarea rows="15" class="form-control" name="content" id="content">${dto.content}</textarea>
  </div>
  <div class="form-group">
    <label for="name">작성자</label>
    <input type="text" class="form-control" id="name" name="name" value="${dto.name}" readonly>
  </div>
  <div class="form-group">
    <label for="password">비밀번호</label>
    <input type="password" class="form-control" id="password" name="password">
  </div>
  <div class="form-group">
    <label for="attach">첨부파일</label>
    <div><a href="">${dto.attach}</a></div>
  </div>
  
  	<input type="hidden" name="page" value="${searchDTO.page}" />
	<input type="hidden" name="amount" value="${searchDTO.amount}" />
	<input type="hidden" name="criteria" value="${searchDTO.criteria}" />
	<input type="hidden" name="keyword" value="${searchDTO.keyword}" />
  
  <button type="submit" class="btn btn-primary">수정완료</button>
  <button type="button" class="btn btn-danger">삭제</button>
  <button type="button" class="btn btn-success">목록으로 돌아가기</button>
</form>
</div>
<!-- 페이지 나누기 -->
<form action="" method="get" id="actionForm">
	<input type="hidden" name="bno" value="${dto.bno}"/>
	<input type="hidden" name="page" value="${searchDTO.page}" />
	<input type="hidden" name="amount" value="${searchDTO.amount}" />
	<input type="hidden" name="criteria" value="${searchDTO.criteria}" />
	<input type="hidden" name="keyword" value="${searchDTO.keyword}" />
</form>
<script src="/js/custom/read.js"></script>
<%@ include file="../include/footer.jsp" %>