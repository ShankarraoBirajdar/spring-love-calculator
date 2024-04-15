<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/css/App.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/App.js" />"></script>
<title>Bill-Page</title>
</head>
<body>
<div align="center">
<h1>Bill</h1>
<br/>
<form:form action="process-bill" method="post" modelAttribute="billDTO">
<label>Credit Card</label>
<form:input path="creditCard"/>
<form:errors path="creditCard" cssClass="error" />
<br/>
<br/>
<label>Amount</label>
<form:input path="amount"/>
<form:errors path="amount" cssClass="error" />
<br/>
<br/>
<label>Currency</label>
<form:input path="currency"/>
<form:errors path="currency" cssClass="error" />
<br/>
<br/>
<label>Date</label>
<form:input path="date"/>
<form:errors path="date" cssClass="error" />
<br/>
<br/>
<input type="submit" value="Pay Bill"/>
</form:form>
</div>
</body>
</html>