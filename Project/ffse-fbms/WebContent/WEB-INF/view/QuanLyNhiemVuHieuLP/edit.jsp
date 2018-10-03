<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0"><spring:message code="label.suanhiemvu"/></h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'><spring:message code="label.trangchunhiemvu"/></a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/HieuLP/" />'><spring:message code="label.danhsachnhiemvu"/></a></li>
							<li class="breadcrumb-item active"><spring:message code="label.suanhiemvu"/></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<h4 class="content-header-title mb-0" style="margin-left: 450px"> <b><spring:message code="label.suanhiemvu"/></b></h4>
							<hr>
						<div class="content-body">
							<c:if test="${messageError ne null}">
								<div class="alert alert-danger alert-dismissable" role="alert">
									<button type="button" class="close" data-dismiss="alert">
										<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
									</button>
									<spring:message code="label.luuthatbainhiemvu"/>
								</div>
							</c:if>
							<div class="main-content">
								<div class="row">
									<c:url var="addAction" value="/HieuLP/update"></c:url>
									<form:form method="POST" modelAttribute="duAn"
										action="${addAction}">
										<form:input type="hidden" path="iD" style="display:none" />
										<div class="form-group col-sm-6">
											<label><spring:message code="label.duannhiemvu"/></label>
											<form:hidden path="duAn.maDuan" />
											<form:input class="form-control block "
												path="duAn.tenDuan" readonly="true" />
										</div>
										<div class="form-group col-sm-6">
											<label><spring:message code="label.tencongviec"/></label>
											<form:input class="form-control block "
												path="tenCongviec" />
										</div>
										<div class="form-group col-sm-6">
											<label><spring:message code="label.loaicongviecnhiemvu"/></label>
											<form:select path="idLoaiCongviec.IDcongviec"
												class="custom-select block " id="customSelect">
												<c:forEach items="${congviec}" var="ld">
													<form:option value="${ld.IDcongviec}"
														label="${ld.loaiCongviec}" />
												</c:forEach>
											</form:select>
										</div>
										<div class="form-group col-sm-6">
											<label><spring:message code="label.trangthainhiemvu"/></label>
											<form:select path="idLoaiTrangthai.IDtrangthai"
												class="custom-select block " id="customSelect">
												<c:forEach items="${trangthai}" var="ld">
													<form:option value="${ld.IDtrangthai}"
														label="${ld.loaiTrangthai}" />
												</c:forEach>
											</form:select>
										</div>
										<div class="form-group col-sm-3">
											<label><spring:message code="label.tgbatdau"/></label>
											<form:input path="tgBatdau" type="date" id="issueinput3"
												class="form-control block " />
										</div>
										<div class="form-group col-sm-3">
											<label><spring:message code="label.tgketthuc"/></label>
											<form:input path="tgKetthuc" type="date" id="issueinput3"
												class="form-control block " />
										</div>
										<div class="form-group col-sm-6">
											<label><spring:message code="label.nguoiduocphancong"/></label>
											<form:hidden path="nhanVien.maNhanVien" />
											<form:input class="form-control block "
												path="nhanVien.ten"
												value="${duAn.nhanVien.hoDem} ${duAn.nhanVien.ten}"
												readonly="true" />
										</div>
										<div class="form-group col-sm-12">
											<label><spring:message code="label.motanhiemvu"/></label>
											<form:textarea path="moTa" id="issueinput8" rows="5"
												class="form-control" placeholder="Mô tả" />
										</div>


										<div class="form-group col-sm-3">
											<label><spring:message code="label.tgdukienhoanthanh"/></label>
											<div class="input-group">
												<form:input class="form-control block "
													path="tgDukienhoanthanh"
													placeholder="Thời gian dự kiến hoàn thành	"
													style="width:240px;"></form:input>
												<span class="input-group-addon"><spring:message code="label.gionhiemvu"/></span>
											</div>

										</div>

										<div class="col-sm-12 text-center">
											<button type="submit" class="btn btn-success"><spring:message code="label.luunhiemvu"/></button>
										</div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
window.setTimeout(function() {
	$(".alert").fadeTo(500, 0).slideUp(500, function() {
		$(this).remove();
	});	
}, 2500);
</script>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
