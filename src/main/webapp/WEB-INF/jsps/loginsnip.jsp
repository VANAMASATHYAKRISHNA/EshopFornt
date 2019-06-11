<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
<%@include file="userheadder.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Baloo+Bhai&display=swap" rel="stylesheet">
<link rel="stylesheet" href="resources/css/loginSnipp.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div id="form">
  <h1>Login</h1>
 <sform:form action="loginsuc"  method="post" modelAttribute="reg">
 
  <sform:input class="text" type="text" name="user" path="email" placeholder="Email"/>
  <input class="text" type="password" name="pass" path="password" placeholder="Password"/>
  <input type="submit" name="submit"  value="Login" class="submit-button"/>
</sform:form>

</div>
</body>
</html>