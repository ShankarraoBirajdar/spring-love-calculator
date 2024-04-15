<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Success</title>
</head>
<body>
	<h1>The Registration is successful</h1>
	<h2>The details entered by you are:</h2>
	Name : ${registrationDTO.name}<br />
	UserName : ${registrationDTO.username}<br />
	Password : 
	<c:forEach var="temp" items="${registrationDTO.password}">
	${temp}
	</c:forEach>
	<br />
	Country : ${registrationDTO.country}<br />
	Hobbies : <c:forEach var="temp" items="${registrationDTO.hoobies}">${temp}	</c:forEach>
	<br />
	Gender : ${registrationDTO.gender}
	<br />
	Age : ${registrationDTO.age}
	<br />
	Email : ${registrationDTO.communication.email}
	<br />
	Phone : ${registrationDTO.communication.phone}
</body>
</html>