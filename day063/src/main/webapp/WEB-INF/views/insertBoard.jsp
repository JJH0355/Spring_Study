<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
<form action="insertBoard.do" method="POST">
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
			<td width="20px"><textarea rows="2" cols="10px" name="content" required></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="게시글 등록"></td>
		</tr>
	</table>
</form>

</body>
</html>