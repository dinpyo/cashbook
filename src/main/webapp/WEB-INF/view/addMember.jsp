<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>회원가입</title>
	
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
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image" style="background-image: url('${pageContext.request.contextPath}/assets/img/join.jpg')"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">계정을 만드세요!</h1>
                            </div>                         
                            <form class="user" method="post" action="${pageContext.request.contextPath}/off/addMember">
                               	<!-- 
									<div class="form-group row">
	                                    <div class="col-sm-6 mb-3 mb-sm-0">
	                                        <input type="text" class="form-control form-control-user" id="exampleFirstName"
	                                            placeholder="이름">
	                                    </div>
	                                    <div class="col-sm-6">
	                                        <input type="text" class="form-control form-control-user" id="exampleLastName"
	                                            placeholder="성">
	                                    </div>
	                                </div>
                               	-->
                             
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="exampleInputEmail" placeholder="아이디" name="memberId" required="required">
                                </div>  
                                <div class="form-group">
                                    <input type="password" class="form-control form-control-user" id="exampleInputPassword" placeholder="비밀번호" name="memberPw" required="required">
                                </div>
                                             
                                <button class="btn btn-primary btn-user btn-block" type="submit">계정 등록</button>
                                <br><br><br><br>
                                <!-- 
	                                <hr>
	                                <a href="index.html" class="btn btn-google btn-user btn-block">
	                                    <i class="fab fa-google fa-fw"></i> Register with Google
	                                </a>
	                                <a href="index.html" class="btn btn-facebook btn-user btn-block">
	                                    <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
	                                </a>
                                -->
                            </form>
                            <hr>                         
                            <div class="text-center">
                                <a class="small" href="${pageContext.request.contextPath}/off/login">이미 계정이 있으신가요? 로그인으로!</a>
                            </div>    
                            <br><br>
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