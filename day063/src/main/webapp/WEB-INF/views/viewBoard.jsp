<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
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
	</table>
	<a href="main.do">메인페이지로 돌아가기</a>
</body>
</html>