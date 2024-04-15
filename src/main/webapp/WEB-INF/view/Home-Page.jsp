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
<title>HomePage</title>
</head>
<body>
<div class="div-2"> 	
<ul>
 <li><h4><a href="${pageContext.request.contextPath}/test">Click here</a> To Go Test</h4></li>
  <li><h4><a href="${pageContext.request.contextPath}/register">Click here</a> To Go Registration</h4></li>
  <li><h4><a href="${pageContext.request.contextPath}/sendEmail">Click here</a> To Send Email</h4></li>
  <li><h4><a href="${pageContext.request.contextPath}/creditCard/bill">Click here</a> to Get Credit Card Bill</h4></li>
  <li><h4><a href="${pageContext.request.contextPath}/showInfo">Click here</a> to Go MyWebsite</h4></li>
</ul>
</div>
	<div class="div-1">
		<h1 align="center">Love Calculator</h1>
		<!--  onsubmit="return validateForm()" -->
		<form:form action="processCalculate" method="post"
			modelAttribute="userInfoDTO">
			<div align="center">
				<div>
					<p>
						<label for="un">Your Name :</label>
						<form:input id="un" path="userName"/>
						<form:errors path="userName" cssClass="error" />
					</p>
				</div>
				<div>
					<p>
						<label for="cn">Crush Name :</label>
						<form:input id="cn" path="crushName"/>
						<form:errors path="crushName" cssClass="error" />
					</p>
				</div>
				<div>
					<p>
						<form:checkbox path="termsAndCondition" id="check"/>
						<label>I am agreeing that this is for fun</label>
						<form:errors path="termsAndCondition" cssClass="error" />
					</p>
				</div>
				<div>
					<p>
						<input type="submit" value="calculate">
					</p>
				</div>
			</div>
		</form:form>
	</div>

</body>
</html>