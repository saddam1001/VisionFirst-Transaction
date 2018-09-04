<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<title>edit details</title>
</head>
<body>
<h1 class="text-center">Edit Company</h1><hr>
<div class="container">
<form class="form-group" action="/Assignment/Edit" method="post">
	
	<div class="form-header"><h2>Enter Details</h2></div>
	
	<c:forEach items="${l}" var="l">
	<div>
	<input class="form-control" type="hidden" name="sno"  value="${l.sno}">
	</div>
	<div>
	<label>Company Name</label><input class="form-control" type="text" name="companyName" value="${l.companyName}">
	</div>
	<div>
	<label>Company Address</label><input class="form-control" type="text" name="companyAddress" value="${l.companyAddress}">
	</div>
	<div>
	<label>Created By</label><input class="form-control" type="text" name="createdBy" value="${l.createdBy}" readonly="readonly">
	</div>
	<div>
	<label>Actions</label><input class="form-control" type="text" name="actions" value="${l.actions}" readonly="readonly">
	</div>
	</c:forEach>
	<div>
	<input class="btn btn-success mt-3" type="submit" value="Save">
	<a href="/Assignment/adminpage.jsp" class="btn btn-warning mt-3 float-right">Cancel</a>
	</div>

	
</form>
</div>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>