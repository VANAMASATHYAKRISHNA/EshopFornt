<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="userheadder.jsp"%>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<table  border="2">
<tr>
<th>
Order Id
</th>
<th>
PurchaseDate
</th>
<th>
GrandTotal
</th>
<th>
User 
</th>
<th>
ShippingAddress 
</th>
</head>
<body>
<c:forEach items="${my}" var="m">
<tr>
<td>${m.id}</td>
<td>${m.purchaseDate}</td>
<td>${m.grandTotal}</td>
<td>${m.user.email}</td>
<td>${m.shippingAddress.id}
${m.shippingAddress.houseNumber}
${m.shippingAddress.streetName}
${m.shippingAddress.city}
${m.shippingAddress.state}
${m.shippingAddress.country}
${m.shippingAddress.zipcode}</td>
</c:forEach>
</table>
</body>
</html>