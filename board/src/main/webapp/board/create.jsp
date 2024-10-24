<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<div class="container-fluid">
	<h1 class="h3 mb-4 text-gray-800">Create</h1>
	<!-- 
		enctype="application/x-www-form-urlencoded"(기본)
		
		첨부파일
		enctype="multipart/form-data"
	-->
<form action="/create.do" method="post" id="createForm" enctype="multipart/form-data">
  <div class="form-group">
    <label for="title">제목</label>
    <input type="text" class="form-control" id="title" name="title">
  </div>
  <div class="form-group">
    <label for="content">내용</label>
    <textarea rows="10" class="form-control" name="content" id="content"></textarea>
  </div>
  <div class="form-group">
    <label for="name">작성자</label>
    <input type="text" class="form-control" id="name" name="name">
  </div>
  <div class="form-group">
    <label for="attach">첨부파일</label>
    <input type="file" class="form-control" id="attach" name="attach">
  </div>
  <div class="form-group">
    <label for="password">비밀번호</label>
    <input type="password" class="form-control" id="password" name="password">
  </div>
  
  	<input type="hidden" name="page" value="1" />
	<input type="hidden" name="amount" value="10" />
	<input type="hidden" name="criteria" value="" />
	<input type="hidden" name="keyword" value="" />
  
  <button type="submit" class="btn btn-primary">Submit</button>
  <button type="button" class="btn btn-success">목록으로 돌아가기</button>
</form>
</div>
<form action="" method="get" id="actionForm">
	<input type="hidden" name="bno" value="${dto.bno}"/>
</form>
<script src="/js/custom/create.js"></script>
<%@ include file="../include/footer.jsp" %>