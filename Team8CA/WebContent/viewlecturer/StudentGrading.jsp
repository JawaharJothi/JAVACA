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
					<fmt:message key="label.course" />
				</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-3">
				<label>Select Class Name:</label>
				<form action="/team8/showgradingstudent" method="post" >
					<select class="form-control" id="cbClassID" name="cbClassID" onchange="this.form.submit()">
						<option>Select Course For Grading</option>
						<c:forEach var="course" items="${courses}" varStatus="status">
							<option value="${course.classID }" ${course.classID == cid ? 'selected="selected"' : ''}>${course.courseName }</option>
						</c:forEach>
					</select>

				</form>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<form action="/team8/updategrade" method="post">
		<div class="col-lg-12">
			<table class="table" id="studentgrade">
				<thead>
					<tr>
						<th>#</th>
						<th><fmt:message key="label.grading.id" /></th>
						<th><fmt:message key="label.grading.name" /></th>
						<th><fmt:message key="label.grading.course" /></th>
						<th><fmt:message key="label.grading.sdate" /></th>
						<th><fmt:message key="label.grading.edate" /></th>
						<th><fmt:message key="label.grading.grade" /></th>
						
					</tr>
				</thead>
				<c:forEach var="slist" items="${slists}" varStatus="status">
					<tr class="${status.index%2==0?'even':'odd'}">
						<td>${status.index + 1}</td>
						<td class="studentID">${slist.matricNumber }</td>
						<td>${slist.studentName }</td>
						<td>${slist.courseName }</td>
						<td>${slist.startDate }</td>
						<td>${slist.endDate }</td>
						<td><input class="form-control" type=text name="" value="${slist.grade }"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		</form>
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