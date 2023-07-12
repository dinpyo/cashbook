<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보수정</h1>
	<form method="post" action="${pageContext.request.contextPath}/on/modifyMember">
		<table border="1">
			<tr>
				<td>현재 비밀번호 입력</td>
				<td><input type="password" name="memberPw"></td>
			</tr>
			<tr>
				<td>수정하려는 비밀번호 입력</td>
				<td><input type="password" name="newPw1"></td>
			</tr>
			<tr>
				<td>수정하려는 비밀번호 재입력</td>
				<td><input type="password" name="newPw2"></td>
			</tr>
		</table>
		<button type="submit">수정</button>
	</form>
</body>
</html>