<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Sửa Dự Án</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="/ffse-fbms/home">Home</a></li>
							<li class="breadcrumb-item"><a
								href="/ffse-fbms/qlda/DuAn/">Danh sách Dự Án</a></li>
							<li class="breadcrumb-item active">Thông tin Dự Án</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>
					<strong>SỬA DỰ ÁN</strong>

				</h1>
			</div>
		</div>
		<form:form method="POST" action="/ffse-fbms/qlda/DuAn/update"
			modelAttribute="duAn">


			<div class="form-group col-sm-6">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> <label>Mã Dự Án </label>
				<form:input class="form-control" path="maDuAn" readonly="true"
					placeholder="Mã Dự Án " />
				<form:errors path="maDuAn" readonly="true" cssStyle="color: red"></form:errors>
			</div>
			<div class="form-group col-sm-6">
				<label>Tên Dự Án</label>
				<form:input class="form-control" path="tenDuAn"
					placeholder="Tên Dự Án " />
				<form:errors path="tenDuAn" cssStyle="color: red"></form:errors>
			</div>
				<div class="col-sm-12 text-center">
				<button type="submit" class="btn btn-success">Lưu thông tin</button>
			</div>
		</form:form>


	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
