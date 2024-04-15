<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Page</title>
</head>
<body>
<h1 align="center">Love Calculator</h1>
<hr>
<br/> ${userInfoDTO.userName} and ${userInfoDTO.crushName} are
<br/>
     ${userInfoDTO.result}
<br/>
<%-- <a href="<c:url  value="/sendEmail"/>"> Send Result to your Email</a> --%>

<a href="/spring-love-calculator/sendEmail"> Send Result to your Email</a>
</body>
</html>