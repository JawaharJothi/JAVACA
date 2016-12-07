<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<fmt:setBundle basename="messages" />
<c:set var="t" value="true" />
<title> <fmt:message key="title" /> </title>
</head>
<body>
	
	<form action="/team8/studentprocess" method="post">
		
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						<fmt:message key="label.student" />
					</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<fmt:message key="label.student.info" />
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-6">
									<div class="form-group">
										<label><fmt:message key="setup.matric" /></label>
										<c:if test="${param['insert']==t}">
											<input class="form-control" type="text" name="id" value="${param['id']}"
												size=15 maxlength=10>
											<input type="hidden" name="ins" value="true" />
										</c:if>
										<c:if test="${param['update']==t}">
											<input  class="form-control" type="text" name="id" value="${param['id']}"
												size=15 maxlength=20 readonly="readonly">
											<input type="hidden" name="ins" value="false" />
										</c:if>
										
									</div>
									<div class="form-group">
										<label><fmt:message key="setup.sname" /></label> <input name="name"
											class="form-control" type="text" value="${param['name']}" maxlength="150">
									</div>
									<div class="form-group">
										<label><fmt:message key="setup.sdob" /></label> <input name="dob"
											class="form-control" type="text" placeholder="yyyy-MM-dd"
											value="${param['dob']}">
									</div>
									<div class="form-group">
										<label><fmt:message key="setup.sph" /></label> <input name="phone"
											class="form-control" type="text" value="${param['phnumber']}" maxlength="11">
									</div>
									<div class="form-group">
										<label><fmt:message key="setup.saddress" /></label>
										<textarea name="address" class="form-control" rows="3" >${param['address']}</textarea>
									</div>
									<div class="form-group">
										<label><fmt:message key="setup.semail" /></label> <input name="email"
											class="form-control" type="text" value="${param['email']}" maxlength="45">
									</div>
									<div class="form-group">
										<label><fmt:message key="setup.sstatus" /></label> <input name="status"
											class="form-control" type="text" value="${param['status']}" maxlength="200">
									</div>
									<div class="form-group">
										<label>Password</label> <input class="form-control" name="password"
											type="password" value="" maxlength="45">
									</div>
									<div class="form-group">
										<label>Confirm Password</label> <input class="form-control" name="repassword"
											type="password" value="" maxlength="45">
									</div>
									<button type="submit" class="btn btn-default">Submit
									</button>


								</div>

							</div>
							<!-- /.row (nested) -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		
		
	</form>
	
	
</body>
</html>