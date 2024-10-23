<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script src="js/preview.js"></script>
</head>
<body>
	<form action="insertBoard.do" method="POST" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>제목</td>
				<td width="20px"><input type="text" name="title" required></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${userID}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td width="20px"><textarea rows="2" cols="10px" name="content"
						required></textarea></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td width="20px">
					<!-- 사진 업데이트 변경 기능 추가 --> <!-- 파일 업로드는 multipart/form-data로 인코딩을 해야한다. -->
						<!-- 사진 업데이트를 위한 input -->
						<input type="file" name="file" onchange="preview(event)">
						<br>
						<!-- 사진 미리보기 기능 -->
						<img id="previewImage" style="display: none; margin: 5px;"
							alt="미리보기 이미지" width="500px">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="게시글 등록"></td>
			</tr>
		</table>
	</form>

</body>
</html>