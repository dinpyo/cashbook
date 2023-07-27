<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

	<title>로그인</title>
	
	<!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	<link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">  
	<!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/assets/css/sb-admin-2.min.css" rel="stylesheet">   
        
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
                            <div class="col-lg-6 d-none d-lg-block bg-login-image" style="background-image: url('${pageContext.request.contextPath}/assets/img/cash.png')"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">계정 로그인</h1>
                                    </div>
                                    <form class="user" id="loginForm" method="post" action="${pageContext.request.contextPath}/off/login">
                                        <div class="form-group">       
											<input type="text" class="form-control form-control-user" name="memberId" id="memberId" value="admin" placeholder="아이디">
											<span style="color: red;" id="memberIdMsg"></span>
                                        </div>
                                                
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user" name="memberPw" id="memberPw" value="1234" placeholder="비밀번호">
                                            <span style="color: red;" id="memberPwMsg"></span>    
                                        </div>
                                        <br>
                                        
                                        <!-- 
	                                        <div class="form-group">
	                                            <div class="custom-control custom-checkbox small">
	                                                <input type="checkbox" class="custom-control-input" id="customCheck">
	                                                <label class="custom-control-label" for="customCheck">Remember
	                                                    Me</label>
	                                            </div>
	                                        </div>
                                         -->
                                       
                                        <button class="btn btn-primary btn-user btn-block" id="loginBtn" type="button">로그인</button> 
                                        <hr>
                                        
                                        <!-- 
	                                        <a href="index.html" class="btn btn-google btn-user btn-block">
	                                            <i class="fab fa-google fa-fw"></i> 구글 계정으로 로그인
	                                        </a>
	                                        <a href="index.html" class="btn btn-facebook btn-user btn-block">
	                                            <i class="fab fa-facebook-f fa-fw"></i> 페이스북 계정으로 로그인
	                                        </a>
                                        -->
                                        
                                    </form>
                                    
                                    <!-- 
                                    	<hr>
	                                    <div class="text-center">
	                                        <a class="small" href="forgot-password.html">비밀번호 찾기</a>
	                                    </div>
                                    -->
                                    
                                    <div class="text-center">
                                        <a class="small" href="${pageContext.request.contextPath}/off/addMember">계정만들기</a>    
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/assets/js/sb-admin-2.min.js"></script>
</body>
</html>