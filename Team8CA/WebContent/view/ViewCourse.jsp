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
					<fmt:message key="label.course.info" />
				</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th><fmt:message key="label.course.name" /></th>
							<th><fmt:message key="label.course.date" /></th>
							<th><fmt:message key="label.course.duration" /></th>
							<th><fmt:message key="label.course.size" /></th>
							<th><fmt:message key="label.course.type" /></th>
							<th><fmt:message key="label.course.view" /></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="course" items="${courses}" varStatus="status">
							<tr class="${status.index%2==0?'even':'odd'}">
								<td>${status.index + 1}</td>
								<td>${course.courseName }</td>
								<td>${course.startDate }</td>
								<td>${course.endDate }</td>
								<td>${course.classSize }</td>
								<td>${course.typeOfCourse }</td>
								<td><c:url var="updurl" scope="page"
										value="/classenrolllist">
										<c:param name="id" value="${course.classID }" />
										<c:param name="scourse" value="${course.courseName }" />
										<c:param name="startdate" value="${course.startDate }" />
										<c:param name="endate" value="${course.endDate }" />

									</c:url> <a href="${updurl}" class="btn btn-primary"><fmt:message
											key="label.course.detail" /></a></td>

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