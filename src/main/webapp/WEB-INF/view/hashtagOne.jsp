<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hashOne.jsp</title>
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
	<h1>#${word} 해시태그 리스트</h1>
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
			<td>
				<a href="${pageContext.request.contextPath}/cashbookOne?targetYear=${targetYear}&targetMonth=${targetMonth}&targetDate=${m.targetDate}">
					${m.category}
				</a>
			</td>
			<td>${m.cashbookDate}</td>
			<td>${m.price}</td>
			<td>${m.memo}</td>
			<td>${m.updatedate}</td>
			<td>${m.createdate}</td>
		</tr>
		</c:forEach>
	
	
	
	
	</table>
</body>
</html>