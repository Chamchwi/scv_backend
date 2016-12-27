<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>사용자 목록</title>
<jsp:include page="../include/common.jsp"></jsp:include>

</head>

<body>
	<br>
	<br>
	<br>
	<div class="container">
		<div style="text-align: center;" class="jumbotron">
			<h2>사용자 목록</h2>
		</div>


		<br> <br>

		<div class="panel panel-default">

			<!-- Table -->
			<table class="table">
				<thead>
					<tr>
						<th scope="col">이메일</th>
						<th scope="col">토큰값</th>
						<th scope="col">비밀번호</th>
						<th scope="col">닉네임</th>
						<th scope="col">모드</th>
						<th scope="col">점수</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(list) > 0}">
							<c:forEach items="${list }" var="row">
								<tr>
									<td>${row.email }</td>
									<td>${row.token }</td>
									<td>${row.password }</td>
									<td>${row.nickname }</td>
									<td>${row.mode }</td>
									<td>${row.score }</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="4">조회된 결과가 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>

				</tbody>
			</table>
</body>
</div>
</div>


</body>

</html>
