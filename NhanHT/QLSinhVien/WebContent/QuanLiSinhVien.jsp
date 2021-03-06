<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>ADD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<fmt:setBundle basename="resources.${lang}" />
	<div class="dropdown container ">
		<button class="btn btn-default dropdown-toggle " type="button"
			data-toggle="dropdown">
			<fmt:message key="language" />
			<span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="List?lang=Resource_vi_VN">Vietnamese</a></li>
			<li><a href="List?lang=Resource_en_US">English</a></li>
		</ul>
	</div>
	<div class="container">
		<h2>
			<fmt:message key="title" />
		</h2>
		<a href="new?lang=${lang}" class="btn btn-success" role="button"><fmt:message
				key="add" /></a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th><fmt:message key="id" /></th>
					<th><fmt:message key="last_name" /></th>
					<th><fmt:message key="name" /></th>
					<th><fmt:message key="birthday" /></th>
					<th><fmt:message key="country" /></th>
					<th><fmt:message key="gender" /></th>
					<th><fmt:message key="class" /></th>
					<th><fmt:message key="lp0" /></th>
					<th><fmt:message key="lp1" /></th>
					<th><fmt:message key="dtb" /></th>
					<th><fmt:message key="rank" /></th>
					<th><fmt:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				</tr>
				<c:forEach var="x" items="${listSv}">
					<tr>
						<td><c:out value="${x.id}" /></td>
						<td><c:out value="${x.hoDem}" /></td>
						<td><c:out value="${x.ten}" /></td>
						<td><c:out value="${x.ngaySinh}" /></td>
						<td><c:out value="${x.queQuan}" /></td>
						<td><c:out value="${x.gioiTinh}" /></td>
						<td><c:out value="${x.lop}" /></td>
						<td><c:out value="${x.lp0}" /></td>
						<td><c:out value="${x.lp1}" /></td>
						<td><c:out value="${x.getDTB()}" /></td>
						<td><c:out value="${x.xepLoai}" /></td>
						<td><a class="btn btn-info" role="button"
							href="edit?id=<c:out value='${x.id}'/>&lang=${lang}"><fmt:message
									key="edit" /></a> &nbsp;&nbsp;&nbsp;&nbsp; <a
							class="btn btn-danger" role="button"
							href="delete?id=<c:out value='${x.id}' />"><fmt:message
									key="delete" /></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
		<ul class="pagination">
			<c:forEach var="x" begin="1" end="${total+1}">
				<li><a href="ListSinhVien?page=${x}&lang=${lang}"><c:out
							value="${x}" /></a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>