<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>

<!-- js를 쓰므로 jquery 사용 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 외부 script 파일 사용 -->
<script src="js/searchBoard.js"></script>

</head>
<body>

	<h1>
		<c:if test="${not empty userID}">
		${userID}님,
	</c:if>
		안녕하세요! :D
	</h1>

	<hr>
	<c:if test="${not empty userID}">
		<a href="logout.do">로그아웃</a>
	</c:if>
	<c:if test="${empty userID}">
		<a href="login.do">로그인</a>
	</c:if>

	<hr>

	<h3>글 목록</h3>
	<!-- 글목록 검색 구간 -->
	<!-- 검색 카테고리 : 내용 검색, 작성자 검색 -->
	<select name="searchCate" id="search-cate-select">
		<option value="CONTENT">내용 검색</option>
		<option value="WRITER">작성자 검색</option>
	</select>
	<!-- 검색어 입력 -->
	<input type="text" name="searchKeyword" id="search-keyword-input"
		placeholder="검색어를 입력해주세요." value="${searchKeyword}">
	<!-- 검색어 버튼 -->
	<input type="button" value="검색" id="btn">
	<a href="main.do" >검색 결과 초기화</a>

	<!-- 글목록 출력 구간 -->
	<table border="1">
		<tr>
			<th width="80px">글 번호</th>
			<th width="150px">제목</th>
			<th width="100px">작성자</th>
			<th width="1000px">내용</th>
		</tr>

		<tbody id="data-list">
			<c:forEach var="data" items="${datas}">
				<tr>
					<td align="center">${data.bNum}</td>
					<td align="center">${data.title}</td>
					<td align="center">${data.writer}</td>
					<td align="left">${data.content}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<hr>

	<a href="insertBoard.do">글 작성</a>

</body>
</html>