<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="boardlist"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
			<tr>
				<td colspan="6">검색 결과가 없습니다.</td>
			</tr>
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