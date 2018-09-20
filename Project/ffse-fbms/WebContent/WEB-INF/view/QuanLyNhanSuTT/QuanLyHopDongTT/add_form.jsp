<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới hợp đồng</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/quanlynhansutt/" />'>Danh sách hợp đồng</a></li>
							<li class="breadcrumb-item active">Thêm mới hợp đồng</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->
		<div class="content-body">
			<!-- Basic Elements start -->
			<section id="horizontal-form-layouts">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title" id="horz-layout-basic">Thông Tin
									Chính</h4>
								<a class="heading-elements-toggle"><i
									class="fa fa-ellipsis-v font-medium-3"></i></a>
								<div class="heading-elements">
									<ul class="list-inline mb-0">
										<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
										<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
										<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
										<li><a data-action="close"><i class="ft-x"></i></a></li>
									</ul>
								</div>
							</div>
							<div class="card-body collapse in">
								<div class="card-block">
									<form:form method="POST" action="save"
										modelAttribute="hopDongTT">
										<div class="form-body">
											<div class="row">
												<div class="col-md-8">
													<div class="row">
														<div class="form-group col-sm-6">
															<label>Mã Hợp Đồng</label>
															<form:input class="form-control" path="maHopDong"
																placeholder="Mã Hợp Đồng" />
														</div>
														<div class="form-group col-sm-6">
															<label>Mã Nhân Viên</label>
															<form:input class="form-control" path="hoSoNhanVienTT"
																placeholder="Mã Nhân Viên" />
														</div>
													</div>
													<div class="row">
														<div class="form-group col-sm-6">
															<label>Mã Loại Hợp Đồng</label>
															<form:select path="loaiHopDong" type="text"
																id="companyName" class="form-control"
																name="loaiHopDongSelect">
																<option value="none">Chọn Loại Hợp Đồng</option>
																<c:forEach items="${listLoaiHopDong}" var="x">
																	<option value="${x.maLoaiHopDong}">${x.tenHopDong}</option>
																</c:forEach>
															</form:select>
															<form:errors path="" cssClass="invalid-feedback d-block" />
														</div>
														<div class="form-group col-sm-6">
															<label>Mã Chức Danh</label>
															<form:select path="chucDanh.maChucDanh" type="text"
																id="companyName" class="form-control"
																name="chucDanhSelect">
																<option value="none">Chọn Mã Chức Danh</option>
																<c:forEach items="${listChucDanh}" var="x">
																	<option value="${x.maChucDanh}">${x.maChucDanh}</option>
																</c:forEach>
															</form:select>
															<form:errors path="chucDanh.maChucDanh"
																cssClass="invalid-feedback d-block" />
														</div>
													</div>
												</div>
											</div>
											<h4 class="form-section">
												<i class="ft-user"> Thông Tin Hợp Đồng</i>
											</h4>
											<div class="row">
												<div class="col-md-8">
													<div class="row">
														<div class="form-group col-sm-6">
															<div class="form-group">
																<label>Lương Tháng 13</label>
																<form:select class="custom-select form-control"
																	path="luongThang13">
																	<option value="none">Chọn</option>
																	<form:option value="1">Có</form:option>
																	<form:option value="2">Không</form:option>
																</form:select>
															</div>
														</div>
														<div class="form-group col-sm-6">
															<label>Số Ngày Phép</label>
															<form:input class="form-control" path="soNgayPhep"
																placeholder="Số Ngày Phép" />
															<form:errors path="soNgayPhep"
																cssClass="invalid-feedback d-block" />
														</div>

													</div>
													<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<label for="date1">Ngày Ký</label>
																<fieldset class="form-group position-relative">
																	<form:input placeholder="Ngày Ký" type="date"
																		class="form-control round" id="date1" path="ngayKy" />
																	<div class="form-control-position">
																		<i class="fa fa-calendar-o"></i>
																	</div>
																	<form:errors path="ngayKy"
																		cssClass="invalid-feedback d-block" />
																</fieldset>

															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label for="date1">Hợp Đồng Từ Ngày</label>
																<fieldset class="form-group position-relative">
																	<form:input placeholder="Hợp Đồng Từ Ngày" type="date"
																		class="form-control round" id="date1"
																		path="hopDongTuNgay" />
																	<div class="form-control-position">
																		<i class="fa fa-calendar-o"></i>
																	</div>
																	<form:errors path="hopDongTuNgay"
																		cssClass="invalid-feedback d-block" />
																</fieldset>

															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label for="date1">Hợp Đồng Đến Ngày</label>
																<fieldset class="form-group position-relative">
																	<form:input placeholder="Hợp Đồng Đến Ngày" type="date"
																		class="form-control round" id="date1"
																		path="hopDongDenNgay" />
																	<div class="form-control-position">
																		<i class="fa fa-calendar-o"></i>
																	</div>
																	<form:errors path="hopDongDenNgay"
																		cssClass="invalid-feedback d-block" />
																</fieldset>

															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label for="location1">Trạng Thái</label>
																<form:select class="custom-select form-control"
																	path="trangThai">
																	<form:option value="1">Còn
																		Hợp Đồng</form:option>
																	<form:option value="2">Hết
																		Hợp Đồng</form:option>
																</form:select>
																<form:errors path="trangThai"
																	cssClass="invalid-feedback d-block" />
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="form-actions center">
											<input class="btn btn-success" type="submit" value="Save" />
											<a href="<c:url value = "/quanlynhansutt/add"/>"
												class="btn btn-primary">Back</a>
										</div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>


	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />