<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Check Out</title>
		<style type="text/css">
		
		.text {
			color: red;
			text-align: right;
		}
		</style>
	</head>

	<body>
		<div class = text>You are placing an order!</div>
		
		<form action="${pageContext.servletContext.contextPath}/multiplyNumbers" method="post">
			<input type="Submit" name="cancel" value="Cancel Order">
			<input type="Submit" name="thankYou" value="Submit Order">
		</form>
	</body>
</html>