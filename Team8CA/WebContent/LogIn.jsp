<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link href="./style/style.css" rel="stylesheet">
<title>Insert title here</title>

</head>
<body>

	<nav class="navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<a class="navbar-brand" href="#">Team 8</a>

		</div>
		<div class="collapse navbar-collapse" id="myNavbar">

			<ul class="nav navbar-nav navbar-right">


				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">

					<form action="/team8/Authentiation" method="post"
						class="navbar-form navbar-right">

						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="username"
								type="text" class="form-control" name="username" value=""
								placeholder="User Name" required>
						</div>

						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="password"
								type="password" class="form-control" name="password" value=""
								placeholder="Password" required>
						</div>

						<button type="submit" class="btn btn-primary">Login</button>
					</form>

				</div>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container">
		<section class="banner"> </section>
	</div>

	<div class="container1">
		<div class="row">
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">JAVA Advanced Course</div>
					<div class="panel-body">
						<img src="./img/java.jpg"
							class="img-responsive" style="width: 100%" alt="Image">
					</div>
					<div class="panel-footer">Step by step to learn how to build your own apps with Java...</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">C#.net Advanced Course</div>
					<div class="panel-body">
						<img src="./img/csharp.jpg"
							class="img-responsive" style="width: 100%" alt="Image">
					</div>
					<div class="panel-footer">Learn how you can make your code powerful by using C#...</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">HTML/CSS Course</div>
					<div class="panel-body">
						<img src="./img/html.jpg"
							class="img-responsive" style="width: 100%" alt="Image">
					</div>
					<div class="panel-footer">Learn Web Development and Become a Web Developer...</div>
				</div>
			</div>
		</div>
	</div>
	
	<footer class="container-fluid text-center">
  <p>© Institute of Systems Science, SA-43, Team-8. All Rights Reserved.</p>
</footer>
</body>
</html>