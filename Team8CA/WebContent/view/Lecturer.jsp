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
					<fmt:message key="label.lecturer" />
				</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<c:url var="url" scope="page" value="/view/LecturerSetup.jsp">
					<c:param name="id" value="" />
					<c:param name="name" value="" />
					<c:param name="dob" value="" />
					<c:param name="phnumber" value="" />
					<c:param name="address" value="" />
					<c:param name="email" value="" />
					<c:param name="edu" value=""></c:param>
					<c:param name="password" value=""></c:param>
					<c:param name="insert" value="true" />
				</c:url>
				<a href="${url}"><fmt:message key="label.lecturer.add" /></a>

				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th><fmt:message key="label.lecturer.name" /></th>
							<th><fmt:message key="label.lecturer.dob" /></th>
							<th><fmt:message key="label.lecturer.phnumber" /></th>
							<th><fmt:message key="label.lecturer.address" /></th>
							<th><fmt:message key="label.lecturer.email" /></th>
							<th><fmt:message key="label.lecturer.edu" /></th>
							<th><fmt:message key="label.lecturer.edit" /></th>
							<th><fmt:message key="label.lecturer.delete" /></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="lecturer" items="${lecturers}" varStatus="status">
							<tr class="${status.index%2==0?'even':'odd'}">
								<td>${status.index + 1}</td>
								<td style="display: none;">${lecturer.lecturerID }</td>
								<td>${lecturer.lecturername }</td>
								<td>${lecturer.dob }</td>
								<td>${lecturer.phone }</td>
								<td>${lecturer.lectureraddress }</td>
								<td>${lecturer.email }</td>
								<td>${lecturer.degree }</td>
								<td><c:url var="updurl" scope="page"
										value="/view/LecturerSetup.jsp">
										<c:param name="id" value="${lecturer.lecturerID  }" />
										<c:param name="name" value="${lecturer.lecturername }" />
										<c:param name="dob" value="${lecturer.dob }" />
										<c:param name="phnumber" value="${lecturer.phone }" />
										<c:param name="address" value="${lecturer.lectureraddress }" />
										<c:param name="email" value="${lecturer.email }" />
										<c:param name="edu" value="${lecturer.degree }" />
										<c:param name="password" value="${lecturer.password }" />
										<c:param name="update" value="true" />
									</c:url> <a href="${updurl}"><fmt:message key="label.lecturer.edit" /></a>
								</td>
								<td><c:url var="delurl" scope="page"
										value="/lecturerdelete">
										<c:param name="id" value="${lecturer.lecturerID }" />
									</c:url> <a href="${delurl}"><fmt:message
											key="label.lecturer.delete" /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /#page-wrapper -->



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