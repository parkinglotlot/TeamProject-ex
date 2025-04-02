<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>Insert title here</title>
<script>
	$(function() {
		// 이름을 입력하고 blur 되었을 때
		$("#friendName").keyup(function() {
			searchFriend($("#friendName").val());
		})

	})
	
	function searchFriend(fname) {
		console.log(fname);
		// 검색어가 1 글자 이상일 때
		if (fname.length > 0) {
			$.ajax({
		          url: "<%=request.getContextPath()%>/FindFriendByName.do", // 데이터가 송수신될 서버의 주소
				type : "GET", // 통신 방식 (GET, POST, PUT, DELETE)
				async : false,
				data : { // 서버에 전송할 데이터
					'searchName' : fname
				},
				dataType : "json", // 수신받을 데이터 타입 (MIME TYPE)
				success : function(data) {
					// 통신이 성공하면 수행할 함수
					outputFriends(data)
				},
				error : function() {
				},
				complete : function() {
				},
			});
			

		}
	}
	
	function outputFriends(data) {

		let output='';
		
		$.each(data, function(index, item) {
		console.log(item);
		output += `<div class="card"><div class="card-body">`
		output += `<h4 class="card-title">\${item.friendName}</h4>
		<a href="#" class="card-link">\${item.mobile}</a>
		<p class="card-text">\${item.addr}</p></div></div>`
			
		})
	$(".friends").html(output);
	}
</script>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>

	<div class="container mt-3">
		<h1>친구 이름 검색</h1>
		<div class="mb-3 mt-3">
			<label for="friendName">이름 :</label> <input type="text"
				class="form-control" id="friendName"
				placeholder="Enter friend's name..." name="friendName">
		</div>
	</div>
</body>
</html>