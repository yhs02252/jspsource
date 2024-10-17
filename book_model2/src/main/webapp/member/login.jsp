<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<h3 class="mb-4 mx-4">Login</h3>
<form method="post" action="login_pro.jsp">
  <div class="row mb-3 mx-auto">
    <label for="userid" class="col-sm-2 col-form-label">아이디</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="userid" name="userid">
    </div>   
  </div>
  
  <div class="row mb-3 mx-auto">
    <label for="password" class="col-sm-2 col-form-label">비밀번호</label>
    <div class="col-sm-4">  
      <input type="password" class="form-control" id="password" name="password">
    </div>
  </div>

  <button type="submit" class="btn btn-secondary">로그인</button>
  <button type="button" class="btn btn-primary">목록으로</button>
</form>
<script src=""></script>
<%@include file="../include/footer.jsp"%>