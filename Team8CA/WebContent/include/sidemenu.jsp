<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="navbar-default sidebar" role="navigation">
	<c:choose>
		<c:when test="${profile.getRole()=='lecturer'}">

			<ul class="nav" id="side-menu">

				<li><a href="<%=request.getContextPath()%>/loadlc"><i
						class="fa fa-dashboard fa-fw"></i> Course List</a></li>

				<li><a href="#"><i class="fa fa-table fa-fw"></i>
						Course Enrollment</a></li>
				<li><a href="<%=request.getContextPath()%>/sgrading"><i
						class="fa fa-edit fa-fw"></i> Student Grading</a></li>
				<li><a href="<%=request.getContextPath()%>/view/StudentPerformance.jsp"><i class="fa fa-edit fa-fw"></i>
						Student Performance</a></li>
				<li><a href="<%=request.getContextPath()%>/logout"><i class="fa fa-edit fa-fw"></i>
						LogOut</a></li>

			</ul>

		</c:when>

		<c:when test="${profile.getRole()=='student'}">
			<ul class="nav" id="side-menu">

				<li><a href="<%=request.getContextPath()%>/loadclass"><i
						class="fa fa-dashboard fa-fw"></i> View Courses</a></li>

				<li><a href=" <%=request.getContextPath()%>/StudentEnrolment"> <i
						class="fa fa-table fa-fw"></i> View Enrolled Courses
				</a></li>
				<li><a href="<%=request.getContextPath()%>/loadgrade"><i class="fa fa-edit fa-fw"></i>
						View Course Grades</a></li>
				<li><a href="<%=request.getContextPath()%>/logout"><i
						class="fa fa-edit fa-fw"></i> LogOut</a></li>

			</ul>

		</c:when>
		<c:when test="${profile.getRole()=='administrator'}">
			<ul class="nav" id="side-menu">

				<li><a href="<%=request.getContextPath()%>/loadlec"><i
						class="fa fa-dashboard fa-fw"></i> Lecturer</a></li>

				<li><a href=" <%=request.getContextPath()%>/sload"> <i
						class="fa fa-table fa-fw"></i> Students
				</a></li>
				<li><a href="<%=request.getContextPath()%>/CourseLoad"><i class="fa fa-edit fa-fw"></i>
						Course</a></li>
				<li><a href="<%=request.getContextPath()%>/CLoad"><i class="fa fa-edit fa-fw"></i>
						Class</a></li>
				<li><a href="<%=request.getContextPath()%>/logout"><i
						class="fa fa-edit fa-fw"></i> LogOut</a></li>

			</ul>

		</c:when>
	</c:choose>
	<div class="sidebar-nav navbar-collapse"></div>
	<!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->
