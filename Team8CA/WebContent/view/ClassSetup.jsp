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
<title><fmt:message key="title" /></title>

<!-- Bootstrap Core CSS -->

</head>
<body>
	<form action="/team8/classprocess" method="post">

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
					<div class="panel panel-default">
						<div class="panel-heading">
							<fmt:message key="label.class.info" />
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-6">
									<div class="form-group">
										<label><fmt:message key="setup.classid" /></label>
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
										<label><fmt:message key="setup.size" /></label> <input name="size"
											class="form-control" type="text" value="${param['size']}" maxlength="150">
									</div>
									<div class="form-group">
										<label><fmt:message key="setup.startdate" /></label> 
											<input type="date" class="form-control" value="${param['sdate']}" name="sdate">
									</div>
									<div class="form-group">
										<label><fmt:message key="setup.enddate" /></label> 
											<input type="date" class="form-control" name="edate" value="${param['edate']}">
									</div>
									<div class="form-group">
										<label><fmt:message key="setup.credit" /></label> <input name="credit"
											class="form-control" type="text" value="${param['credit']}" maxlength="11">
									</div>
									<div class="form-group">
									<label><fmt:message key="setup.course" /></label>
										<select class="form-control" id="cbClassID" name="cbClassID">
										
						<option name="cname" value=""> Select Course</option> 
						<c:forEach var="course" items="${courses}" varStatus="status">
							<option value="${course.courseName }" ${course.courseName == param['course'] ? 'selected="selected"' : ''}>${course.courseName } </option>
						</c:forEach>
					</select>
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