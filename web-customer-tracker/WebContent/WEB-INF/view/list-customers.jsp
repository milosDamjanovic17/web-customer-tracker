<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>List Of Customers</title>
	
	<!-- reference our style sheet -->
	<link type=text/css
		  rel="stylesheet"
		  href="${pageContext.request.contextPath }/resources/css/style.css"/>
</head>

<body>


	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
			/>
		
			<!-- add our html table here for customerList -->
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<!-- loop over and print out customerList -->
				<c:forEach var="customerList" items="${customerList }">
					
					<!-- construct an "update" link with EMBEDED customerId -->
					
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${customerList.id }"></c:param>
					</c:url>
					
					
					<!-- construct an delete link with EMBEDED customerId -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${customerList.id }"></c:param>
					</c:url>
				
					<tr>
						<td>${customerList.firstName }</td>
						<td>${customerList.lastName }</td>
						<td>${customerList.email }</td>
												
						<td>
							<!-- display the update link, OVO CE EMBEDOVATI customerId I KAD SE KLIKNE NA UPDATE BUTTON PROSLEDICE NA SLEDECU I customerId I BICE HIDDEN-->
							<a href="${updateLink }">Update</a>
							|
							<a href="${deleteLink }"
								onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
				
				</c:forEach>
			</table>
		
		</div>
	
	</div>

</body>
</html>