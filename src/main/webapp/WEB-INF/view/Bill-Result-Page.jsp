<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bill-Result-Page</title>
</head>
<body>
<p> 
Bill against the credit card number 
<span style="color: blue">${billDTO.creditCard}</span> 
towards amount <span style="color: blue">${billDTO.amount}</span> 
<span style="color: blue">${billDTO.currency.displayName}</span> generated on <span style="color: blue">${billDTO.date}</span></p>
</body>
</html>