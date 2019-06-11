<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="userheadder.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${order.id}
${order.user.shippingAddress.houseNumber}
${order.user.shippingAddress.streetName}
${order.user.shippingAddress.city}
${order.user.shippingAddress.state}
${order.user.shippingAddress.country}
${order.user.shippingAddress.zipcode}
${order.user.email}
${order.grandTotal}
${order.purchaseDate}

</body>
</html>