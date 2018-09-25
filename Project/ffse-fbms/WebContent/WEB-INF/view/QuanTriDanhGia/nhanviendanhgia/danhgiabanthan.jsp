<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/QuanTriDanhGia/templates/header.jsp"></jsp:include>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Đánh giá bản thân</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="<c:url value = "/quantridanhgia/home/"/>">Quản trị
									đánh giá</a></li>
							<li class="breadcrumb-item active">Đánh giá bản thân</li>
						</ol>
					</div>
				</div>
			</div>
			<c:if test="${empty tudanhgia}">
				<div class="content-header-right col-md-3 col-xs-12">
					<div role="group" aria-label="Button group with nested dropdown"
						class="btn-group float-md-right" id="add-new">
						<a
							href="<c:url value = "/quantridanhgia/nhanvien/danhgiabanthan/add"/>"
							class="btn btn-primary"><span class="fa fa-plus"></span> Tạo</a>
					</div>
				</div>
			</c:if>
			<div class="content-body">
				<!-- Basic form layout section start -->
				<section id="basic-form-layouts">
					<c:if test="${empty tudanhgia}">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="card-content">
										<div class="card-body" style="margin: 1em">
											<h2>Bạn chưa có bản đánh giá bản thân nào</h2>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty tudanhgia}">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="card-content collpase show">
										<div class="card-body" style="margin: 1em">
											<form:form cssClass="form form-horizontal form-bordered">
												<div class="form-body">
													<h4 class="form-section">
														<i class="ft-user"></i> Bản tự đánh giá
													</h4>
													<div class="form-group row">
														<label class="col-md-3 label-control">Kỷ luật công
															việc</label>
														<div class="col-md-9">
															<div class="row">
																<form:label path="kyLuatCongViec_DG"></form:label>
																<form:label path="kyLuatCongViec_MT"></form:label>
															</div>
														</div>
													</div>
													<div class="form-group row">
														<label class="col-md-3 label-control">Tinh thần
															làm việc</label>
														<div class="col-md-9">
															<form:label path="tinhThanLamViec_DG"></form:label>
															<form:label path="tinhThanLamViec_MT"></form:label>
														</div>
													</div>

													<div class="form-group row">
														<label class="col-md-3 label-control">Khối lượng
															công việc đạt được</label>
														<div class="col-md-9">
															<form:label path="khoiLuongCongViec_DG"></form:label>
															<form:label path="khoiLuongCongViec_MT"></form:label>
														</div>
													</div>

													<div class="form-group row">
														<label class="col-md-3 label-control">Kết quả công
															việc đạt được</label>
														<div class="col-md-9">
															<form:label path="ketQuaCongViec_DG"></form:label>
															<form:label path="ketQuaCongViec_MT"></form:label>
														</div>
													</div>

													<div class="form-group row">
														<label class="col-md-3 label-control">Kỹ năng tích
															lũy</label>
														<div class="col-md-9">
															<form:label path="kyNangTichLuy_DG"></form:label>
															<form:label path="kyNangTichLuy_MT"></form:label>
														</div>
													</div>

													<div class="form-group row">
														<label class="col-md-3 label-control">Định hướng</label>
														<div class="col-md-9">
															<form:label path="dinhHuong"></form:label>
														</div>
													</div>

													<div class="form-group last">
														<label class="col-md-3 label-control">Đánh giá
															tổng thể</label>
														<div class="col-md-9">
															<form:label path="danhGiaTongThe"></form:label>
														</div>
													</div>
												</div>

												<div class="form-actions">
													<a href="<c:url value="/quantridanhgia/home/"/>"
														class="btn btn-danger btn-min-width mr-1 mb-1">Trở về</a>
													<c:if test="${command.isDelete == 1 }">
														<a
															href="<c:url value="/quantridanhgia/tudanhgia/showform"/>"
															class="btn btn-success">Cập nhật</a>
													</c:if>
												</div>

											</form:form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</section>
				<!-- // Basic form layout section end -->
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>