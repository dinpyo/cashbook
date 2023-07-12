<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addMember.jsp</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/off/login">이전으로</a>
	<h1>회원가입</h1>
	<form method="post" action="${pageContext.request.contextPath}/off/addMember">
		<table border="1">
			<tr>
				<td>memberId</td>
				<td><input type="text" name="memberId" required="required"></td>
			</tr>
			<tr>
				<td>memberPw</td>
				<td><input type="password" name="memberPw" required="required"></td>
			</tr>
		</table>
		<br>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>