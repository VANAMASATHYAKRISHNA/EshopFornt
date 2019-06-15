<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="userheadder.jsp"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${prolist.stock<5}">
<h1><p>stock was very less it may sold out in soon please complete your order quickly<c:out value="${prolist.stock}"/></p></h1>
</c:if>
<br>
<img src="resources/product-images/${prolist.productId}.jpg" height="100" width="150"/>
<img src="resources/product-images/ ${car.productId}.jpg" height="100" width="150"/>
<br>
productId:-${prolist.productId}${car.productId}
<br>
productName:-${prolist.productName}${car.productName}
<br>
productPrice:-${prolist.productPrice}${car.productPrice}
<br>
productSupplier:-${prolist.productSupplier}${car.productSupplier}
<br>
product stock:-${prolist.stock}
<sform:form action="Cart"  method="post" modelAttribute="car">
<sform:input path="productId" value="${prolist.productId}" type="hidden" />
<sform:input path="productName" value="${prolist.productName}" type="hidden" />
<sform:input path="productPrice" value="${prolist.productPrice}" type="hidden" />
<sform:input path="productSupplier" value="${prolist.productSupplier}" type="hidden" />
<sform:input path="stock" value="${prolist.stock}" type="hidden"/>
Quantity <sform:input type="number" path="quantity" value="${car.quantity}" min="1" max="7"/>
<sform:input  path="cartid" type="hidden" />
<input type="submit" value=" AddToCart">
</sform:form>
<a href="=${prolist.productId}">BuyNow</a>
</body>
</html>