<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
					<h1 class="page-header">Student</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
				<c:url var="url" scope="page" value="/view/StudentSetup.jsp">
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
			<a href="${url}" ><fmt:message key="label.student.add" /></a> 
			
			
					<table class="table">
						<thead>
							<tr>
							
								<th>#</th>
								<th><fmt:message key="label.student.name"/></th>
								<th><fmt:message key="label.student.dob"/></th>
								<th><fmt:message key="label.student.phnumber"/></th>
								<th><fmt:message key="label.student.address"/></th>
								<th><fmt:message key="label.student.email"/></th>
							
								<th><fmt:message key="label.student.status"/></th>
								<th><fmt:message key="label.student.edit"/></th>
								<th><fmt:message key="label.student.delete"/></th>
								
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
								
								<td>${student.status}</td>
								<td><c:url var="updurl" scope="page"
										value="/view/StudentSetup.jsp">
										<c:param name="id" value="${student.matricno }" />
										<c:param name="name" value="${student.studentname}" />
										<c:param name="dob" value="${student.dateofbirth}" />
										<c:param name="phnumber" value="${student.phone }" />
										<c:param name="address" value="${student.address }" />
										<c:param name="email" value="${student.email}" />
										<c:param name="edu" value="${student.image }" />
										<c:param name="edu" value="${student.status }" />
										<c:param name="password" value="${student.password }" />
										<c:param name="update" value="true" />
									</c:url> <a href="${updurl}"><fmt:message key="label.student.edit" /></a>
								</td>
								<td><c:url var="delurl" scope="page"
										value="/DeleteStudent">
										<c:param name="matricnumber" value="${student.matricno}" />
									</c:url> <a href="${delurl}"><fmt:message
											key="label.student.delete" /></a></td>
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