<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<jsp:include page="../header.jsp"></jsp:include>
	<h1>친구 목록</h1>

	<div>${requestScope.friendList }</div>

	<div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>No</th>
					<th>FriendName</th>
					<th>Mobile</th>
					<th>Addr</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="friend" items="${requestScope.friendList }">
					<tr>
						<th>${friend.friendNo }</th>
						<th>${friend.friendName }</th>
						<th>${friend.mobile }</th>
						<th>${friend.addr }</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>