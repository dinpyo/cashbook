<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	<h1>수입/지출 내역</h1>
	<table>
		<tr>
			<th>수입/지출</th>
			<th>금액</th>
			<th>메모</th>
			<th>작성날짜</th>
		</tr>
			<c:forEach var="c" items="${list}">
				<tr>
					<td>${c.category}</td>
					<td>${c.price}</td>
					<td>${c.memo}</td>
					<td>${c.createdate}</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>