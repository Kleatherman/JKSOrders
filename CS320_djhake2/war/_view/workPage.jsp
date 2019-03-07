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
	<p> This is the WorkPage </p>
		<form action="${pageContext.servletContext.contextPath}/workPage" method="post">
			<div>
				<input name="profilePage" type="submit" value="Profile Page!" />
			</div>
		</form>
	</body>
</html>
