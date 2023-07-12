<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>removeMember.jsp</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/on/memberOne">이전으로</a>
	<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
	<h1>회원탈퇴</h1>
	<form method="post" action="${pageContext.request.contextPath}/on/removeMember">
		<table border="1">
			<tr>
				<td>memberId</td>
				<td><input type="text" name="memberId"></td>
			</tr>
			<tr>
				<td>memberPw</td>
				<td><input type="password" name="memberPw"></td>
			</tr>
		</table>
		<br>
		<button type="submit">회원탈퇴</button>
	</form>
</body>
</html>