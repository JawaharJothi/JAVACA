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

<title>Team-8 Course Application Processing System</title>
<%-- <fmt:setBundle basename="messages"/> --%>
<!-- Bootstrap Core CSS -->
<link href="../style/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="../style/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../style/custom/css/style.css" rel="stylesheet">



</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">Team 8</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">


			<li><a class="dropdown-toggle" data-toggle="dropdown" href="#">
					Home </a></li>
			<li><a class="dropdown-toggle" data-toggle="dropdown" href="#">
					Contact Us </a></li>
			<li><a class="dropdown-toggle" data-toggle="dropdown" href="#">
					About Us </a></li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">

					<li><a href="index.html"><i class="fa fa-dashboard fa-fw"></i>
							Lecturer</a></li>

					<li><a href="tables.html"><i class="fa fa-table fa-fw"></i>
							Student</a></li>
					<li><a href="forms.html"><i class="fa fa-edit fa-fw"></i>
							Course</a></li>
					<li><a href="forms.html"><i class="fa fa-edit fa-fw"></i>
							Class</a></li>
					<li><a href="forms.html"><i class="fa fa-edit fa-fw"></i>
							LogOut</a></li>

				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Student</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-1">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<%-- <th><fmt:message key="label.student.name"/></th>
								<th><fmt:message key="label.student.dob"/></th>
								<th><fmt:message key="label.student.phnumber"/></th>
								<th><fmt:message key="label.student.address"/></th>
								<th><fmt:message key="label.student.email"/></th>
								<th><fmt:message key="label.student.edit"/></th>
								<th><fmt:message key="label.student.delete"/></th> --%>
								
							</tr>
						</thead>
						<tbody>
							
						</tbody>
					</table>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="../style/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../style/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="../style/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../style/custom/js/sb-admin-2.js"></script>

</body>

</html>