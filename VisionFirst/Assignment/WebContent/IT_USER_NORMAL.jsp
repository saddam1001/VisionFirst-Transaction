<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<title>normal_user page</title>
</head>
<body>

<div class="container">
	
	<div class="header">
		<h2>User Page</h2><hr>
	</div>
	${msg}
	<div>
		<a href="/Assignment/ViewUserCompany" class="btn btn-outline-success my-3">View My Company</a>
	</div>
	<div>
			<div>
		<button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#addcompany">Add Company</button>
		
		<div class="modal" id="addcompany">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Add Company</h5>
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
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
								<button type="button" class="btn btn-secondary float-right" data-dismiss="modal">Close</button>
							</div>	
						</form>
					</div>
				</div>
			</div>
		</div>
	
		
	</div>
	</div>
	<div>
	<form action="/Assignment/LogoutServlet" method="post">
		<input type="submit" class="btn btn-outline-danger my-3" value="Logout">
	</form>
	</div>
</div>


<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>