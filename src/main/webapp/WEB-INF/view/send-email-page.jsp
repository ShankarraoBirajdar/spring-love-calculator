<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Email</title>
</head>
<body>
<h1> HI  ${userInfo.userName} </h1>
<h2>Send Result To Your Email</h2>
<form:form action="process-email" method="post" modelAttribute="emailDTO">
<label>Enter Your Email: </label>
<form:input path="userEmail"/>
<input type="submit" value="send">
</form:form>
</body>
</html>