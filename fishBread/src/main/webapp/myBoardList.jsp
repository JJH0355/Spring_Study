<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, java.util.HashMap, java.util.Map, java.util.List"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>내가 쓴 게시글</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="${path}/resources\assets\css\boardlist.css">
<link rel="stylesheet" href="${path}/resources/assets/css/searchbar.css">
<link rel="stylesheet"
	href="${path}/resources/assets/css/pagination.css">

<!-- bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>

	<div class="container-md">
		<custom:header/>
		<!-- 첫 번째 행 -->
		<div class="row">
			<!-- page title line-->
			<div class="col-4">
				<p hidden>000님이 작성한 게시글</p>
				<div class="page-title">${member.memberName}님이 작성한 게시글</div>
			</div>
			<div class="col-8">
				<p hidden>빈 공간</p>
			</div>
		</div>

		<!-- 두 번째 행 -->
		<div class="row align-items-center">
			<!-- search line -->
			<div class="col-4">
				<p hidden>검색창</p>
				<div class="search-input" id="search-box">
					<img src="resources/assets/images/search_icon.png"
						alt="검색창 아이콘 이미지" width="40px" height="40px"> <input
						type="text" name="storeName" placeholder="가게 이름을 입력해주세요.">
					<input type="submit" value="검색">
				</div>

			</div>
			<div class="col-6">
				<p hidden>빈 공간</p>
			</div>
			<div class="col-2 text-end">
				<p hidden>일반 게시판 가기</p>
				<button>일반 게시판 가기</button>
			</div>
		</div>

		<!-- 세 번째 행 -->
		<div class="row">
			<div class="col-12">
				<p hidden>게시글 리스트</p>
				<table class="custom-table">
					<thead>
						<tr>
							<th class="table-date">작성일자</th>
							<th class="table-num">번호</th>
							<th class="table-title">제목</th>
							<th class="table-writer">작성자</th>
							<th class="table-reply-num">댓글 수</th>
							<th class="table-like">좋아요 수</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${fn:length(datas) < 1 || empty datas}">
							<tr><td colspan="6">검색 결과가 없습니다. </td></tr>
						</c:if>
						<c:forEach var="data" items="${datas}">
							<tr>
								<td align="center">${data.date}</td>
								<td align="center">${data.boardNum}</td>
								<td align="center">${data.title}</td>
								<td align="left">${data.writer}</td>
								<td align="left">${data.replyCnt}</td>
								<td align="left">${data.likeCnt}</td>
							<tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>

		<!-- 네 번째 행 -->
		<div class="row">
			<div class="col-12">
				<p hidden>페이지네이션</p>
				<!-- 페이지네이션 -->
				<section id="pagination">
					<div class="pagination">
						<!-- 이전 페이지 버튼 -->
						<c:if test="${currentPage > 1}">
							<a
								href="?page=${currentPage - 1}&storeName=${param.storeName != null ? param.storeName : ''}"
								id="pagenationPreValue">&laquo; 이전</a>
						</c:if>

						<c:set var="startPage" value="${currentPage - 5}" />
						<c:set var="endPage" value="${currentPage + 4}" />

						<c:if test="${startPage < 1}">
							<c:set var="startPage" value="1" />
						</c:if>
						<c:if test="${endPage > totalPages}">
							<c:set var="endPage" value="${totalPages}" />
						</c:if>

						<c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${i == currentPage}">
									<strong>${i}</strong>
								</c:when>
								<c:otherwise>
									<a
										href="?page=${i}&storeName=${param.storeName != null ? param.storeName : ''}"
										id="pagenationValue">${i}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${currentPage < totalPages}">
							<a
								href="?page=${currentPage + 1}&storeName=${param.storeName != null ? param.storeName : ''}"
								id="pagenationNextValue">다음 &raquo;</a>
						</c:if>
					</div>
				</section>
				<!-- 페이지네이션 종료 -->
			</div>
		</div>
		<custom:footer/>
	</div>
</body>
</html>