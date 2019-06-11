<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="userheadder.jsp"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix= "sform"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="addship" modelAttribute="ship" method="post" >
HouseNumber <sform:input  path="houseNumber"  />
StreetName<sform:input  path="streetName" />
City<sform:input  path="city" />
State<sform:input  path="state" />
Country<sform:input  path="country" />
Zipcode<sform:input  path="zipcode" />
<input type="submit" value="Next">
</sform:form>
</body>
</html>