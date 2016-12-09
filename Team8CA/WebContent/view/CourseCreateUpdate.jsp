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
	<form action="/team8/CourseCreate" method="post">

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
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<fmt:message key="label.course.info" />
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-6">

									<!-- "Course Name" textbox -->
									<div class="form-group">
										<label><fmt:message key="label.course.name" /></label>
										<c:if test="${param['insert']==true}">
											<input class="form-control" type="text" name="courseName"
												value="${param['courseName']}" size=15 maxlength=100>
											<input type="hidden" name="ins" value="true" />
										</c:if>
										<c:if test="${param['update']==true}">
											<input class="form-control" type="text" name="courseName"
												value="${param['courseName']}" size=15 maxlength=100
												readonly="readonly">
											<input type="hidden" name="ins" value="true" />
										</c:if>
									</div>

									<!-- "Type of Course" textbox -->
									<div class="form-group">
										<label><fmt:message key="label.course.type" /></label> <input
											name="typeOfCourse" class="form-control" type="text"
											value="${param['typeOfCourse']}" maxlength="45">
									</div>

									<!-- "Lecturer ID" textbox -->
									<!-- 	<div class="form-group">
										<label><fmt:message key="label.course.lecturer" /></label> <input
											name="lecturerID" class="form-control" type="text"
											value="${param['lecturerID']}" maxlength="10">
									</div> -->
									<div class="form-group">
									<label><fmt:message key="label.course.lecturer" /></label>
										<select name="lecturerID" class="form-control">
										<option value=""></option>
											<c:forEach var="lecturer" items="${lecturerList}">
												<option value="${lecturer.lecturerID}" ${lecturer.lecturerID == param['id'] ? 'selected="selected"' : ''}>${lecturer.lecturername}</option>
											</c:forEach>
										</select>
									</div>

									<!-- "Submit" button -->
									<button type="submit" class="btn btn-default">Submit</button>


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