<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><decorator:title/></title>
<decorator:head />
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
 <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
<%@ include file="/include/header.jsp" %>
<%@ include file="/include/sidemenulecturer.jsp"%>
</nav>

<decorator:body />
</div>
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