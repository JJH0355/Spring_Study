<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<script src="js/preview.js"></script>
</head>
<body>
	<table border="1">
		<tr>
			<td>제목</td>
			<td width="100px" align="center">${data.title}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td align="center">${data.writer}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td width="20px">${data.content}</td>
		</tr>
		<!-- 이미지 출력 란 -->
		<tr>
			<td>이미지</td>
			<td>
				<!-- 만약 게시글에 이미지기 없다면 --> <c:if test="${empty path}">
					<!-- 기본 이미지 출력 -->
					<img alt="기본 이미지 출력" src="images/default.png" width="500px">
				</c:if> <c:if test="${not empty path}">
					<img alt="해당 게시물의 이미지 출력" src="images/${path}" width="500px">
				</c:if>
			</td>
		</tr>
	</table>

	<!-- 작성자와 사용자의 닉네임이 같을 경우에만 보임 -->
	<c:if test="${data.writer != null && data.writer.equals(userID)}">
		<!-- 사진 업데이트 변경 기능 추가 -->
		<!-- 파일 업로드는 multipart/form-data로 인코딩을 해야한다. -->
		<form action="updateBoard.do" method="POST"
			enctype="multipart/form-data">
			<!-- 사진 업데이트를 위한 input -->
			<input type="hidden" name="bNum" value="${data.bNum}"> 			
			이미지 <input
				type="file" name="file" onchange="preview(event)"> <br>
			<!-- 사진 미리보기 기능 -->
			<img id="previewImage" style="display: none; margin: 5px;"
				alt="미리보기 이미지" width="500px"><br> <input type="submit" value="이미지 변경">
		</form>
	</c:if>

	<a href="main.do">메인페이지로 돌아가기</a>
</body>
</html>