<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addCashbook.jsp</title>
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
	<a href="${pageContext.request.contextPath}/on/cashbookOne?targetYear=${targetYear}&targetMonth=${targetMonth}&targetDate=${targetDate}">이전으로</a>
	<h1>${targetYear}년 ${targetMonth+1}월 ${targetDate}일 수입/지출 추가</h1>
	<form method="post" action="${pageContext.request.contextPath}/on/addCashbook?targetYear=${targetYear}&targetMonth=${targetMonth}&targetDate=${targetDate}">	
		<table>
			<tr>
				<th>수입/지출</th>
				<td>
					<input type="radio" name="category" value="수입">수입
					<input type="radio" name="category" value="지출">지출
				</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>
					<input type="text" name="cashbookDate" value="${targetYear}-${targetMonth+1}-${targetDate}" readonly="readonly">
				</td>
			</tr>	
			<tr>
				<th>가격</th>
				<td>
					<input type="number" name="price" required="required">
				</td>
			</tr>
			<tr>
				<th>메모</th>
				<td>
					<input type="text" name="memo" required="required">
				</td>
			</tr>
		</table>
		<br>
		<button type="submit">추가</button>
	</form>
</body>
</html>