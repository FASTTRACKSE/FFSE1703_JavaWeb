<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
				<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Update Vendor</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="/ffse-fbms/home">Home</a></li>
							<li class="breadcrumb-item"><a
								href="/ffse-fbms/QuanLyDuAn/vendor/">Danh sách Vendor</a></li>
							<li class="breadcrumb-item active">Update Vendor</li>
						</ol>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>
					<strong>Update Vendor</strong>

				</h1>
			</div>
		</div>
		<form:form method="POST" action="/ffse-fbms/QuanLyDuAn/vendor/update"
			modelAttribute="vendor">


<%-- 			<div class="form-group col-sm-6">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

			</div> --%>
			<div class="form-group col-sm-6">
				<label>Mã Vendor</label>
				<form:input class="form-control" path="mavd" placeholder="Mã Vendor" />
				<form:errors path="mavd" cssStyle="color: red"></form:errors> 

			</div>
			<div class="form-group col-sm-6">
				<label>Tên Vendor</label>
				<form:input class="form-control" path="tenvd" placeholder="Tên Vendor" />
				<form:errors path="tenvd" cssStyle="color: red"></form:errors>

			</div>
			<div class="form-group col-sm-6">
				<label>Địa Chỉ</label>
				<form:input class="form-control" path="diachi" placeholder="Địa Chỉ" />
				<form:errors path="diachi" cssStyle="color: red"></form:errors> 

			</div>
			<div class="form-group col-sm-6">
				<label>Email</label>
				<form:input class="form-control" path="email" placeholder="Email" />
			<form:errors path="email" cssStyle="color: red"></form:errors>

			</div>
			<div class="form-group col-sm-6">
				<label>SĐT</label>
				<form:input class="form-control" path="sdt" placeholder="Số điện thoại" />
				<form:errors path="sdt" cssStyle="color: red"></form:errors> 

			</div>
			<div class="col-sm-12 text-center">
				<button type="submit" class="btn btn-success">Sữa thông tin</button>
			</div>
		</form:form>
	</div>
</div>


<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
