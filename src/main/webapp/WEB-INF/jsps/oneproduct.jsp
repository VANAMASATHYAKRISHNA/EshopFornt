<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="userheadder.jsp"%>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${prolist.stock<5}">
<h1><p color="green">stock was very less it may sold out in soon please complete your order quickly</p></h1>
</c:if>
<br>
<img src="resources/product-images/${prolist.productId}.jpg" height="100" width="150"/>
<br>
productId:-${prolist.productId}
<br>
productName:-${prolist.productName}
<br>
productPrice:-${prolist.productPrice}
<br>
productSupplier:-${prolist.productSupplier}
<br>
supplierAddress:-${suplist.supplierAddress}
<br>
product stock:-<td>${prolist.stock }</td>
<form action="Cart" >
Quantity<input type="number" name="k"max="7"min="1">
<input type="hidden"  name="s" value="${prolist.productId}" >
<input type="submit" value=" AddToCart">
</form>
<a href="=${prolist.productId}">BuyNow</a>
 </tr>
 </table>
</body>
</html>