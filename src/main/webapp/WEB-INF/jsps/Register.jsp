<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="userheadder.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
   <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<sform:form action="register"  method="post" modelAttribute="reg">
Email<sform:input path="email"/>
<br>
Password<sform:input path="password"/>
<br>
UserName<sform:input path="username"/>
<br>
MobileNumber<sform:input path="mobilenumber"/>
<br>
ShippingAddress
<br>
HouseNumber<sform:input path="shippingAddress.houseNumber"/>
<br>
StreetName<sform:input path="shippingAddress.streetName"/>
<br>
City<sform:input path="shippingAddress.city"/>
<br>
Country<sform:input path="shippingAddress.country"/>
<br>
Zipcode<sform:input path="shippingAddress.zipcode"/>
<br>
State<sform:input path="shippingAddress.state"/>
<input type="submit"value="Register"/>
</sform:form>
</body>
</html>