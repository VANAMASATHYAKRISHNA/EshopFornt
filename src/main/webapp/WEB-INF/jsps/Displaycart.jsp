<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="userheadder.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Carts</title>
</head>
<table  border="2">
<tr>
<th>
cartid
</th>
<th>
productId
</th>
<th>
productName
</th>
<th>
productPrice
</th>
<th>
productSupplier
</th>
<th>
Quantity
</th>
<th>
Totalprice
</th>
<th>
Product-Image
</th>
<th>
Delete
</th>
<th>
Edit
</th>
</tr>
<body>
<c:set var="grandtotal" value="0"></c:set>
<c:forEach items="${cartlist}" var="car">
<tr>
<c:set var="grandtotal" value="${car.totalprice+grandtotal}"></c:set>
<td>${car.cartid}</td>
<td>${car.productId}</td>
<td>${car.productName}</td>
<td>${car.productPrice}</td>
<td>${car.productSupplier}</td>
<td>${car.quantity}</td>
<td>${car.totalprice}</td>
<td><img src="resources/product-images/${car.productId}.jpg" height="100" width="150"/></td>
<td><a href="cdel?cartId=${car.cartid}">Delete</a></td>
<td><a href="cedit?cartId=${car.cartid}">Edit</a></td>
</tr>
</c:forEach>
</table>
GrandTotal:${grandtotal}
<br>
<a href="placeorder">PlaceOrder</a>
</body>
</html>