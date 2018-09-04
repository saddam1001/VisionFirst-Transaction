<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>admin page</title>
</head>
<body>

<jsp:include page="header.html"></jsp:include>

<div class="container">

	<form action="/Assignment/Search">
	 <div class="input-group mt-5">
            <input class="form-control" type="text" name="search" placeholder="Find By UserName or CompanyName">
            <div class="input-group-append">
                <input class="btn btn-outline-secondary" type="submit" value="Search">
            </div>
     </div>
     </form>
     <h3 class="text-center my-3">Company Table</h3>
	 <table class="table">
		<thead>
			<tr>
				<th>SNo</th>
				<th>Company Name</th>
				<th>Company Address</th>
				<th>Created By</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${l}" var="l">
			<tr>
				<td>${l.sno}</td>
				<td>${l.companyName}</td>
				<td>${l.companyAddress}</td>
				<td>${l.createdBy}</td>
				<%-- <td>${l.actions}</td> --%>
				<td><a href="/Assignment/Edit?sno=${l.sno}" class="btn btn-primary">Edit</a><td>
				<td><a href="/Assignment/Delete?sno=${l.sno}" class="btn btn-danger">Delete</a><td>
				<td><a href="/Assignment/Approve?sno=${l.sno}" class="btn btn-success ${l.actions}">Approve</a><td>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
</div>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>