	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">
	<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Danh sách Dự Án</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="/ffse-fbms/home">Home</a></li>
							<li class="breadcrumb-item active">DANH SÁCH DỰ ÁN</li>
						</ol>
					</div>
				</div>
			</div>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>
					<strong>DỰ ÁN</strong>
				</h1>
			</div>
		</div>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th>Mã Dự Án</th>
						<th>Tên Dự Án</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="entities" items="${list }">
						<tr>
							<td>${entities.maDuAn}</td>
							<td>${entities.tenDuAn}</td>
							<td><a
								href="/ffse-fbms/qlda/DuAn/edit/${entities.maDuAn}"
								data-toggle="tooltip" title="edit">
									<button type="button" class="btn btn-icon btn-outline-warning">
										<i class="fa fa-pencil"></i>
									</button>
							</a> 
							<a
								href="/ffse-fbms/qlda/DuAn/view/${entities.maDuAn}"
								data-toggle="tooltip" title="view">
									<button type="button" class="btn btn-icon btn-outline-info">
										<i class="fa fa-eye"></i>
									</button>
							</a> 
							<a href="/ffse-fbms/qlda/DuAn/delete/${entities.maDuAn}">
									<button type="button"
										onclick="if (!confirm('Are you sure you want to delete this database?')) return false"
										class="btn btn-outline-danger btn-icon checkid"
										data-toggle="modal" title="delete" data-target="#danger">
										<i class="fa fa-trash-o"></i>
									</button>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="row"></div>
		</div>
		<div class="col-sm-4">
			<h5>
				<a href="/ffse-fbms/qlda/DuAn/add_form"><strong>THÊM
						DỰ ÁN</strong></a>
			</h5>
			<c:if test="${message !=null }">
						 ${message }
			</c:if>
		
		</div>
	</div>
</div>
<!-- ////////////////////////////////////////////////////////////////////////////-->

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
