<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<div class="content-body">
			<div class="main-content">

				<form:form method="POST"  modelAttribute="createDate">
					<div class="row">
							<div>
								<label> <spring:message code="label.maNhanVien"/></label>
								<form:select multiple="single" path="maNhanVien" class="custom-select block round">
									<form:options items="${hoso}" itemValue="maNhanVien" itemLabel="maNhanVien" />
								</form:select>
							</div>

							<div>
								<label><spring:message code="label.songaydanghi"/></label>
								<form:input class="form-control round" path="soNgayDaNghi" />
							</div>
								
							<div>
								<label><spring:message code="label.songayconlai"/></label>
								<form:input class="form-control round" path="soNgayConLai"  />
							</div>
						<br>
						<div >
								<button type="submit"  class="btn btn-outline-danger round  mr-1 mb-1"
									formaction="<%=request.getContextPath()%>/Quanlyvangnghi1703004/createDate/submit"><spring:message code="label.gui"/></button>
							</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>
</div>


<jsp:include page="/WEB-INF/view/templates/footer.jsp" />