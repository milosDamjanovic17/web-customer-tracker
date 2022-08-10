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
		
			<!-- add our html table here for customerList -->
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				<!-- loop over and print out customerList -->
				<c:forEach var="customerList" items="${customerList }">
				
					<tr>
						<td>${customerList.firstName }</td>
						<td>${customerList.lastName }</td>
						<td>${customerList.email }</td>
					</tr>
				
				</c:forEach>
			</table>
		
		</div>
	
	</div>

</body>
</html>