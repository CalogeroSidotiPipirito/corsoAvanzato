<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New customer</title>
</head>
<body>

	<h1>New customer</h1>
	<form:form method="POST" action="add" modelAttribute="customerInfo">
		<div>
			<form:label path="name">Name</form:label>
			<form:input path="name" />
		</div>
		<div>
			<form:label path="surname">Surname</form:label>
			<form:input path="surname" />
		</div>
		<div>
			<form:label path="cf">Tax code</form:label>
			<form:input path="cf" />
		</div>
		<div>
			<form:label path="phoneNumber">Phone number</form:label>
			<form:input path="phoneNumber" />
		</div>
		<div>
			<form:label path="email">eMail</form:label>
			<form:input path="email" />
		</div>
		<div>
			<input type="submit" value="Send">
		</div>
	</form:form>
</body>
</html>