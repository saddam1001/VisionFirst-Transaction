<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<style type="text/css">
a.approved {
	visibility : hidden;
}
</style>
<title>add company</title>
</head>
<body>
<div class="container">
	<jsp:include page="header.html"></jsp:include>
	
	<form action="/Assignment/AddCompany" method="post">
		<div class="form-header">
			<h2>Fill form to Add Company</h2><hr>
		</div>
		<div class="form-group">
			<label>Company Name</label>
			<input class="form-control" type="text" name="companyName">
		</div>
		<div class="form-group">
			<label>Company Address</label>
			<input class="form-control" type="text" name="companyAddress">
		</div>
		<div class="form-group">
			<!-- <label>Created By</label> -->
			<input class="form-control" type="hidden" name="createdBy" value="${sessionScope.username}" readonly="readonly">
		</div>
		<div>
			<input class="btn btn-success" type="submit" value="Add">
			<a href="/Assignment/${sessionScope.role}.jsp" class="btn btn-danger float-right">Cancel</a>
		</div>	
	</form>
</div>

<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>