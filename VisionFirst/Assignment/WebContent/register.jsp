<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.html"></jsp:include>
<div class="container">
<h1 class="mt-3 text-center">Registeration Form</h1><hr color="red">

${msg}
<form class="m-5" action="/Assignment/Register" method="post">
		<div class="form-group">
			<label for="name">Name</label>
			<input name="name" type="text" class="form-control">
		</div>
		
		<div class="form-group">
			<label for="email">Email</label>
			<input name="email" type="email" class="form-control">
		</div>
		
		<div class="form-group">
			<label for="mobile">Mobile</label>
			<input name="mobile" type="number" class="form-control">
		</div>
		
		<div class="form-group">
			<label for="password">Password</label>
			<input name="password" type="password" class="form-control">
		</div>
		
		<div class="form-group">
			<label for="username">Username</label>
			<input name="username" type="text" class="form-control">
		</div>
		
		<div class="form-group pb-3">
			<label for="role">Role</label>
			<select name="role" class="form-control">
				<option>IT_ADMIN</option>
				<option>IT_USER_NORMAL</option>
			</select>
		</div>
		
		<div class="form-group">
			<input class="btn btn-primary btn-block" type="submit" value="Register">
		</div>
		</form>
	</div>
	

<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>