<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cashbookOne.jsp</title>
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
	<a href="${pageContext.request.contextPath}/on/calendar">이전으로</a>
	<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
	<h1>${targetYear}년 ${targetMonth+1}월 ${targetDate}일 수입/지출 내역</h1>
	<table>
		<tr>	
			<th>번호</th>
			<th>수입/지출</th>
			<th>날짜</th>	
			<th>금액</th>
			<th>메모</th>
			<th>수정날짜</th>
			<th>작성날짜</th>
		</tr>
			<c:forEach var="c" items="${list}">
				<tr>
					<td>${c.cashbookNo}</td>
					<td>${c.category}</td>
					<td>${c.cashbookDate}</td>
					<td>${c.price}</td>
					<td>${c.memo}</td>		
					<td>${c.updatedate}</td>
					<td>${c.createdate}</td>
				</tr>
			</c:forEach>
	</table>
	<br>
	<a href="${pageContext.request.contextPath}/on/addCashbook?targetYear=${targetYear}&targetMonth=${targetMonth}&targetDate=${targetDate}">
		추가
	</a>
</body>
</html>