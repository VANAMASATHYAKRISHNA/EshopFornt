<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<title>SK</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<body style="background-color: cyan;">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="userhome">SK Ocean of Jewellery</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Jewellery<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<c:forEach items="${catList}" var="cat">
							<%-- <li><a href="user">${cat.categoryName}</a></li> --%>
							<li><a href="cName?categoryId=${cat.categoryId}">${cat.categoryName}</a></li>
						</c:forEach>
					</ul>
			    <li class="nav-item"><a class="navbar-brand" href="DisplayCart">Displaycart</a></li>
				<li class="nav-item"><a class="navbar-brand" href="myorder">MyOrders</a></li>
				<li class="nav-item"><a class="navbar-brand"href="Registration">Registration</a><li>
				<li class="nav-item"><a class="navbar-brand" href="LOGIN">login</a></li>
				<li class="nav-item"><a class="navbar-brand" href="#">Aboutus</a></li>
				<li class="nav-item"><a class="navbar-brand" href="#">Contactus</a></li>
				<li class="nav-item"><a class="navbar-brand" href="logout">logout</a></li></ul>
		        </div>
	</nav>
</body>
</html>
