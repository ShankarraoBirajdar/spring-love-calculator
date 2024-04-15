<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/css/App.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/App.js" />"></script>
<title>Registration Page</title>
</head>
<body>
	<h1 align="center">Please Register Here!</h1>
	<div align="center">
		<form:form action="registration-success" method="post"
			modelAttribute="registrationDTO">
			<label for="na">Name :</label>
			<form:input id="na" path="name" />
			<form:errors path="name" cssClass="error" />
			<br />
			<label for="un">User Name :</label>
			<form:input id="un" path="username" />
			<form:errors path="username" cssClass="error" />
			<br />
			<label for="pw">Password :</label>
			<form:password id="pw" path="password" />
			<br />
			<label>Country :</label>
			<form:select path="country">
				<form:option value="ind" label="India"></form:option>
				<form:option value="us" label="United State"></form:option>
				<form:option value="pak" label="Pakistan"></form:option>
				<form:option value="sl" label="Sri lanka"></form:option>
			</form:select>
			<br />
			<label>Hobbies :</label>
		Cricket : <form:checkbox path="hoobies" value="cricket" />
		Reading : <form:checkbox path="hoobies" value="reading" />
		Travel : <form:checkbox path="hoobies" value="travel" />
		Programming : <form:checkbox path="hoobies" value="programming" />
			<br />
			<label>Gender :</label>
		Male <form:radiobutton path="gender" value="male" />
		Female <form:radiobutton path="gender" value="female" />
		<br />
			<label for="ag">Age :</label>
			<form:input id="ag" path="age" />
			<form:errors path="age" cssClass="error" />
			<br />
			<div align="center">
			<h3>Communication</h3>
			<label >Email :</label>
			<form:input id="el" path="communication.email" placeholder="name@gmail.com"/>
			<form:errors path="communication.email" cssClass="error" />
			<br/>
			<label >Phone :</label>
			<form:input id="ph" path="communication.phone" placeholder="+91-1234567890"/>
			</div>
			<br />

			<input type="submit" value="register">
		</form:form>
	</div>
</body>
</html>