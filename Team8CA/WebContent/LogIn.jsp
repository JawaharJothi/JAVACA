<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/team8/Authentiation" method="post">
	<table > 
		<tr>
			<td width="35%">User Name:</td>
			<td><input type="text" name="username" size=25 maxlength=30>
			</td>
		</tr>
		<tr>
			<td width="35%">User Password:</td>
			<td><input type="text" name="password" size=25 maxlength=30>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="SUBMIT">
			</td>
		</tr>

	</table>
</form>
</body>
</html>