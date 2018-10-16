<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>List customers</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript">
	function confirmDelete() {
		if (!(confirm('Are you sure you want to delete this customer?'))) {
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<form:form action="searchCustomer" method="POST">
				Search customer: <input type="text" name="theSearchName"
					placeholder="Introduce a customer name" />
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			<table>
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="customer" items="${customers}">
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>
						<c:url var="deleteLink" value="/customer/deleteCustomer">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>
						<tr>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
							<td><a href="${updateLink}">Update</a>|<a
								href="${deleteLink}"
								onClick="if(!(confirm('Are you sure you want to delete this customer?'))) return false;">Delete</a></td>
							<!-- javascript: confirmDelete(); -->
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div style="clear; both;"></div>
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd; return false;'"
				class="add-button" />
		</div>
	</div>
</body>
</html>