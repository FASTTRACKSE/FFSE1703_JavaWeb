
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">
					<spring:message code="label.danhSachHopDong" />
				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="<c:url value = "/"/>"><spring:message
										code="label.trangChu" /></a></li>
							<li class="breadcrumb-item"><a href="javascript:void(0)"><spring:message
										code="label.quanLyNhanSu" /></a></li>
							<li class="breadcrumb-item"><a href="javascript:void(0)"><spring:message
										code="label.quanLyHopDong" /></a></li>
							<li class="breadcrumb-item active"><spring:message
									code="label.danhSachHopDong" /></li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a href="<c:url value = "/quanlynhansutt/add"/>"
						class="btn btn-primary"><span class="fa fa-plus"></span> Thêm
						mới</a>
				</div>
			</div>
		</div>
		<!-- End Path -->
		<div class="content-body">
			<!-- Zero configuration table -->
			<section id="configuration">
				<div class="row">
					<div class="col-xs-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Datatable</h4>
								<a class="heading-elements-toggle"><i
									class="fa fa-ellipsis-v font-medium-3"></i></a>
								<div class="heading-elements">
									<ul class="list-inline mb-0">
										<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
										<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
									</ul>
								</div>
							</div>
							<style type="text/css">
.table td {
	vertical-align: baseline;
}

th, td {
	padding-left: 1rem !important;
	padding-right: 1rem !important;
}

#datatable tr td:last-child {
	letter-spacing: 15px;
	min-width: 100px;
	text-align: center !important;
}
</style>
							<div class="card-body collapse in">
								<div class="card-block card-dashboard">
									<table id="datatable"
										class="table table-striped table-bordered zero-configuration">
										<thead>
											<tr>
												<th>Mã hợp đồng</th>
												<th>Mã nhân viên</th>
												<th>Tên loại hợp đồng</th>
												<th>Tên chức danh</th>
												<th>Lương Tháng 13</th>
												<th>Số Ngày Phép</th>
												<th>Ngày Ký</th>
												<th>Hợp Đồng Từ Ngày</th>
												<th>Hợp Đồng Đến Ngày</th>
												<th>Trạng Thái</th>
												<th>Chức Năng</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listHopDong}" var="hshd">
												<tr>
													<td>${hshd.maHopDong}</td>
													<td>${hshd.hoSoNhanVien.maNhanVien}</td>
													<td>${hshd.loaiHopDong.tenHopDong}</td>
													<td>${hshd.chucDanh.tenChucDanh}</td>
													<td><c:if test="${hshd.luongThang13 == 1}">
															<spring:message code="label.co" />
														</c:if> <c:if test="${hshd.luongThang13 == 2}">
															<spring:message code="label.khong" />
														</c:if></td>
													<td>${hshd.soNgayPhep}</td>
													<td>${hshd.ngayKy}</td>
													<td>${hshd.hopDongTuNgay}</td>
													<td>${hshd.hopDongDenNgay}</td>
													<td><c:if test="${hshd.trangThai == 1}">
															<spring:message code="label.conHopDong" />
														</c:if> <c:if test="${hshd.trangThai == 2}">
															<spring:message code="label.hetHopDong" />
														</c:if></td>
													 <td
														style="letter-spacing: 5px; min-width: 75px; text-align: center !important;">
														<a href="<c:url value = ""/>"><i class="fa fa-eye"></i></a>
														<a href="<c:url value = "/quanlynhansutt/edit/${hshd.maHopDong}"/>"><i class="fa fa-pencil"></i></a>
														<a href="<c:url value = ""/>"><i class="fa fa-trash"></i></a>
														
													</td> 
												</tr>
											</c:forEach>
											<div class="modal fade" id="confirm-delete" tabindex="-1"
												role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">

														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal"
																aria-hidden="true">&times;</button>
															<h4 class="modal-title" id="myModalLabel">Bạn có
																chắc muốn xóa</h4>
														</div>

														<div class="modal-body">
															<p>Bạn có chắc muốn xóa</p>
															<p class="debug-url"></p>
														</div>

														<div class="modal-footer">
															<button type="button" class="btn btn-default"
																data-dismiss="modal">Quay lại</button>
															<a class="btn btn-danger btn-ok">Xóa</a>
														</div>
													</div>
												</div>
											</div>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>

			<!--/ Zero configuration table -->
		</div>
	</div>
</div>
<!-- ////////////////////////////////////////////////////////////////////////////-->
	<!-- 	<script>
												window.onload = function() {
													$('#confirm-delete')
															.on(
																	'show.bs.modal',
																	function(e) {
																		$(this)
																				.find(
																						'.btn-ok')
																				.attr(
																						'href',
																						$(
																								e.relatedTarget)
																								.data(
																										'href'));
																	});
													$("#datatable").dataTable()
															.fnDestroy();
													$("#datatable")
															.dataTable(
																	{
																		responsive : true,
																		"order" : [
																				[
																						6,
																						"asc" ],
																				[
																						0,
																						"desc" ] ],
																		"bServerSide" : true,
																		"sAjaxSource" : "/ffse-fbms/quanlynhansutt/${maPhongBan}/view/getListHopDong",
																	});
												};
											</script> -->
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />