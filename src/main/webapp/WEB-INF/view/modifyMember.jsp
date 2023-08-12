<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	
	<title>비밀번호 변경</title>
	<!-- 파비콘 설정-->
	<link rel="icon" href="${pageContext.request.contextPath}/assets/img/cashbook.png">
	
	<!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	<link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">  
	<!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/assets/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body class="bg-gradient-primary">
	<div class="container">
	<br><br><br><br><br>
        <!-- Outer Row -->
		<div class="row justify-content-center">
            <div class="col-xl-10 col-lg-12 col-md-9">
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image" style="background-image: url('${pageContext.request.contextPath}/assets/img/modify.jpg')"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">비밀번호 변경</h1>
                                    </div>
                                    <form class="user" method="post" action="${pageContext.request.contextPath}/on/modifyMember">
                                        <div class="form-group">       
											<input type="password" class="form-control form-control-user" name="memberPw" placeholder="현재 비밀번호 입력">
                                        </div>
                                                
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user" name="newPw1" placeholder="수정하려는 비밀번호 입력">
                                        </div>
                                        
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user" name="newPw2" placeholder="수정하려는 비밀번호 재입력">
                                        </div>
                                        
                                        <br>
                                        
                                        <button class="btn btn-primary btn-user btn-block" type="submit">변경하기</button> 
                                        <hr>
                                        
                                    </form>
                                    
                                    <div class="text-center">
                                        <a class="small" href="${pageContext.request.contextPath}/on/cashbook">취소하시겠습니까? 이전페이지로!</a>    
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    
	<!-- 
	<a href="${pageContext.request.contextPath}/on/memberOne">이전으로</a>
	<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
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
		<br>
		<button type="submit">수정</button>
	</form>
	-->
	
	<!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/assets/js/sb-admin-2.min.js"></script>
	
</body>
</html>