<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
</head>
<body>
	<fmt:setBundle basename="resources.${lang}" />
	<center>
		<h1><fmt:message key="edit_student" /></h1>
	</center>
	<div class="container">
		<form action="update" method="post" class="container">
			<c:if test="${sinhVien != null}">
				<input type="hidden" name="id"
					value="<c:out value='${sinhVien.id}' />" />
			</c:if>
			<div class="form-group">
				<label for="text"><fmt:message key="last_name" /></label> <input type="text"
					value="<c:out value='${sinhVien.hoDem}'/>" class="form-control"
					name="HoDem">
			</div>
			<div class="form-group">
				<label for="text"><fmt:message key="name" /></label> <input type="text"
					value="<c:out value='${sinhVien.ten}'/>" class="form-control"
					name="TenSv">
			</div>
			<div class="form-group">
				<label for="text"><fmt:message key="birthday" /></label> <input type="text"
					value="<c:out value='${sinhVien.ngaySinh}' />" class="form-control"
					name="NgaySinh">
			</div>
			<div class="form-group">
				<label for="text"><fmt:message key="country" /></label> <input type="text"
					value="<c:out value='${sinhVien.queQuan}'/>" class="form-control"
					name="QueQuan">
			</div>
			<div class="form-group">
				<label for="text"><fmt:message key="gender" /></label> <input type="text"
					value="<c:out value='${sinhVien.gioiTinh}' />" class="form-control"
					name="GioiTinh">
			</div>
			<div class="form-group">
				<label for="text"><fmt:message key="class" /></label> <input type="text"
					value="<c:out value='${sinhVien.lop}' />" class="form-control"
					name="Lop">
			</div>
			<div class="form-group">
				<label for="text"><fmt:message key="lp0" /></label> <input type="text"
					value="<c:out value='${sinhVien.lp0}' />" class="form-control"
					name="LP0">
			</div>
			<div class="form-group">
				<label for="text"><fmt:message key="lp1" /></label> <input type="text"
					value="<c:out value='${sinhVien.lp1}' />" class="form-control"
					name="LP1">
			</div>

			<button type="submit" class="btn btn-default"><fmt:message key="edit" /></button>
			<a href="list?lang=${lang }" class="btn btn-warning" role="button"><fmt:message key="list" /></a>
		</form>
	</div>
</body>
</html>