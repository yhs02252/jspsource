<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<form action="/Member" method="post">
<div class="container">
<div class="input-group mb-3 mt-3">
  <span class="input-group-text" id="basic-addon1">아이디</span>
  <input type="text" class="form-control" placeholder="5~8자 영문,숫자 조합" aria-label="ID" aria-describedby="basic-addon1" name="ID">
</div>
<div class="input-group mb-3 mt-3">
  <span class="input-group-text" id="basic-addon1">비밀번호</span>
  <input type="password" class="form-control" placeholder="8~12자 영문,숫자,특수문자 조합" aria-label="password" aria-describedby="basic-addon1" name="password">
</div>
<div class="input-group mb-3 mt-3">
  <span class="input-group-text" id="basic-addon1">이름</span>
  <input type="text" class="form-control" placeholder="한글로 표기" aria-label="name" aria-describedby="basic-addon1" name="name">
</div>
<div class="input-group mb-3 mt-3">
  <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">국번선택</button>
  <ul class="dropdown-menu">
    <li><a class="dropdown-item" href="#">+82</a></li>
    <li><a class="dropdown-item" href="#">직접 입력</a></li>
<!--     <li><hr class="dropdown-divider"></li> -->
  </ul>
  <input type="tel" class="form-control" placeholder="전화번호 입력" aria-label="Text input with dropdown button" name="phone">
</div>
<button type="submit">회원가입</button>

</div>
</form>
<%@ include file="bottom.jsp" %>