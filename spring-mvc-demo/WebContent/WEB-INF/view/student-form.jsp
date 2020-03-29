<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Student Registration Form</title>
	
	<style>
		.error {color:red}
	</style>
	
</head>
<body>
	
		<form:form action="prcoessFrom" modelAttribute="student">
		First name: <form:input path="firstName"/>
		
		<br><br>
		
		Last name (*): <form:input path="lastName"/>
		
		<form:errors path="lastName" cssClass="error" />
		
		<br><br>
		
		Country : 
		<form:select  path="country">
			<form:options items= "${student.countryOptions}"/>
		
		<!--  
			<form:option value="India" lablel="India" />
			<form:option value="France" lablel="France" />
			<form:option value="Geramny" lablel="Geramny" />
			<form:option value="UAE" lablel="UAE" />
			-->
		</form:select>
		
		<br><br>
		Favorite Language: 
		Java  <form:radiobutton path="favouriteLanguage" value="Java"/>
		C#  <form:radiobutton path="favouriteLanguage" value="C#"/>
		PHP <form:radiobutton path="favouriteLanguage" value="PHP"/>
		Ruby <form:radiobutton path="favouriteLanguage" value="Ruby"/>
		<br><br>
		
		operating systems:
		Linux <form:checkbox path="os" value="linux"/>
		Mac os <form:checkbox path="os" value="Mac os"/>
		Windows <form:checkbox path="os" value="Windows"/>
		
		<br><br>
		
		Free passes : <form:input path="passes"/>
		<form:errors path="passes" cssClass="error"/>
		
		<br><br>
		
		Postal code : <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"/>
		
		<br><br>
		
			Course code : <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"/>
		
		<br><br>
		
		<input type="submit" value="Submit"/>
		</form:form>
</body>


</html>