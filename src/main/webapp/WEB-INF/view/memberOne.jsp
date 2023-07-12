<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberOne.jsp</title>
</head>
<body>
	<h1>회원상세정보</h1>
		<table border="1">
			<tr>
				<td>memberId</td>
				<td>${member.memberId}</td>
			</tr>
			<tr>
				<td>memberPw</td>
				<td>****</td>
			</tr>
			<tr>
				<td>updatedate</td>
				<td>${member.updatedate}</td>
			</tr>
			<tr>
				<td>createdate</td>
				<td>${member.createdate}</td>
			</tr>
		</table>
		<a href="${pageContext.request.contextPath}/on/modifyMember">회원정보수정</a>
		<a href="${pageContext.request.contextPath}/on/removeMember">회원탈퇴</a>
</body>
</html>