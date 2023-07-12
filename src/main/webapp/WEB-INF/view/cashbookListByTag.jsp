<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cashbookListByTag.jsp</title>
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
	<h1>#${word} 해시태그 전체 리스트</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>수입/지출</th>
			<th>날짜</th>
			<th>금액</th>
			<th>메모</th>
			<th>수정일</th>
			<th>생성일</th>
		</tr>
		
		<c:forEach var="m" items="${list}">
		<tr>
			<td>${m.cashbookNo}</td>
			<td>${m.category}</td>
			<td>${m.cashbookDate}</td>
			<td>${m.price}</td>
			<td>${m.memo}</td>
			<td>${m.updatedate}</td>
			<td>${m.createdate}</td>
		</tr>
		</c:forEach>
	</table>
	
	<c:if test="${currentPage > 1}">
		<a href="${pageContext.request.contextPath}/on/cashbookListByTag?word=${word}&currentPage=${currentPage-1}">이전</a>
	</c:if>
	<span>${currentPage}</span>
	<c:if test="${currentPage < lastPage}">
		<a href="${pageContext.request.contextPath}/on/cashbookListByTag?word=${word}&currentPage=${currentPage+1}">다음</a>
	</c:if>
	
</body>
</html>