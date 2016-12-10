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
					<fmt:message key="label.class" />
				</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<c:url var="url" scope="page" value="/view/ClassSetup.jsp">
					<c:param name="id" value="" />
					<c:param name="size" value="" />
					<c:param name="sdate" value="" />
					<c:param name="edate" value="" />
					<c:param name="credit" value="" />
					<c:param name="course" value="" />
					<c:param name="insert" value="true" />
				</c:url>
				<a href="${url}" class="btn btn-primary"><fmt:message key="label.class.add" /></a>

				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th><fmt:message key="label.class.size" /></th>
							<th><fmt:message key="label.class.sdate" /></th>
							<th><fmt:message key="label.class.edate" /></th>
							<th><fmt:message key="label.class.credit" /></th>
							<th><fmt:message key="label.class.course" /></th>
							<th><fmt:message key="label.course.edit" /></th>
							<th><fmt:message key="label.course.delete" /></th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="_class" items="${classes}" varStatus="status">
							<tr class="${status.index%2==0?'even':'odd'}">
								<td>${status.index + 1}</td>
								<td style="display: none;">${_class.classID }</td>
								<td>${_class.classSize }</td>
								<td>${_class.startDate }</td>
								<td>${_class.endDate }</td>
								<td>${_class.credit }</td>
								<td>${_class.courseName }</td>
									<td><c:url var="updurc" scope="page"
										value="/view/ClassSetup.jsp">
										<c:param name="id" value="${_class.classID }" />
										<c:param name="size" value="${_class.classSize }" />
										<c:param name="sdate" value="${_class.startDate }" />
										<c:param name="edate" value="${_class.endDate }" />
										<c:param name="credit" value="${_class.credit }" />
										<c:param name="course" value="${_class.courseName }" />
										<c:param name="update" value="true"></c:param>
										
									</c:url> <a href="${updurc}" class="btn btn-primary"><fmt:message key="label.class.edit" /></a>
								</td>
								<td><c:url var="delurc" scope="page"
										value="/cdelete">
										<c:param name="id" value="${_class.classID }" />
									</c:url> <a href="${delurc}" class="btn btn-primary"><fmt:message
											key="label.class.delete" /></a></td>
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