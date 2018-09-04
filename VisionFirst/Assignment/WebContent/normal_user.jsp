<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<title>normal_user page</title>
</head>
<body>
<jsp:include page="header.html"></jsp:include>

<div class="container">
<h3>Your Company</h3>
	<table class="table mt-3">
		<thead>
			<tr>
				<th>SNo</th>
				<th>Company Name</th>
				<th>Company Address</th>
				<!-- <th>Created By</th> -->
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${l}" var="l">
			<tr>
				<td>${l.sno}</td>
				<td>${l.companyName}</td>
				<td>${l.companyAddress}</td>
				<%-- <td>${l.createdBy}</td> --%>
				<td>${l.actions}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
</div>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>