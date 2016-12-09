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
<script type="text/javascript">
	function check(v1, v2) {
		document.getElementById(v2).disabled = true;
		//if(document.getElementById(v1).value == "wer")
		window.alert(v1);
	}
</script>
<body>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					<fmt:message key="label.classes" />
					<!-- <fmt:message key="label.lecturer" /> -->

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
							<th><fmt:message key="label.classes.classid" /></th>
							<th><fmt:message key="label.classes.coursename" /></th>
							<th><fmt:message key="label.classes.credit" /></th>
							<th><fmt:message key="label.classes.startdate" /></th>
							<th><fmt:message key="label.classes.enddate" /></th>
							<th><fmt:message key="label.classes.classsize" /></th>
							<th><fmt:message key="label.classes.numberenrolled" /></th>
							<th><fmt:message key="label.classes.enrollment"></fmt:message>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="classz" items="${classList}" varStatus="status">

							<tr class="${status.index%2==0?'even':'odd'}">
								<td>${status.index + 1}</td>
								<td>${classz.classID}</td>
								<td>${classz.courseName}</td>
								<td>${classz.credit}</td>
								<td>${classz.startDate}</td>
								<td>${classz.endDate}</td>
								<td>${classz.classSize}</td>
								<td>${classz.numberEnrolled}</td>
								<td><a
									href="StudentEnrolment?id=${classz.classID}&courseName=${classz.courseName}&credit=${classz.credit}&startDate=${classz.startDate}&endDate=${classz.endDate}&classSize=${classz.classSize}&numberEnrolled=${classz.numberEnrolled}">enroll</a></td>
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