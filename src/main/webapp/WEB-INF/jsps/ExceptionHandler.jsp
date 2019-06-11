<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(exception instanceof ArithmeticException)
	{
	out.print("plz enter non zero denominator");
	}
else
	if (exception instanceof NumberFormatException)
	{
		out.print("plz enter enter number");
	}
	%>

</body>
</html>