<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	<!-- css sheet -->
	<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
	
	<body>
	
	
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship manager </h2>
			</div>
		</div>
		
					<!-- add button -->
		<input type="button" value="Add Customer"
			onclick="window.location.href='showFormForAdd'; return false;"
			class="add-button"
			/>
	
	
		
		<div id="container">
			<div id="content">
			
		
			
			<!-- add out html table -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>email</th>
					<th>Action</th>
				</tr>
		
			<!-- loop over and print customer -->
			<c:forEach var="tempCustomer" items="${customers}">
				
				<!-- construct an update link with cust id -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}"/>
				</c:url>

					<!-- construct an delete link with cust id -->
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${tempCustomer.id}"/>
				</c:url>
				
				
				<tr>
					<td>${tempCustomer.firstName} </td>
					<td>${tempCustomer.lastName} </td>
					<td>${tempCustomer.email} </td>
					<td>
						<a href="${updateLink}">Update</a> 
						|
						<a href="${deleteLink}"
						onclick="if(!(confirm('Are you Sure you want to delete this Customer?'))) return false">Delete</a> 
						
					</td>
				
				</tr>
						
			</c:forEach>
			
			</table>
			
			</div>
		
		</div>
	</body>
</html>