<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!-- jstl substring호출 -->
<!--  JSP컴파일시 자바코드로 변환되는 c:...(제어문 코드) 커스템태그 사용가능 -->

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	
	<title>달력</title>
	
	<!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/assets/css/sb-admin-2.min.css" rel="stylesheet">   
<style>
	tr, th, td {
		border: 1px solid #bcbcbc;
		width: 10%;
		height: 10%;
	}
	table {
		border: 1px solid #bcbcbc;
		width: 60%;
		height: 80%;
	}
</style>
</head>
<body id="page-top">
	<!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Sidebar -->
        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${pageContext.request.contextPath}/on/cashbook">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">가계부<sup>2</sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- 메뉴 시작 -->
            <div class="sidebar-heading">
                메인 메뉴
            </div>

            <!-- 좌측 네비게이션 캘린더 -->
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/on/calendar">
                    <i class="fas fa-fw fa-table"></i>
                    <span>캘린더</span></a>
            </li>
			
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                개인정보
            </div>

            <!-- 좌측 네비게이션 오픈되는 아이템 -->
            <li class="nav-item active">
                <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true"
                    aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>개인정보수정</span>
                </a>
                <div id="collapsePages" class="collapse show" aria-labelledby="headingPages"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">계정 관련</h6>
                        
                        <a class="collapse-item" href="${pageContext.request.contextPath}/on/memberOne">회원정보</a>
                        <a class="collapse-item" href="${pageContext.request.contextPath}/on/modifyMember">비밀번호 변경</a>                        
                        <a class="collapse-item" href="${pageContext.request.contextPath}/on/removeMember">회원탈퇴</a>
                    </div>
                </div>
            </li>
            
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
            
            <li class="nav-item">
            	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
				<a class="nav-link" href="${pageContext.request.contextPath}/logout">
				<i class="fas fa-fw fa-sign-out-alt"></i>
				<span>로그아웃</span></a>
	        </li> 
        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- 상단바 시작 -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- 상단바 -->
                    <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
							달력
                        </div>
                    </form>

                    <!-- 상단 네비게이션 바 -->
                    <ul class="navbar-nav ml-auto">
                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>
          
                        <!-- 상단 네비게이션 회원 정보 -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span style="font-size: 18px;" class="mr-2 d-none d-lg-inline text-gray-600 small">${memberId}</span>
                                <img class="img-profile rounded-circle"
                                    src="${pageContext.request.contextPath}/assets/img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/on/memberOne">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    회원정보
                                </a>             
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    로그아웃
                                </a>
                            </div>
                        </li>
                    </ul>

                </nav>
                <!-- 상단바 끝 -->

				<!-- Begin Page Content -->
                <div class="container-fluid">
                
                	<!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">전체 해시태그</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                            	<c:forEach var="m" items="${htList}">
									<a style="color:#9900CC; text-decoration:none;" href="${pageContext.request.contextPath}/on/cashbookListByTag?word=${m.word}">
										# ${m.word}&nbsp;  
									</a>
								</c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">이달의 해시태그</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                            	<c:forEach var="m" items="${htList}">
									<a style="color:#9900CC; text-decoration:none;" href="${pageContext.request.contextPath}/on/hashtagOne?targetYear=${targetYear}&targetMonth=${targetMonth}&word=${m.word}">
										# ${m.word}(${m.cnt})&nbsp;
									</a>
								</c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">가계부&nbsp;<span style="color: black;">(날짜를 눌러 추가, 삭제 가능)</span></h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                            <!-- 변수값or반환값 : EL사용 $ 표현식 -->
							<!-- 
								속성값대신 EL사용 
								ex) 
								request.getAttribute("targetYear") -- requestScope.targetYear 
								(requestScope는 생략가능)
								형변환연산이 필요없다(EL이 자동으로 처리)
							-->	
							<div style="text-align: center;">
								<a href="${pageContext.request.contextPath}/on/calendar?targetYear=${targetYear}&targetMonth=${targetMonth-1}">
									<img src="${pageContext.request.contextPath}/assets/img/left.jpg" style="width: 80px; height: 70px;">
								</a>
								<span style="font-size: 20pt;">${targetYear}년 ${targetMonth+1}월</span>
								<a href="${pageContext.request.contextPath}/on/calendar?targetYear=${targetYear}&targetMonth=${targetMonth+1}">
									<img src="${pageContext.request.contextPath}/assets/img/right.jpg" style="width: 80px; height: 70px;">
								</a>
							</div>
							<br>					
                            	<table class="table table-bordered" id="dataTable" style="width: 100%; height: 800px;">
                                    <thead>
                                        <tr>
                                            <th style="text-align: center;"><span style="color:red;">일</span></th>
											<th style="text-align: center;">월</th>
											<th style="text-align: center;">화</th>
											<th style="text-align: center;">수</th>
											<th style="text-align: center;">목</th>
											<th style="text-align: center;">금</th>
											<th style="text-align: center;"><span style="color:blue;">토</span></th>
                                        </tr>
                                    </thead>
                                    <tbody>                                    
                                        <tr>
											<!-- 자바코드(제어문) : JSTL 사용 -->
											<c:forEach var="i" begin="0" end="${totalCell-1}" step="1">
												<c:set var="d" value="${i-beginBlank+1}"></c:set>
													<c:if test="${i != 0 && i%7 == 0}">
														</tr><tr>
													</c:if>
					
													<c:if test="${d > 0 && d <= lastDate}">
														<td>
															<div>  	 
																<a style="color:#000000; text-decoration:none;" href="${pageContext.request.contextPath}/on/cashbookOne?targetYear=${targetYear}&targetMonth=${targetMonth}&targetDate=${d}">
																
																	<c:if test="${i%7 == 0}">
																		<span style="color:red;">${d}</span>
																	</c:if>
																	<c:if test="${(i%7)-6 == 0}">
																		<span style="color:blue;">${d}</span>
																	</c:if>
																	<c:if test="${!(i%7 == 0) && !((i%7)-6 == 0)}">
																		<span>${d}</span>
																	</c:if>
																</a> 	
															</div>	
															
															<c:forEach var="c" items="${list}">
																<c:if test="${d == fn:substring(c.cashbookDate,8,10)}">
																	<div>
																		<c:if test="${c.category == '수입'}">
																			<span style="color:blue;">+${c.price}</span>
																		</c:if>
																	
																		<c:if test="${c.category == '지출'}">
																			<span style="color:red;">-${c.price}</span>
																		</c:if>
																	</div>
																</c:if>
															</c:forEach>	
														</td>	
													</c:if>
						
													<c:if test="${!(d > 0 && d <= lastDate)}">
														<td></td>
													</c:if>
											</c:forEach>
										</tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->  
            </div>
            <!-- End of Main Content -->

            <!-- 저작권 시작 -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Website 2023</span>
                    </div>
                </div>
            </footer>
            <!-- 저작권 끝 -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- 상단 로그아웃 네비게이션 동작 시작 -->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">로그아웃 하시겠습니까?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">로그아웃을 원하시면 "로그아웃"을 선택해주세요.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/logout">로그아웃</a>
                </div>
            </div>
        </div>
    </div>
	<!-- 상단 로그아웃 네비게이션 동작 끝 -->
	
	<!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/assets/js/sb-admin-2.min.js"></script>
</body>
</html>