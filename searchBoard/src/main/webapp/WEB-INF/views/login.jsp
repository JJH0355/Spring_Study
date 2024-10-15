<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<!-- js를 쓰므로 jquer 사용 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 외부 script 파일 사용 -->
<script src="js/checkID.js"></script>
</head>
<body>

<form action="login.do" method="POST">
<table border="1">
	<tr>
		<td>아이디</td>
		<td><input type="text" name="mid" required id="mid"><span id="result"></span></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="password" required></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input type="submit" value="로그인"></td>
	</tr>
</table>
</form>

</body>
</html>