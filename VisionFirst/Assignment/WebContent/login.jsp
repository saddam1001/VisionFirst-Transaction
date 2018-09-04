<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	%>
<jsp:include page="header.html"></jsp:include>
	
<div class="container">
<h1 class="mt-3 text-center">Login Here</h1><hr>
${msg}

<form class="m-5" action="/Assignment/Login" method="post">
		
		<div class="form-group">
			<label for="username">Username</label>
			<input name="username" type="text" class="form-control">
		</div>
		
		<div class="form-group">
			<label for="password">Password</label>
			<input name="password" type="password" class="form-control">
		</div>

		<div class="form-group"><input class="btn btn-success btn-block" type="submit" value="Login"></div>
		</form>
	</div>
	

<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>