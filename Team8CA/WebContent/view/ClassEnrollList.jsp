<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<fmt:setBundle basename="messages" />
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

	<div id="wrapper">


		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						<fmt:message key="label.course.info" />
					</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="col-lg-2">
					<label><fmt:message key="label.course.name" /></label>
				</div>
				<div class="col-lg-2">
					<label>${param['scourse']}</label>
				</div>
				<div class="col-lg-8" style="text-align: center;"></div>

			</div>
			<div class="row">
				<div class="col-lg-2">
					<label><fmt:message key="label.course.date" /></label>
				</div>
				<div class="col-lg-2">
					<label>${param['startdate']}</label>
				</div>
				<div class="col-lg-4">
					<div class="form-group" style="text-align: right"></div>
				</div>
				<div class="col-lg-2">
					<label><fmt:message key="label.course.duration" /></label>
				</div>
				<div class="col-lg-2">
					<label>${param['endate']}</label>
				</div>
				<h2 class="page-header"></h2>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">

					<table class="table">
						<thead>
							<tr>

								<th style="width: 2%">#</th>
								<th style="width: 20%"><fmt:message key="label.student.name" /></th>
								<th style="width: 13%"><fmt:message key="label.student.dob" /></th>
								<th style="width: 15%"><fmt:message key="label.student.phnumber" /></th>
								<th style="width: 25%"><fmt:message key="label.student.address" /></th>
								<th style="width: 25%"><fmt:message key="label.student.email" /></th>


							</tr>
						</thead>
						<tbody>
							<c:forEach var="student" items="${students}" varStatus="status">
								<tr class="${status.index%2==0?'even':'odd'}">
									<td>${status.index + 1}</td>
									<td style="display: none;">${student.matricno }</td>
									<td>${student.studentname }</td>
									<td>${student.dateofbirth }</td>
									<td>${student.phone }</td>
									<td>${student.address }</td>
									<td>${student.email }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<c:set var="id" scope="session" value="${param['id']}" />
					<c:set var="scourse" scope="session" value="${param['scourse']}" />
					<c:set var="startdate" scope="session"
						value="${param['startdate']}" />
					<c:set var="endate" scope="session" value="${param['endate']}" />

					<%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>

					<ul class="pagination">
						<c:forEach begin="1" end="${noOfPages}" var="i">
							<c:choose>
								<c:when test="${currentPage eq i}">
									<li class="active"><a>${i}</a></li>
								</c:when>
								<c:otherwise>
									<li><c:url var="urln" scope="page"
											value="/classenrolllist">
											<c:param name="id" value="${id}" />
											<c:param name="page" value="${i}" />
											<c:param name="scourse" value="${scourse}" />
											<c:param name="startdate" value="${startdate}" />
											<c:param name="endate" value="${endate}" />

										</c:url> <a href="${urln}">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>



				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

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