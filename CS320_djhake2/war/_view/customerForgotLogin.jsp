<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Employee Login</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
		}
		</style>
	</head>

	<body>
		<form action="${pageContext.servletContext.contextPath}/customerForgotLogin" method="post">
		<div>
			<input type="Submit" name="LoginPage" value="Go Back">
		</div>
		</form>
	</body>
</html>