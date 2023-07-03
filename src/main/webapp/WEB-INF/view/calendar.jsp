<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!-- jstl substring호출 -->
<!--  JSP컴파일시 자바코드로 변환되는 c:...(제어문 코드) 커스템태그 사용가능 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, th, td {
		border: 1px solid #bcbcbc;
	}
	
	table {
		width: 50%;
	}
</style>
</head>
<body>
	
	<h1>${targetYear}년 ${targetMonth+1}월</h1>
	<a href="${pageContext.request.contextPath}/calendar?targetYear=${targetYear}&targetMonth=${targetMonth-1}">이전</a>
	<a href="${pageContext.request.contextPath}/calendar?targetYear=${targetYear}&targetMonth=${targetMonth+1}">다음</a>
	
	<table>
		<tr>
			<th><span style="color:red;">일</span></th>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
			<th><span style="color:blue;">토</span></th>
		</tr>
	
		<tr>
			<c:forEach var="i" begin="0" end="${totalCell-1}" step="1">
				<c:set var="d" value="${i-beginBlank+1}"></c:set>
					<c:if test="${i != 0 && i%7 == 0}">
						</tr><tr>
					</c:if>
					
					<c:if test="${d > 0 && d <= lastDate}">
						<td>
							<div>  	 
								<a href="${pageContext.request.contextPath}/cashbookOne?targetYear=${targetYear}&targetMonth=${targetMonth}&targetDate=${d}">
								
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
	</table>
	
</body>
</html>