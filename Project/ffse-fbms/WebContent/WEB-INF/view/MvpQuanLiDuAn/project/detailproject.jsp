<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<!-- ///////////////////////////////////////////////////////// -->


<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Chỉnh sửa dự án</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/mvpquanliduan/project/list-project" />'>Danh
									sách dự án</a></li>
							<li class="breadcrumb-item active">Chi tiết dự án</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<a
			style="float: right; margin: 0px 10px 10px 0px"
			class="btn btn-outline-info "
			href="<c:url value="/mvpquanliduan/project/show-form-edit/${project.idProject}" />"
			title=""><i class="ft-edit"> Chỉnh sửa Dự án</i></a>
			<br>
		<!-- End Path -->
		<div class="content-body">
			<div class="x_panel">
				<div class="x_content">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th colspan="2" style="text-align: center;"><h3>Thông
										tin dự án</h3></th>

							</tr>
							<tr>
								<th>Mã dư án</th>
								<td>${project.idProject }</td>
							</tr>
							<tr>
								<th>Dự án</th>
								<td>${project.nameProject }</td>
							</tr>
							<tr>
								<th>Khách hàng</th>
								<td>${project.khachHang.fullname }</td>
							</tr>
							<tr>
								<th>Thời gian</th>
								<td>- Ngày bắt đầu :${project.startDate} <br> - Ngày
									kết thúc : ${project.endDate}
								</td>
							</tr>
							<tr>
								<th>Mô tả</th>
								<td>${project.detail}</td>
							</tr>
							<tr>
								<th>Nghiệp vụ</th>
								<td>${project.domain.nameDomain}</td>
							</tr>
							<tr>
								<th>Vendor</th>
								<td><c:forEach items="${project.vendor }" var="vendor">
									- ${vendor.nameVendor } 
								</c:forEach></td>
							</tr>
							<tr>
								<th>Tình trạng</th>
								<td>${project.status.nameStatus }</td>
							</tr>
							<tr>
								<th colspan="2" style="text-align: center;"><h3>Công
										nghệ sử dụng</h3></th>

							</tr>
							<tr>
								<th>Framework</th>
								<td><c:forEach items="${project.framework }" var="fr">
															- ${fr.nameFramework  }<br>
									</c:forEach></td>
							</tr>
							<tr>
								<th>Database</th>
								<td><c:forEach items="${project.database }" var="db">
															- ${db.nameDatabase  }<br>
								</c:forEach></td>
							</tr>
							<tr>
								<th>Ngôn ngữ lập trình</th>
								<td><c:forEach items="${project.language }" var="lang">
									- ${lang.nameLanguage } <br>
								</c:forEach></td>
							</tr>

							<tr>
								<th>Kĩ thuật</th>
								<td><c:forEach items="${project.technical }"
										var="technical">
									- ${technical.nameTechnical} <br>
								</c:forEach></td>
							</tr>
						</tbody>
					</table>
					<c:if test="${success != null }">
						${success}
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- ////////////////////////////////////////////////////////////////////////////-->

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />