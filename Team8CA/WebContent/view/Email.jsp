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
	<form action="/team8/EmailSendingServlet" method="post">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Send New Email</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="form-group">
						<label>Recipient Address</label> <input type="text"
							name="recipient" size="50" class="form-control"  value="${param['email']}"/>
					</div>
					<div class="form-group">
						<label>Subject</label> <input type="text" name="subject" size="50"
							class="form-control" value="Welcome to NUS-ISS"/>
					</div>
					<div class="form-group">
						<label>Content</label>
						<textarea rows="10" cols="39" name="content" class="form-control">
						Hey ${param['name']}
						We're so excited to welcome you to NUS-ISS.
						Your Account Information: 
						UserName - ${param['id']}
						Password -  ${param['password']}
						</textarea>
					</div>
					<div class="form-group">
						<input class="btn btn-primary" type="submit" value="Send" />
					</div>
				</div>
			</div>
		</div>

	</form>



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