<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
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
	<!-- form 구간 : 검색 카테고리, 검색어 입력, 버튼 -->
	<form action="searchBoard.do" method="GET" id="searchForm">
		<!-- 검색 카테고리 : 내용 검색, 작성자 검색 -->
		<select name="searchCate" id="searchCateSelect">
			<option value="CONTENT">내용 검색</option>
			<option value="WRITER">작성자 검색</option>
		</select>
		<!-- 검색어 입력 -->
		<input type="text" name="searchKeyword" id="searchKeywordInput" placeholder="검색어를 입력해주세요."
			value="${searchKeyword}">
		<!-- 검색어 버튼 -->
		<input type="submit" value="검색">
	</form>
	<table border="1">
		<tr>
			<th width="80px">글 번호</th>
			<th width="150px">제목</th>
			<th width="100px">작성자</th>
			<th width="1000px">내용</th>
		</tr>
		<c:if test="${fn:length(datas) < 1 || empty datas}">
		
			검색 결과가 없습니다.
		</c:if>
		<c:forEach var="data" items="${datas}">
			<tr>
				<td align="center">${data.bNum}</td>
				<td align="center">${data.title}</td>
				<td align="center">${data.writer}</td>
				<td align="left">${data.content}</td>
			<tr>
		</c:forEach>
	</table>

	<hr>

	<a href="insertBoard.do">글 작성</a>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript">
	
		// 검색 기록 유지 함수
		$(document).ready(function(){
			saveSearchValue();
		});
		
		function saveSearchValue(){
			var searchCate = "${searchCate}";
			console.log("searchCate : ["+searchCate+"]");
			
			if(searchCate != null && searchCate.length > 0){
				console.log("if : true");
				$('#searchCateSelect').val(searchCate);
			} else {
	            console.log("if : false");
	        }
		}
		
		// searchKeyword 값이 없을 시 알랏창 출력
		// searchForm의 submit 버튼 클릭 시 작동
		document.getElementById('searchForm').addEventListener('submit', function(event) {
			// input 입력값 searchKeyword 가져오기
			var searchKeyword = document.getElementById('searchKeywordInput');
			console.log("searchKeyword : ["+searchKeyword+"]");
			
			// 만약 값이 비어있다면
			if(!searchKeyword.value){
				// 기본 제출 동작 중지
		        event.preventDefault();
				
				// 알랏창 출력
		        alert("검색어를 입력하세요.");
			}
		});
	</script>

</body>
</html>