<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lag= "en">
	<head>
		<meta charset ="utf-8">
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	
		<title>Profile Page</title>
		<style type="text/css">
		</style>
	</head>

	<body>
		This is the Profile Page
	
		<form action="${pageContext.servletContext.contextPath}/profilePage" method="post">
			<div>
				<input name="storePage" type="submit" value="Store Page!" />
				<input name="workPage" type="submit" value="Work Page!"/>
			</div>
		</form>
	</body>
</html>