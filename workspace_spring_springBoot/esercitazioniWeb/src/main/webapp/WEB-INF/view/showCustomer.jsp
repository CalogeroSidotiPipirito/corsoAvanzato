<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show customer</title>
</head>
<body>
	<h1>Show customer</h1>
	<div>${customerInfo.name} ${customerInfo.surname}</div>
	<div>${customerInfo.cf}</div>
	<div>${customerInfo.phoneNumber}</div>
	<div>${customerInfo.email}</div>
</body>
</html>