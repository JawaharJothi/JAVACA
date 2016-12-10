<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<fmt:setBundle basename="messages" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="title" /></title>
<!-- Bootstrap Core CSS -->
<link href="<c:url value='/style/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet" />

<!-- MetisMenu CSS -->
<link href="<c:url value='/style/metisMenu/metisMenu.min.css'/>"
	rel="stylesheet" />

<!-- Custom CSS -->
<link href="<c:url value='/style/custom/css/style.css'/>"
	rel="stylesheet" />
</head>
<body>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					<fmt:message key="label.performance" />
				</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<form action="/team8/sperformance" method="post">
			<div class="row">
				<div class="col-lg-4" style="text-align: right">
					<label><fmt:message key="label.grading.id" /></label>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<input name="id" class="form-control" type="text" value=""
							maxlength="11" required>
					</div>
				</div>
				<div class="col-lg-4"></div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="col-lg-4" style="text-align: right">
					<label></label>
				</div>
				<div class="col-lg-4">
					<div class="form-group" style="text-align: right">
						<input type="submit" class="btn btn-primary" value="Search">
					</div>
				</div>
				<div class="col-lg-4"></div>
				<!-- /.col-lg-12 -->
			</div>
		</form>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th><fmt:message key="label.performance.name"/></th>
							<th><fmt:message key="label.performance.course" /></th>
							<th><fmt:message key="label.performance.sdate" /></th>
							<th><fmt:message key="label.performance.edate" /></th>
							<th><fmt:message key="label.performance.grade" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="slist" items="${splist}" varStatus="status">
							<tr class="${status.index%2==0?'even':'odd'}">
								<td>${status.index + 1}</td>
								<td>${slist.studentname }</td>
								<td>${slist.courseName }</td>
								<td>${slist.startDate }</td>
								<td>${slist.endDate }</td>
								<td>${slist.grade }</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	</div>

	<!-- jQuery -->
	<script src="<c:url value='/style/jquery/jquery.min.js'/>"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value='/style/bootstrap/js/bootstrap.min.js'/>"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="<c:url value='/style/metisMenu/metisMenu.min.js'/>"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<c:url value='/style/custom/js/sb-admin-2.js'/>"></script>
</body>
</html>