<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Work Page</title>
		<style type="text/css">
		</style>
	</head>

	<body>
	<p> Welcome to work </p>
		<form action="${pageContext.servletContext.contextPath}/workPage" method="post">
			<div>
				<input name="profilePage" type="submit" value="Profile Page!" />
				<input name="employeeLogin" type="submit" value="Log out!" />
			</div>
		</form>
	</body>
</html>
