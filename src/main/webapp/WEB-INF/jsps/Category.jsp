<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file="AdminHeadder.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix= "sform"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="addcat" modelAttribute="cat" method="post" >
CategoryName <sform:input  path="categoryName"  />
CategoryDiscription <sform:input  path="categoryDiscription" />
<input type="submit" value="AddCategory">
</sform:form>
</body>
</html>