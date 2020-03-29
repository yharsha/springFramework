<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Student confirmation</title>
</head>
<body>
	
	The Student is confirmed: ${student.firstName} ${student.lastName} 
	
	<br><br>
	
	Country: ${student.country} 
	
	<br><br>
	
	favouriteLanguage:${student.favouriteLanguage}
	
	<br><br>
	
	operating Systems:
	
	<ul>
		<c:forEach var="temp" items="${student.os}">
		<li> ${temp}</li>
		</c:forEach>
	</ul>
	<br><br>
	
	free passes count : ${student.passes}
	<br><br>
	
	
	postal code : ${student.postalCode}
	
	postal code : ${student.courseCode}
	
</body>


</html>