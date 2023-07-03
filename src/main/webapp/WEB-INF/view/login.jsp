<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#loginBtn').click(function() {
			if($('#memberId').val().length == 0 || $('#memberPw').val().length == 0){
				if($('#memberId').val().length==0){
					console.log($('#memberId').val());
					$('#memberIdMsg').text('아이디를 입력해주세요');	
				}
				
				if($('#memberPw').val().length == 0) {
					console.log($('#memberPw').val());
					$('#memberPwMsg').text('비밀번호를 입력해주세요');
				}
					return;
			}
			$('#loginForm').submit();
		});		
	});
	
	
</script>

</head>
<body>
	<h1>로그인</h1>
	<form id="loginForm" method="post" action="${pageContext.request.contextPath}/login">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="memberId" id="memberId">
					<span id="memberIdMsg"></span>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="memberPw" id="memberPw">
					<span id="memberPwMsg"></span>
				</td>
			</tr>
		</table>
		<button id="loginBtn" type="button">로그인</button>
		<a href="${pageContext.request.contextPath}/addMember">회원가입</a>
	</form>
</body>
</html>