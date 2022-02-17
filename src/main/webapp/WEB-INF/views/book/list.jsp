<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>애플리케이션</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<div class="container">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="/">홈</a></li>
			<li class="nav-item"><a class="nav-link" href="/book/list">책</a></li>
		</ul>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/login">로그인</a></li>
			<li class="nav-item"><a class="nav-link" href="/register">회원가입</a></li>
			<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
		</ul>
	</div>
</nav>
<div class="container my-3">
	<div class="row mb-3">
		<div class="col">
			<h1>도서목록</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<p>도서목록을 확인하세요</p>
			<table class="table">
				<thead>
					<tr>
						<th style= "width:10%;">순번</th>
						<th style= "width:40%;">제목</th>
						<th style= "width:20%;">저자</th>
						<th style= "width:15%;">출판사</th>
						<th style= "width:15%;">가격</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${books }" varStatus="loop">
						<tr>
							<td>${loop.count }</td>
							<td>${book.title }</td>
							<td>${book.author }</td>
							<td>${book.publisher }</td>
							<td><fmt:formatNumber value="${book.price }"/>원</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row mb-5">
		<div class="col">
			<!-- 서버에 저장된 파일을 내려받기 -->
			<p>입고예정 도서목록을 다운받아보세요 <a href="/book/books" class="btn btn-primary btn-sm float-end ">다운로드</a></p>
			<!-- 데이터베이스에서 데이터를 조회해서 생성된 엑셀파일을 내려받기 
			/ 서버에는 좋지않기 때문에 매번 내려보내는 것보단 스케줄러로 조정해서 일주일에 한번씩만들어내려보내기
			/ but, 은행업무 조회해서 내려받는건 개개인정보가 실시간으로 달라지기떼문에 이대로 구현.
			-->
			<p>베스트셀러 도서목록을 다운받아보세요 <a href="/book/books" class="btn btn-primary btn-sm float-end ">다운로드</a></p>
		</div>
	</div>
</div>
</body>
</html>